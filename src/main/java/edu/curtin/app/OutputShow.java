package edu.curtin.app;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class OutputShow 
{
    //Prints lines in show output format
    public static void showLines(DirectoryComposite root, String indent)
    {
        System.out.println(indent + root.getDirectory().getName()); //print dir name

        for(FileSystemComponent file : root.fileTree) 
        {
            if (file instanceof FileLeaf leaf) //if file
            {
                System.out.println(indent + "  " + leaf.getFile().getName());
                if (leaf.getMatchingCriteria() != null && !leaf.getMatchingCriteria().isEmpty()) //if file contains included lines
                {
                    for (Map.Entry<Integer, String> entry : leaf.getMatchingCriteria().entrySet()) 
                    {
                        System.out.println(indent + "    " + entry.getKey() + " " + entry.getValue()); //Print included lines
                    }
                }
            } 
            else if (file instanceof DirectoryComposite directory) //Else if dir, recurse and increase indent
            {
                showLines(directory, indent + "  ");
            } 
        }
    }
}
