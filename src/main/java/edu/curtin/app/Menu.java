package edu.curtin.app;

import java.util.*;
import java.io.*;

public class Menu 
{
    public String criteria;
    public String outputFormat;

    public void showMenu()
    {
        Scanner sc = new Scanner(System.in);
        int userChoice;
        outputFormat = "count"; //set format to count initially

        do
        {
            System.out.print("Menu:\n\n1. Set Criteria\n2. Set Output Format\n3. Report\n4. Exit");
            userChoice = sc.nextInt();
        } while(userChoice != 1 || userChoice != 2 || userChoice != 3 || userChoice != 4);

        while(userChoice != 4)
        {
            if(userChoice == 1)
            {
                System.out.println("Set new Criteria: ");
                String userCriteria = sc.nextLine();
                setCriteria(userCriteria);
            }
            else if(userChoice == 2)
            {
                System.out.println("Set new Output Format (count/show): ");
                String userOutputFormat = sc.nextLine();
                setOutputFormat(userOutputFormat);//set 
            }
            else 
            {
                System.exit(0);
            }
        }
    }

    public void setCriteria(String pCriteria) 
    { 
        if(criteria.charAt(0) != '+' || criteria.charAt(0) != '-') { throw new IllegalArgumentException("First character must be + or -."); }
        if(criteria.charAt(2) != 't' || criteria.charAt(2) != 'r') { throw new IllegalArgumentException("First character must be t or r."); }
        if(criteria.charAt(1) != ' ' || criteria.charAt(3) != ' ') { throw new IllegalArgumentException("Invalid input. See usage for correct input structure."); }

        criteria = pCriteria; 
    }

    public void setOutputFormat(String pOutputFormat)
    {
        if(pOutputFormat != "count" || pOutputFormat != "show") { throw new IllegalArgumentException("Output format must be count or show."); }

        outputFormat = pOutputFormat;
    }
}
