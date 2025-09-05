package edu.curtin.app;

import java.io.File;
import java.util.Map;

//Parent interface for TextCriteria and RegexCriteria
public interface SearchStrategy 
{
    public SearchResults matchesCriteria(File pFile, String pCriteria);
}
