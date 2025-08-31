package edu.curtin.app;

public class ExcludeCriteria 
{
    public boolean exclude(boolean pIncludes)
    {
        if(pIncludes == true)
            return false;
        return true;
    }
}
