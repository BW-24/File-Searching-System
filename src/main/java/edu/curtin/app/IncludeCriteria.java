package edu.curtin.app;

import java.io.*;
import java.util.*;

public class IncludeCriteria implements SearchCriteria
{
    public void include(Map<Integer, String> pLineNumberMatches)
    {
       for(Map.Entry<Integer, String> line : pLineNumberMatches.entrySet())
       {
            System.out.print(line.getKey() + ". " + line.getValue());
       }
    }
}
