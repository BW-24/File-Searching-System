package edu.curtin.app;


import java.util.logging.*;
import java.io.File;
import java.util.*;

public class App
{
    public static void main(String[] argv)
    {
        String dir;

        if(argv.length > 1) { throw new IllegalArgumentException("Cannot name more than one file."); }
        
        if(argv.length == 1)
            dir = argv[0];
        else
            dir = ".";
        
        File currentDir = new File(dir);
        DirectoryComposite root = new DirectoryComposite(currentDir);
        root.loadContent(dir); //load file into computer

        RunApplication runApp = new RunApplication();
        runApp.run(root);
    }
}
