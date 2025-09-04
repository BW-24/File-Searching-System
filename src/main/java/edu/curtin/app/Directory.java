package edu.curtin.app;

import java.io.File;
import java.util.*;

public class Directory extends FileSystemComponent
{
    public File directory;
    List<FileSystemComponent> fileTree = new ArrayList<>();

    public Directory(File pDirectory) { directory = pDirectory; }

    public File getDirectory()
    {
        return directory;
    }

    //The application must take an optional command-line parameter, which must be the name of a directory. 
    // If no directory name is given, then the current directory “.” must be used instead.

    public List<FileSystemComponent> loadContent(String pDirectory) //return FileSysComponent??
    {
        //error/exc check empty? what about empty subdirectories?

        //Create file obj with built in class
        File dir = new File(pDirectory);

        //Store in array
        File[] dirContents = dir.listFiles();
        //null check
        if (dirContents == null) return null;
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
        return fileTree;
    } 

    @Override 
    public FileSystemComponent find(String pCriteria)
    {
        for(FileSystemComponent fileSystemComponent : fileTree)
        {
            FileSystemComponent found = fileSystemComponent.find(pCriteria); // Recurse
            if(found != null) { return found; }
        }
        return null;
    }
}
