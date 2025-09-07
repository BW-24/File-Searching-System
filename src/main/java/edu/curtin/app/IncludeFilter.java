package edu.curtin.app;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class IncludeFilter implements FilterStrategy
{
    private static final Logger logger = Logger.getLogger(IncludeFilter.class.getName());
    //takes a search results object and returns the matched line class field in a map
    public Map<Integer, String> filter(SearchResults searchResults)
    { 
        Map<Integer, String> filteredSearch = searchResults.getMatches();
        logger.info("Include filter reached");
        return filteredSearch;
    }
}
