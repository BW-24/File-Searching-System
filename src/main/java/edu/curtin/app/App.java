package edu.curtin.app;

import java.io.File;
import java.util.*;

/**
 * Entry point into the application. To change the package, and/or the name of this class, make
 * sure to update the 'mainClass = ...' line in build.gradle.
 */
public class App
{
    public static void main(String[] argv)
    {
        String dir;

        if(argv.length > 1) { throw new IllegalArgumentException("Cannot name more than one file."); }
        
        if(argv.length == 1)
        {
            dir = argv[1];
        }
        else
        {
            dir = ".";
        }
        
        File currentDir = new File(dir);

        DirectoryComposite root = new DirectoryComposite(currentDir);
        root.loadContent(dir);

        String criteria1 = "+ t Integer";
        String criteria2 = "+ r \"[^\"]*\"";
        String criteria3 = "- t File";
        String criteria4 = "- r \"[^\"]*\"";

        root.find(criteria4);

        for(FileSystemComponent file : root.fileTree)
        {
            if (file instanceof DirectoryComposite directory) 
            {
                System.out.println(directory.getDirectory().getName());
            } 
            else if (file instanceof FileLeaf leaf) 
            {
                System.out.println(leaf.getFile().getName());
                if (leaf.matchingCriteria != null && !leaf.matchingCriteria.isEmpty()) 
                {
                    for (Map.Entry<Integer, String> entry : leaf.matchingCriteria.entrySet()) 
                    {
                        System.out.println(entry.getKey() + " " + entry.getValue());
                    }
                }
            }
        }
    }
}


