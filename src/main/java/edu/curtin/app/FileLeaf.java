package edu.curtin.app;

import java.io.*;
import java.util.*;

public class FileLeaf extends FileSystemComponent
{
    public File file;
    public Map<Integer, String> matchingCriteria;

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
    }
}