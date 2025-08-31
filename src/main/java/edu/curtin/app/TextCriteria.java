package edu.curtin.app;

import java.io.*;

public class TextCriteria implements SearchCriteria
{
    public boolean matchesCriteria(File file, String pCriteria)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while((line = reader.readLine()) != null) 
            {
                if(line.contains(pCriteria));
                return true; 
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return false;
    }
}
