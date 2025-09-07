package edu.curtin.app;

import java.util.*;
import java.io.*;
import java.util.logging.*;

public class RunApplication
{
    public String criteria;
    public String outputFormat;

    public void run(DirectoryComposite pRoot)
    {
        Scanner sc = new Scanner(System.in);
        int userChoice;
        boolean exit = false;
        outputFormat = "count"; //set format to count initially

        while(exit != true)
        {
            do
            {
                System.out.print("Menu:\n\n1. Set Criteria\n2. Set Output Format\n3. Report\n4. Exit\n\nEnter Choice: ");
                userChoice = sc.nextInt();
            } while(userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4);


            Scanner sc1 = new Scanner(System.in);
            if(userChoice == 1)
            {
                String userCriteria;
                do
                {
                    System.out.print("\n\nSet new Criteria (+/-) (t/r) (text/regex): ");
                    userCriteria = sc1.nextLine();
                } while((userCriteria.charAt(0) != '+' && userCriteria.charAt(0) != '-') && (userCriteria.charAt(2) != 't' && userCriteria.charAt(2) != 'r') && (userCriteria.charAt(1) != ' ' && userCriteria.charAt(3) != ' '));
                //force user to entre correct criteria ^^
                setCriteria(userCriteria);
            }
            else if(userChoice == 2)
            {
                String userOutputFormat;
                do
                {
                    System.out.print("\n\nSet new Output Format (count/show): ");
                    userOutputFormat = sc1.nextLine();
                } while(!userOutputFormat.equals("count") && !userOutputFormat.equals("show"));
                //force user to enter corect input^^
                setOutputFormat(userOutputFormat);
            }
            else if(userChoice == 3)
            {
                System.out.println("\n");
                report(pRoot);
            }
            else 
            {
                exit = true;
            }
        }
    }

    public void setCriteria(String pCriteria) { criteria = pCriteria; }

    public void setOutputFormat(String pOutputFormat) { outputFormat = pOutputFormat; }

    public void report(DirectoryComposite root)
    {
        root.findInclusions(criteria);

        if(outputFormat.equals("count"))
            OutputCount.showCount(root," ");
        else
            OutputShow.showLines(root, " ");
    }
}
