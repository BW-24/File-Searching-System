package edu.curtin.app;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.util.logging.*;

//Context class of strategy pattern for searching, searches polymorphically depending on the criteria
public class SearchFileSystem
{
    private static final Logger logger = Logger.getLogger(SearchFileSystem.class.getName());
    private Map<String, SearchStrategy> SearchStrategies= new HashMap<>();
    private Map<String, FilterStrategy> FilterStrategies= new HashMap<>();

    //init strategies
    public SearchFileSystem()
    {
        SearchStrategies.put("t", new TextCriteria());
        SearchStrategies.put("r", new RegexCriteria());
        FilterStrategies.put("+", new IncludeFilter());
        FilterStrategies.put("-", new ExcludeFilter());
    }

    //Searches file and returns included lines from file depending on search criteria
    public Map<Integer, String> search(File file, List<String> pSearchCriteria)
    {
        Map<Integer, String> filteredSearchResults;
        Map<Integer, String> linesMatchingAllCriteria = new HashMap<>(); //final map with included lines that match all criteria
        List<String> allLines = new ArrayList<>();

        //read all lines from file into a list
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
        { 
            String line;
            while((line = reader.readLine()) != null) { allLines.add(line); }
        } catch (IOException e)
        {
            logger.severe("Error reading file: text" + file.getName());
            e.getMessage();
        }

        logger.info("File read into system - ready to be searched" + file.getName());

        for (int i = 0; i < allLines.size(); i++) 
        {
            linesMatchingAllCriteria.put(i + 1, allLines.get(i)); //put all lines into a map, then remove them if they dont match criteria
        }   

        for(String criteria : pSearchCriteria) //apply each criteria
        {
            //from input criteria, extract +/- and t/r
            String incOrExc = Character.toString(criteria.charAt(0));
            String textOrRegex = Character.toString(criteria.charAt(2));

            //Get appropriate strategies depending on criteria entered - polymorphism
            SearchStrategy ss = SearchStrategies.get(textOrRegex);
            FilterStrategy fs = FilterStrategies.get(incOrExc);

            if(ss == null || fs == null)
            {
                logger.warning("Search or filter strategy are null");
                throw new IllegalArgumentException("Invalid Search Criteria");
            }

            SearchResults getTextOrRegex = ss.matchesCriteria(allLines, criteria); //get appropriate search strategy (t/r) and store results in SearchResults object 
            filteredSearchResults = fs.filter(getTextOrRegex); //get appropriate inc/exc strategy and store results in Map with fully filtered search results
            linesMatchingAllCriteria.keySet().retainAll(filteredSearchResults.keySet()); 
            /*^^retain elements that are in filtered search results (all included lines with current criteria)
             * when all criterias are iteratd through, only the lines that match all of them will be left.
            */
        }
        logger.info("File searched: " + file.getName());
        return linesMatchingAllCriteria; //Map with lin num + text of searched and inc/exc results that match all criteria.
    }
}
