package edu.curtin.app;

import java.io.*;
import java.util.*;


public class TextCriteria implements SearchStrategy
{
    //Reads file object and returns a search result object with matching line and all lines.
    public SearchResults matchesCriteria(File file, String pCriteria)
    {
        String text = pCriteria.substring(4);

        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            int lineNum = 1;
            List<String> allLines = new ArrayList<>();
            Map<Integer, String> lineMatches = new HashMap<>();
            
            while((line = reader.readLine()) != null) 
            {
                allLines.add(line); //Store every line in file in allLines
                if(line.contains(text)) //if line contains text (match) include it in lineMatches with lineNum and text
                {
                    lineMatches.put(lineNum, line);
                }
                lineNum++; 
            }
            
            SearchResults searchResults = new SearchResults(allLines, lineMatches); //create search results object and return it

            return searchResults;
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return null; 
    }
}
