/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ceis355a_week5project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author never
 * Program Name: CEIS355A_Norment_Landscaping_wk5.java
 * Programmer's Name: Xavier Norment
 * Program Description:
 *      create estimated on a landscaping project based on user input
 */
public class DataIO {
    
    public void add(Customer cust)throws IOException{
        //add customer object to the file
        //open or create file using true to apopend data
        BufferedWriter outFile = new BufferedWriter(new FileWriter("Customers.txt", true));
        
        //write the objects data to the file
        outFile.write(cust.getName());
        outFile.write("#" + cust.getAddress());
        outFile.write("#" + cust.getYardType());
        outFile.write("#" + cust.getLength());
        outFile.write("#" + cust.getWidth());
        outFile.write("#" + cust.getTotalCost());
        outFile.newLine();  //"enter" key
        
        //close file
        outFile.close();

    }
    
    public ArrayList<Customer> getList()throws IOException{
        //get customer object from the file and return in arraylist
        // get Customer objects from the file and return as ArrayList
        //create an arraylist
        ArrayList<Customer> customers = new ArrayList<Customer>();

        // read data from the file
        BufferedReader inBuffer = new BufferedReader(new FileReader("Customers.txt"));
        StringTokenizer tokens;

        //get first line
        String inputString = inBuffer.readLine();
        while (inputString != null)
        {
                //break the line into pieces using Tokenizer
                tokens = new StringTokenizer(inputString, "#");

                //fields are name#address#yardType#length#width#totalCost
                String name = tokens.nextToken();
                String address = tokens.nextToken();
                String yardType = tokens.nextToken();
                double length = Double.parseDouble(tokens.nextToken());
                double width = Double.parseDouble(tokens.nextToken());
                double totalCost = Double.parseDouble(tokens.nextToken());

                // create Customer object and add it to the ArrayList
                Customer cust = new Customer(0, name, address, yardType, length, 
                        width, totalCost);
                customers.add(cust);

                //read next line
                inputString = inBuffer.readLine();
        }

        // close the pipe to the file once the records have been read
        inBuffer.close();

        // return the ArrayList
        return customers;

    }
    
    public void delete(String deleteName)throws IOException{
        //delete selected object from file
        // get all records
        ArrayList<Customer> customers = getList();

        // delete the old file
        File oldFile = new File("Customers.txt");
        if( oldFile.exists() == false )
                throw new IOException("File does not exist!");
        oldFile.delete();

        // write "good" records to the file
        for (Customer cust : customers){   // foreach loops are cool!
            if( deleteName.equalsIgnoreCase(cust.getName()) == false ){
                    // good record so write it to the file
                    add(cust);
            }
        }
    }
}
