package edu.curtin.app;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class RegexCriteria implements SearchStrategy
{
    public SearchResults matchesCriteria(File file, String pCriteria)
    {
        String regex = pCriteria.substring(4);

        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            int lineNumber = 1;
            List<String> allLines = new ArrayList<>();
            Map<Integer, String> lineMatches = new HashMap<>();
            while((line = reader.readLine()) != null) 
            {   
                allLines.add(line);
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(line);
                if(m.find()) 
                { 
                    lineMatches.put(lineNumber, line); 
                }
                lineNumber++;
            }

            SearchResults searchResults = new SearchResults(allLines, lineMatches);

            return searchResults;
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
}
