package edu.curtin.app;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class ExcludeFilter implements FilterStrategy
{
    private static final Logger logger = Logger.getLogger(ExcludeFilter.class.getName());
    //Function filters out matched lines contained in SearchResults objects and returns them in a map with line number (key) and text (value)
    public Map<Integer, String> filter(SearchResults searchResults)
    {
        Map<Integer, String> filteredSearch = new HashMap<>(); //Create map to store matching lines
        List<String> allLines = searchResults.getAllLines(); //extract all lines and matching lines from search results objects
        Map<Integer, String> matches = searchResults.getMatches();

        if(allLines == null || matches == null) 
        { 
            logger.warning("Exclude Filter: some search results are null");
            throw new NullPointerException("Field(s) in search results are null"); 
        }
       
        Set<Integer> matchedLines = matches.keySet(); //extract keys from matching line (line numbers)

        for (int i = 0; i < allLines.size(); i++) 
        { 
            if (!matchedLines.contains(i+1)) //if matched lines doesnt contain the line number from all lines
            {
                filteredSearch.put(i+1, allLines.get(i)); //put the line number in filtered search with the corresponding line text
            }
        }
        logger.info("Exclude filter reached");
        return filteredSearch;
    }
}
