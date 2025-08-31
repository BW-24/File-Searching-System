package edu.curtin.app;

import java.io.File;

public interface SearchCriteria 
{
    public boolean matchesCriteria(File pFile, String pCriteria);
}
