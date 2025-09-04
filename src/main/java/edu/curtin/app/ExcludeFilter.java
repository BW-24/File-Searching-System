package edu.curtin.app;

import java.io.*;
import java.util.*;

public class ExcludeFilter implements FilterStrategy
{
    public Map<Integer, String> filter(SearchResults searchResults)
    {
        Map<Integer, String> filteredSearch = new HashMap<>();
        List<String> allLines = searchResults.getAllLines();  
        Map<Integer, String> matches = searchResults.getMatches();
       
        Set<Integer> matchedLines = matches.keySet();

        for (int i = 0; i < allLines.size(); i++) 
        { 
            if (!matchedLines.contains(i+1)) 
            {
                filteredSearch.put(i+1, allLines.get(i));
            }
        }
            return filteredSearch;
    }
}
