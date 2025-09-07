package edu.curtin.app;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.logging.*;

public class RegexCriteria implements SearchStrategy
{
    private static final Logger logger = Logger.getLogger(RegexCriteria.class.getName());
    //Reads file object and returns a search result object with matching line and all lines.
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
                allLines.add(line); //add every line to the allLines field
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(line); //Look for regex matches with Pattern class
                if(m.find()) //if match found put the line in line matches
                { 
                    lineMatches.put(lineNumber, line); 
                }
                lineNumber++;
            }
            logger.info(() -> "file read into system: Regex" + file.getName());
            SearchResults searchResults = new SearchResults(allLines, lineMatches); //Create search results object and return it 

            return searchResults;
        } catch (IOException e) 
        {
            logger.severe("Error in file read: Regex");
            e.getMessage();
        }
        return null;
    }
}
