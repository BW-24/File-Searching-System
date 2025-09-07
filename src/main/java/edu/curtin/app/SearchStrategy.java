package edu.curtin.app;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.*;

//Parent interface for TextCriteria and RegexCriteria
public interface SearchStrategy 
{
    public SearchResults matchesCriteria(List<String> allLines, String pCriteria);
}
