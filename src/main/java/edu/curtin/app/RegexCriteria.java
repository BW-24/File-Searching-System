package edu.curtin.app;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCriteria 
{
    public boolean matchesCriteria(File file, String pCriteria)
    {
        String regex = pCriteria;

        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = reader.readLine()) != null) 
            {
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(line);
                if(m.find()) 
                { 
                    return true; 
                }
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return false;
    }
}
