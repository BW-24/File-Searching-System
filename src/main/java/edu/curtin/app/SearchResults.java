package edu.curtin.app;

import java.util.*;

public class SearchResults 
{
    List<String> allLines;  
    Map<Integer, String> matches;

    public SearchResults(List<String> pAllLines, Map<Integer, String> pMatches)
    {
        allLines = pAllLines;
        matches = pMatches;
    }

    public List<String> getAllLines() 
    {
        return allLines;
    }

    public Map<Integer, String> getMatches() 
    {
        return matches;
    }


    
}
