package edu.curtin.app;

import java.util.*;
import java.io.*;

//Context class of strategy pattern for searching, searches polymorphically depending on the criteria
public class SearchFileSystem
{
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
    public Map<Integer, String> search(File file, String pSearchCriteria)
    {
        //from input criteria, extract +/- and t/r
        String incOrExc = Character.toString(pSearchCriteria.charAt(0));
        String textOrRegex = Character.toString(pSearchCriteria.charAt(2));

        //Get appropriate strategies depending on criteria entered - polymorphism
        SearchStrategy ss = SearchStrategies.get(textOrRegex);
        FilterStrategy fs = FilterStrategies.get(incOrExc);

        if(ss == null || fs == null)
        {
            throw new IllegalArgumentException("Invalid Search Criteria");
        }

        SearchResults getTextOrRegex = ss.matchesCriteria(file, pSearchCriteria); //get appropriate search strategy (t/r) and store results in SearchResults object 
        Map<Integer, String> filteredSearchResults = fs.filter(getTextOrRegex); //get appropriate inc/exc strategy and store results in Map with fully filtered search results

        return filteredSearchResults; //Map with lin num + text of searched and inc/exc results
    }
}
