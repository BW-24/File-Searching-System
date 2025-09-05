package edu.curtin.app;

import java.io.*;
import java.util.*;

public class OutputShow 
{
    public static void showLines(DirectoryComposite root, String indent)
    {
        System.out.println(indent + root.getDirectory().getName());

        for(FileSystemComponent file : root.fileTree)
        {
            if (file instanceof FileLeaf leaf)
            {
                System.out.println(leaf.getFile().getName());
                if (leaf.matchingCriteria != null && !leaf.matchingCriteria.isEmpty()) 
                {
                    for (Map.Entry<Integer, String> entry : leaf.matchingCriteria.entrySet()) 
                    {
                        System.out.println(indent + entry.getKey() + " " + entry.getValue());
                    }
                }
            } 
            else if (file instanceof DirectoryComposite directory) 
            {
                showLines(directory, indent + "  ");
            } 
        }
    }
}
