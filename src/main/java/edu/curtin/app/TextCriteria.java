package edu.curtin.app;

import java.io.*;
import java.util.*;


public class TextCriteria implements SearchCriteria
{
    //returns the line num the txt is located on in an array
    public Map<Integer, String> matchesCriteria(File file, String pCriteria)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            int lineCount = 1;
            Map<Integer, String> lineNumberMatches = new HashMap<>();
            while((line = reader.readLine()) != null) 
            {
                if(line.contains(pCriteria))
                {
                    lineNumberMatches.put(lineCount, line);
                }
                lineCount++; 
            }
            return lineNumberMatches;
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return null; //FIX
    }
}
