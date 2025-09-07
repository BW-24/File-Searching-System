package edu.curtin.app;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class TextCriteria implements SearchStrategy
{
    private static final Logger logger = Logger.getLogger(TextCriteria.class.getName());

    //Finds lines matching text criteria from all lines and returns a search result object
    public SearchResults matchesCriteria(List<String> allLines, String pCriteria)
    {
        String text = pCriteria.substring(4);
        Map<Integer, String> lineMatches = new HashMap<>();
        
        for(int i = 0; i < allLines.size(); i++)
        {
            if(allLines.get(i).contains(text))
            {
                lineMatches.put(i+1, allLines.get(i));
            }
        }
        SearchResults searchResults = new SearchResults(allLines, lineMatches);
        logger.info("Text criteria applied to file");
        return searchResults;
    }
}
