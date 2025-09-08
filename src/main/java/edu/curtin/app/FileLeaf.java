package edu.curtin.app;

import java.io.*;
import java.util.*;
import java.util.logging.*;

//Leaf component of file system composite structure
public class FileLeaf extends FileSystemComponent
{
    private static final Logger logger = Logger.getLogger(FileLeaf.class.getName());
    //class fields
    private File file;
    private Map<Integer, String> matchingCriteria;
    private int count;

    //setter
    public FileLeaf(File pFile) 
    { 
        file = pFile;
        matchingCriteria = null;
    }

    //getter
    public File getFile() { return file; }
    public Map<Integer, String> getMatchingCriteria() { return matchingCriteria; }

    //finds criteria matching lines by searching file objects, sets files matching criteria field to the results fom search; map with lineNum (key) and matching text (value)
    // also sets count of matching lines to each file object
    @Override 
    public void findInclusions(List<String> pCriteria) 
    {
        SearchFileSystem searchFileSystem = new SearchFileSystem();
        Map<Integer, String> filteredSearchResults = searchFileSystem.search(file, pCriteria); //search
        logger.info(() -> "Searching through" + this.getFile().getName());
        this.matchingCriteria = filteredSearchResults; //apply searchresults to matching criteria field of file object
        if(this.matchingCriteria == null) //Matching criteria should not be null, even if filteredSearchResults is empty
        {
            logger.severe("Matching criteria is null" + this.getFile().getName());
            throw new IllegalStateException("Matching criteria is null" + this.getFile().getName());
        }
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