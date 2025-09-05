package edu.curtin.app;

import java.io.*;
import java.util.*;

public class IncludeFilter implements FilterStrategy
{
    //takes a search results object and returns the matched line class field in a map
    public Map<Integer, String> filter(SearchResults searchResults)
    { 
        Map<Integer, String> filteredSearch = searchResults.getMatches();
        return filteredSearch;
    }
}
