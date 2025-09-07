package edu.curtin.app;
import java.io.File;
import java.util.List;
import java.util.logging.*;

public abstract class FileSystemComponent 
{
    protected File file;
    
    public  abstract void findInclusions(List<String> pCriteria);
    public abstract int count();
}