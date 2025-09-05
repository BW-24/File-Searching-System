package edu.curtin.app;

import java.io.*;
import java.util.*;

//Leaf component of file system composite structure
public class FileLeaf extends FileSystemComponent
{
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
    public void find(String pCriteria) //should probs be findMatches
    {
        SearchFileSystem searchFileSystem = new SearchFileSystem();
        Map<Integer, String> filteredSearchResults = searchFileSystem.search(file, pCriteria); //search
        
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