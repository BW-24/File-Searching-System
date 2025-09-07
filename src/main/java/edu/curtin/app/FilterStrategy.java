package edu.curtin.app;

import java.io.*;
import java.util.*;
import java.util.logging.*;

//Parent interface for includeCriteria and excludeCriteria
public interface FilterStrategy 
{
    public Map<Integer, String> filter(SearchResults searchResults);
}
