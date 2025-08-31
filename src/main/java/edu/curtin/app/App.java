package edu.curtin.app;

/**
 * Entry point into the application. To change the package, and/or the name of this class, make
 * sure to update the 'mainClass = ...' line in build.gradle.
 */
public class App
{
        public static void main(String[] args)
    {
        // Default to current directory "." if no argument provided
        String dirName = (args.length > 0) ? args[0] : ".";

        Directory root = new Directory(dirName);
        root.loadContent(dirName, "");

        // Print out the collected file tree (strings only)
        for(String entry : root.fileTree)
        {
            System.out.println(entry);
        }
    }


}


