package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jagjot Singh
 */
public class TryNTest {
    public static void main(String[] args) {
       
       
    }
    public static int runOCR(String inputfile)
    {
    try {
            boolean logger = true;
        
           
            System.out.println("Input file::" + inputfile);
        
            String ocrDir = "D:\\Repo\\";
         
            String[] command = new String[3];
            command[0] = "cmd";
            command[1] = "/c";
            command[2] = "cd /d " + ocrDir + " && start.py " + inputfile;
            System.out.println("Command : " + command[2]);
            Process proc = Runtime.getRuntime().exec(command);
            System.out.println("Starting Handlers.....");
            System.out.println("Processing File :: " + "temp");
            TranslatorStreamHandler errorHandler = new TranslatorStreamHandler(proc.getErrorStream(), "ERROR", logger);
            TranslatorStreamHandler outputHandler = new TranslatorStreamHandler(proc.getInputStream(), "OUTPUT", logger);
            errorHandler.start();
            outputHandler.start();
            int exitVal = proc.waitFor();
            System.out.println("time out :: " + exitVal);
            System.out.println("Handlers Started.....");
//                proc.waitFor();
            System.out.println("ExitValue for MAT :: " + exitVal);
            if (exitVal == 0) {
                System.out.println("process completed");
                proc.destroy();
                return 0;
            } else {
                System.out.println("incomplete Process");
                proc.destroy();
                return 2;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    
  
    }
    
    public static int readfile(String filename)
    		
    {	String y;
    	if (filename.lastIndexOf(".") > 0)
    	{  y = filename.substring(0, filename.lastIndexOf("."));
    	
    	String x = "D:\\Repo\\" + y + ".txt";
      	 try {
       	      File myObj = new File(x);
       	      Scanner myReader = new Scanner(myObj);
       	      while (myReader.hasNextLine()) {
       	        String data = myReader.nextLine();
       	        System.out.println(data);
       	    
       	      }
       	      myReader.close();
       	    } catch (FileNotFoundException e) {
       	      System.out.println("An error occurred.");
       	      e.printStackTrace();
       	    } 
    	
    	}
    	
    	else 
    		System.out.print("hi");
    	 return 2;
    	 
    	  
    }
            
}
