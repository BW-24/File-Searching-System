package edu.curtin.app;

import java.io.File;
import java.util.*;

public class Loader 
{
    public File[] loadContent(String pDirectory) //return FileSysComponent??
    {
        //error/exc check empty? what about empty subdirectories?

        //Create file obj with built in class
        File dir = new File(pDirectory);

        //Store in array
        File[] dirContents = dir.listFiles();
        //null check
        if (dirContents == null) return new File[0];
        //iterate through
        for(File file : dirContents)
        { 
            if(file.isDirectory()) //if directory
            {
                Directory subDir = new Directory(file); //create dir obj
                fileTree.add(subDir); //add to filetree list
                subDir.loadContent(file.getAbsolutePath()); //recurse
                fileTree.addAll(subDir.fileTree);
            }
            else
            {
                FileLeaf fileLeaf = new FileLeaf(file);
                fileTree.add(fileLeaf);
            }
        }
        return dirContents;
    } 
}
