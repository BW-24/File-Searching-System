package edu.curtin.app;

import java.io.*;
import java.util.*;

public interface FilterStrategy 
{
    public Map<Integer, String> filter(SearchResults searchResults);
}
