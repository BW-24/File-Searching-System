package edu.curtin.app;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.logging.*;

public class RegexCriteria implements SearchStrategy
{
    private static final Logger logger = Logger.getLogger(RegexCriteria.class.getName());

    //Looks for regex matches in allLines of file, returns map with line number and matching text
    public SearchResults matchesCriteria(List<String> allLines, String pCriteria)
    {
        String regex = pCriteria.substring(4);
        Map<Integer, String> lineMatches = new HashMap<>();

        for(int i = 0; i < allLines.size(); i++)
        {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(allLines.get(i)); //Look for regex matches with Pattern class
            if(m.find()) //if match found put the line in line matches
            { 
                lineMatches.put(i+1, allLines.get(i)); 
            }
        }
        SearchResults searchResults = new SearchResults(allLines, lineMatches); //Create search results object and return it 
        logger.info("Regex criteria applied to file"); 
        return searchResults;
    }
}
