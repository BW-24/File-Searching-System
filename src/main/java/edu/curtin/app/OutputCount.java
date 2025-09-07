package edu.curtin.app;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class OutputCount 
{   
    //Prints lines in count output format
    public static void showCount(DirectoryComposite root, String indent)
    {
        System.out.println(indent + root.getDirectory().getName() + ": " + root.count() + " lines"); //print dir + total lines

       for (FileSystemComponent file : root.fileTree) 
        {
            if (file instanceof FileLeaf leaf) 
            {
                System.out.println(indent + "  " + leaf.getFile().getName() + ": " + leaf.count + " lines");
            } 
            else if (file instanceof DirectoryComposite directory) //if dir recurse into directory
            {
                showCount(directory, indent + "  ");
            }
        }
    }
}
