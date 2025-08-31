package edu.curtin.app;

import java.util.*;
import java.io.*;

public class SearchFileSystem
{
    private Map<String, SearchCriteria> SearchStrategies= new HashMap<>();

    public SearchFileSystem()
    {
        SearchStrategies.put("t", new TextCriteria());
        SearchStrategies.put("r", new RegexCriteria());
        SearchStrategies.put("+", new IncludeCriteria());
        SearchStrategies.put("-", new ExcludeCriteria());
    }

    public void Search(File file, String pSearchCriteria)
    {
        String incOrExc = Character.toString(pSearchCriteria.charAt(1));
        String textOrRegex = Character.toString(pSearchCriteria.charAt(3));

        SearchCriteria sc1 = SearchStrategies.get(incOrExc);
        SearchCriteria sc2 = SearchStrategies.get(textOrRegex);

        if(sc1 == null || sc2 == null)
        {
            throw new IllegalArgumentException("Invalid Search Criteria");
        }

        boolean getTextOrRegex = sc2.matchesCriteria(file, pSearchCriteria);
        boolean incOrExcTextOrRegex = sc1.matchesCriteria(file, pSearchCriteria);
    }
}
