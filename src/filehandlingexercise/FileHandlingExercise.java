/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filehandlingexercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Thabo Setsubi st10445734@vcconnnect.edu.za ST10445734
 */
public class FileHandlingExercise
{

    //This is the main method
    //------------------------------------------------------------------------//
    public static void main(String[] args)
    {
        File app = new File("example.txt");
        Scanner scan = new Scanner(System.in);
        int option = 0;
        int EXIT = 5;
        int position;
        Random randm = new Random();
        String line;
        try 
        {
            if(app.createNewFile()) 
            {
                System.out.println("File created: " + app.getName());
            } 
            else 
            {
                System.out.println("Already created.");
            }
            
            while(option != EXIT) 
            {
                System.out.println("Welcome to the file reader \n" 
                + "Enter a number to pick what you want to do: \n"
                + "1) Read the file \n"
                + "2) Append the line \n"
                + "3) Read random line\n"
                + "4) Modify a random line \n"
                + "5) Exit");
                option = scan.nextInt();
                switch(option)
                {
                    case 1:
                        readSequentially();
                        break;
                    case 2:
                        appendSequentially("");
                        break;
                    case 3:
                        position = randm.nextInt(10);
                        readRandomly(position);
                        break;
                    case 4:
                        System.out.println("What line would you like to append (between 1-10): ");
                        position = scan.nextInt();
                        System.out.println("What would you like to add to this line: ");
                        line = scan.nextLine();
                        modifyRandomly(position, line);
                        break;
                    case 5:
                        System.out.println("Bye, have a great time...");
                        break;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void readSequentially() 
    {
        
        try 
        {
            File app = new File("example.txt");
            Scanner reader = new Scanner(app);
            while(reader.hasNextLine()) 
            {
                String data = reader.nextLine();
                System.out.println(data);
            } 
            reader.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void appendSequentially(String newLine) 
    {
        try
        {
            FileWriter app = new FileWriter("example.txt");
            app.append(newLine);
            app.close();
        }
        catch(IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void readRandomly(int position) 
    {
        try 
        {
            String line;
            File app = new File("example.txt");
            BufferedReader read = new BufferedReader(new FileReader(app));
            Scanner reader = new Scanner(app);
            int currentLine = 0; 
            
            while((line = read.readLine()) != null) 
            {
                currentLine++;
                if(position == currentLine) 
                {
                    String data = line;
                    System.out.println(data);
                }
                
            } 
            if(currentLine < position) 
            {
                System.out.println("Line: "+ position +"Does not exist");
            }
            reader.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void modifyRandomly(int position, String newText) 
    {
       try
        {
            String line;
            File app = new File("example.txt");
            BufferedReader read = new BufferedReader(new FileReader(app));
            Scanner reader = new Scanner(app);
            int currentLine = 0; 
            
            while((line = read.readLine()) != null) 
            {
                currentLine++;
                if(position == currentLine) 
                {
                    String data = line;
                    System.out.println(data);
                }
                
            } 
            if(currentLine < position) 
            {
                System.out.println("Line: "+ position +"Does not exist");
            }
            reader.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    
    //-------------------------00ooo0oo End of file oo0ooo00------------------//
}
