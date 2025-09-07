package edu.curtin.app;

import java.io.*;
import java.util.*;
import java.util.logging.*;

//Leaf component of file system composite structure
public class FileLeaf extends FileSystemComponent
{
    private static final Logger logger = Logger.getLogger(FileLeaf.class.getName());
    //class fields
    public File file;
    public Map<Integer, String> matchingCriteria;
    public int count;

    //setter
    public FileLeaf(File pFile) 
    { 
        file = pFile;
        matchingCriteria = null;
    }

    //getter
    public File getFile() { return file; }

    //finds criteria matching lines by searching file objects, sets files matching criteria field to the results fom search; map with lineNum (key) and matching text (value)
    // also sets count of matching lines to each file object
    @Override 
    public void findInclusions(List<String> pCriteria) 
    {
        SearchFileSystem searchFileSystem = new SearchFileSystem();
        Map<Integer, String> filteredSearchResults = searchFileSystem.search(file, pCriteria); //search
        logger.info(() -> "Searching through" + this.getFile().getName());
        this.matchingCriteria = filteredSearchResults; //apply searchresults to matching criteria field of file object
        this.setCount(); // apply count now that matching lines have been added to object
    }

    public void setCount()
    {
        int size = 0;
        for(Map.Entry<Integer, String> lines : matchingCriteria.entrySet())
        {
            size += 1;
        }
        count = size;
    }

    public int count()
    {
        return count;
    }
}