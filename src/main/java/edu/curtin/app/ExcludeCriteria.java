package edu.curtin.app;

import java.io.*;
import java.util.*;

public class ExcludeCriteria implements SearchCriteria
{
    public void exclude(File file, Map<Integer, String> pLineNumberMatches)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            int lineNumber = 1;

            outerWhile:
            while((line = reader.readLine()) != null) 
            {
                for(Map.Entry<Integer, String> entry : pLineNumberMatches.entrySet())
                {
                    if(line.contains(entry.getValue()))
                    {
                        lineNumber++; 
                        continue outerWhile;
                    }
                    else
                    {
                        System.out.println(lineNumber + ". " + line);
                        lineNumber++;
                    }
                }
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
