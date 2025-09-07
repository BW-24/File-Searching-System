package edu.curtin.app;

import java.util.*;
import java.util.logging.*;

//Class to create SearchResults object - needed mainly for exclusion criteria, to store all lines and matched lines in the same object to then compare and exclude correct lines
public class SearchResults 
{
    private List<String> allLines;  
    private Map<Integer, String> matches;

    public SearchResults(List<String> pAllLines, Map<Integer, String> pMatches)
    {
        allLines = pAllLines;
        matches = pMatches;
    }

    public List<String> getAllLines() { return allLines; }
    public Map<Integer, String> getMatches() { return matches; }


    
}
