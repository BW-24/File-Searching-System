package edu.curtin.app;

import java.io.File;
import java.util.Map;

public interface SearchStrategy 
{
    public SearchResults matchesCriteria(File pFile, String pCriteria);
}
