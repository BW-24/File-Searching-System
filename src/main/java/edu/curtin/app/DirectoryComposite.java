package edu.curtin.app;

import java.io.File;
import java.util.*;

public class DirectoryComposite extends FileSystemComponent
{
    public File directory;
    List<FileSystemComponent> fileTree = new ArrayList<>();

    public DirectoryComposite(File pDirectory) { directory = pDirectory; }

    public File getDirectory() { return directory; }

    public void loadContent(String pDirectory) //return FileSysComponent??
    {
        //error/exc check empty? what about empty subdirectories?

        //Create file obj with built in class
        File dir = new File(pDirectory);

        //Store in array
        File[] dirContents = dir.listFiles();

        if(dirContents != null)
            Arrays.sort(dirContents);
        //null check
    
        //iterate through
        for(File file : dirContents)
        { 
            if(file.isDirectory()) //if directory
            {
                if (file.isDirectory() && !file.isHidden() && !file.getName().startsWith("."))
                {
                    DirectoryComposite subDir = new DirectoryComposite(file); //create dir obj
                    fileTree.add(subDir); //add to filetree list
                    subDir.loadContent(file.getAbsolutePath()); //recurse
                    //fileTree.addAll(subDir.fileTree);
                }
            }
            else
            {
                String name = file.getName().toLowerCase();
                if (file.isFile() && (name.endsWith(".java") || name.endsWith(".txt") || name.endsWith(".csv")))
                {  
                    fileTree.add(new FileLeaf(file));
                }
            }
        }
    } 

    @Override 
    public void find(String pCriteria)
    {
        for(FileSystemComponent fileSystemComponent : fileTree)
        {
            fileSystemComponent.find(pCriteria); // Recurse
        }
    }

    @Override
    public int count()
    {
        int size = 0;
        for(FileSystemComponent fileSystemComponent : fileTree)
        {
            fileSystemComponent.count();
        }
        return size;
    }
}
