package edu.curtin.app;

import java.io.File;
import java.util.*;
import java.util.logging.*;

public class DirectoryComposite extends FileSystemComponent
{
    //class fields
    public File directory;
    public int count;

    private static final Logger logger = Logger.getLogger(DirectoryComposite.class.getName());
    List<FileSystemComponent> fileTree = new ArrayList<>();
    //setter
    public DirectoryComposite(File pDirectory) { directory = pDirectory; }
    //getter
    public File getDirectory() { return directory; }

    //loads content from given root directory into system, turns dir into Directory objects, files into File objects
    public void loadContent(String pDirectory) 
    {
        //Create file obj with built in class
        File dir = new File(pDirectory);

        //Store dir contents in array
        File[] dirContents = dir.listFiles();

        if(dirContents == null) { throw new IllegalStateException("Directory is empty."); } //stop program if directory is empty

        Arrays.sort(dirContents);
    
        //iterate through
        for(File file : dirContents)
        { 
            if(file.isDirectory()) //if directory
            {
                if (!file.isHidden() && !file.getName().startsWith(".")) //dont inc hidden directories
                {
                    logger.info(() -> "loading" + file.getName() + "into system");
                    DirectoryComposite subDir = new DirectoryComposite(file); //create dir obj
                    fileTree.add(subDir); //add to filetree list
                    subDir.loadContent(file.getAbsolutePath()); //recurse - into sub directories contents
                }
            }
            else
            {
                String name = file.getName().toLowerCase();
                if (file.isFile() && (name.endsWith(".java") || name.endsWith(".txt") || name.endsWith(".csv"))) //maybe change
                {  
                    logger.info(() -> "loading" + file.getName() + "into system");
                    fileTree.add(new FileLeaf(file)); //create file object
                }
            }
        }
    } 

    //composite find function, finds lines within directory that match criteria, recurses into file objects
    @Override 
    public void findInclusions(String pCriteria) 
    {
        for(FileSystemComponent fileSystemComponent : fileTree)
        {
            fileSystemComponent.findInclusions(pCriteria); // Recurse
        }
    }

    //composite count function, returns count of matching lines in dir, recurses into file objects
    @Override
    public int count()
    {
        int size = 0;
        for(FileSystemComponent fileSystemComponent : fileTree)
        {
            size += fileSystemComponent.count(); 
        }
        return size;
    }
}
