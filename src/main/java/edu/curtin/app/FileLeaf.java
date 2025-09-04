package edu.curtin.app;

import java.io.*;
import java.util.*;

public class FileLeaf extends FileSystemComponent
{
    public File file;
    public Map<Integer, String> contents;

    public FileLeaf(File pFile) 
    { 
        file = pFile;
        contents = null;
    }

    public File getFile() { return file; }

    @Override 
    public FileSystemComponent find(String pCriteria)
    {
        SearchFileSystem searchFileSystem = new SearchFileSystem();
        Map<Integer, String> filteredSearchResults = searchFileSystem.search(file, pCriteria);
        
        this.contents = filteredSearchResults;

        return this;
    }
}