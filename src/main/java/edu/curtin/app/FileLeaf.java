package edu.curtin.app;

import java.io.*;
import java.util.*;

public class FileLeaf extends FileSystemComponent
{
    public File file;
    public Map<Integer, String> matchingCriteria;
    public int count;

    public FileLeaf(File pFile) 
    { 
        file = pFile;
        matchingCriteria = null;
    }

    public File getFile() { return file; }

    @Override 
    public void find(String pCriteria) //should probs be findMatches
    {
        SearchFileSystem searchFileSystem = new SearchFileSystem();
        Map<Integer, String> filteredSearchResults = searchFileSystem.search(file, pCriteria);
        
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