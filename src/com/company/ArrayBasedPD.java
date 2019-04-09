package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayBasedPD implements PhoneDirectory
{
    // phone directory and related items
    private final int MAXENTRIES = 200; // maximum number of entries in phone directory
    private PhoneDirectoryEntry[] phoneDirectory = new PhoneDirectoryEntry[MAXENTRIES];
    private int numberOfEntries = 0; // number of entries
    private int currentEntry = -1; //index of entry currently displayed

    public void loadData(String filename)
    {
        // TODO Auto-generated method stub
        try
        {
            File inputFile = new File(filename);
            Scanner in = new Scanner(inputFile);
            String name;
            String number;
            int index = 0;

            while (in.hasNext())
            {
                name = in.next();
                number = in.next();
                phoneDirectory[index] = new PhoneDirectoryEntry(name, number);
                index++;
            }

            numberOfEntries = index;
            //now call Arrays.sort() to sort phoneDirectory
            Arrays.sort(phoneDirectory,0,numberOfEntries);
            in.close();

        } catch (IOException exc)
            {
                System.out.println("File does not exist");
            }
    }

    public void saveData(String filename)
    {
        // TODO Auto-generated method stub
        BufferedWriter outputWriter = null;
        try {
            outputWriter = new BufferedWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*for (int i = 0; i < x.length; i++)
        {
            outputWriter.write(Integer.toString(phoneDirectory[i]));
        }
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream("details1.txt"));
            for (int i = 0; i < phoneDirectory.length; i++) {
                printWriter.println(phoneDirectory[i]);
            }
        }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }finally{
                if(printWriter != null)
                {
                    printWriter.close();
                }
            }*/
    }


    public void addEntry(String name, String number)
    {
        // TODO Auto-generated method stub

            phoneDirectory[numberOfEntries] = new PhoneDirectoryEntry(name,number);
            numberOfEntries++;

        Arrays.sort(phoneDirectory,0,numberOfEntries);
    }

    public PhoneDirectoryEntry getFirst()
    {
        // TODO Auto-generated method stub
        if (numberOfEntries != 0) {
            currentEntry = 0;
            return phoneDirectory[0];
        } else
            return null;
    }

    public PhoneDirectoryEntry getNext()
    {
        // TODO Auto-generated method stub
        if (currentEntry != numberOfEntries - 1) {
            currentEntry++;
            return phoneDirectory[currentEntry];
        } else
            return null;

    }

    public PhoneDirectoryEntry getPrevious()
    {
        // TODO Auto-generated method stub
        if (currentEntry !=0) {
            currentEntry--;
            return phoneDirectory[currentEntry];
        } else
            return null;
    }

    public String search(String name)
    {
        // TODO Auto-generated method stub

      PhoneDirectoryEntry placeHolder = new PhoneDirectoryEntry(name,"");
      int result = Arrays.binarySearch(phoneDirectory,0,numberOfEntries,placeHolder);

      if(result >= 0)
          return "Number For " + name + " is " + phoneDirectory[result].getNumber();
      else
          return name + " does not exist";
        /*System.out.println(searchIndex != -1 ? phoneDirectory[searchIndex]+ " - index is "+searchIndex : "Not Found");*/
    }
}
