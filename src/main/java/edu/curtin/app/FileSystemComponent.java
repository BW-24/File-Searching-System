package edu.curtin.app;
import java.io.File;
import java.util.logging.*;

public abstract class FileSystemComponent 
{
    protected File file;
    
    public  abstract void findInclusions(String pCriteria);
    public abstract int count();
}