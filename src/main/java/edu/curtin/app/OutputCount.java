package edu.curtin.app;

import java.io.*;
import java.util.*;

public class OutputCount 
{
    public static void showCount(DirectoryComposite root, String indent)
    {
       for (FileSystemComponent file : root.fileTree) 
        {
            if (file instanceof FileLeaf leaf) 
            {
                System.out.println(indent + "  " + leaf.getFile().getName() + ": " + leaf.count + " lines");
            } 
            else if (file instanceof DirectoryComposite directory) 
            {
                showCount(directory, indent + "  ");
            }
        }
    }
}
