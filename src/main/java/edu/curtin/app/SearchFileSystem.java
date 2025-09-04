package edu.curtin.app;

import java.util.*;
import java.io.*;

public class SearchFileSystem
{
    private Map<String, SearchStrategy> SearchStrategies= new HashMap<>();
    private Map<String, FilterStrategy> FilterStrategies= new HashMap<>();

    public SearchFileSystem()
    {
        SearchStrategies.put("t", new TextCriteria());
        SearchStrategies.put("r", new RegexCriteria());
        FilterStrategies.put("+", new IncludeFilter());
        FilterStrategies.put("-", new ExcludeFilter());
    }

    public Map<Integer, String> search(File file, String pSearchCriteria)
    {
        String incOrExc = Character.toString(pSearchCriteria.charAt(0));
        String textOrRegex = Character.toString(pSearchCriteria.charAt(2));

        SearchStrategy ss = SearchStrategies.get(textOrRegex);
        FilterStrategy fs = FilterStrategies.get(incOrExc);

        if(ss == null || fs == null)
        {
            throw new IllegalArgumentException("Invalid Search Criteria");
        }

        SearchResults getTextOrRegex = ss.matchesCriteria(file, pSearchCriteria);
        Map<Integer, String> filteredSearchResults = fs.filter(getTextOrRegex);

        return filteredSearchResults; //Map with lin num + text of searched and inc/exc results
    }
}
