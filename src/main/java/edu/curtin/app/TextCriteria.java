package edu.curtin.app;

import java.io.*;
import java.util.*;


public class TextCriteria implements SearchStrategy
{
    //returns the line num the txt is located on in an array
    public SearchResults matchesCriteria(File file, String pCriteria)
    {
        String text = pCriteria.substring(4);

        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            int lineCount = 1;
            List<String> allLines = new ArrayList<>();
            Map<Integer, String> lineMatches = new HashMap<>();
            while((line = reader.readLine()) != null) 
            {
                allLines.add(line);
                if(line.contains(text))
                {
                    lineMatches.put(lineCount, line);
                }
                lineCount++; 
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
