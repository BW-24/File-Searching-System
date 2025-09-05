package edu.curtin.app;
import java.io.File;

public abstract class FileSystemComponent 
{
    protected File file;
    
    public  abstract void find(String pCriteria);
    public abstract int count();
}