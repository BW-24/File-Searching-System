package edu.curtin.app;
import java.io.*;
import java.util.*;

public class FileLeaf extends FileSystemComponent //extends FileSystemComponent
{
    public File file;

    public FileLeaf(File pFile)
    {
        file = pFile;
    }

    public File getFile()
    {
        return file;
    }

    @Override 
    public FileSystemComponent find(String pCriteria)
    {
        FileSystemComponent found = null;
        if(matchesCriteria(file, pCriteria)) 
        { 
            found = this; 
        }
        return found;
    }
}