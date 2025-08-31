package edu.curtin.app;
import java.io.File;

public abstract class FileSystemComponent 
{
    protected File file;
    
    public FileSystemComponent find(String pCriteria);
}