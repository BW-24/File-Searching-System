package edu.curtin.app;

import java.io.*;
import java.util.*;

public class IncludeFilter implements FilterStrategy
{
    public Map<Integer, String> filter(SearchResults searchResults)
    { 
        Map<Integer, String> filteredSearch = searchResults.getMatches();
        return filteredSearch;
    }
}
