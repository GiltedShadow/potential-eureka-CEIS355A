/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pmanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author never
 * Program Name: CEIS355A_Norment_Xavier_Week5Lab.java
 * Programmer's Name: Xavier Norment
 * Program Description:
 *      maintains a stock list with available add, remove and view gain/loss
 */
public class StockIO {
    private String fileName;
    
    //constructors
    public StockIO(){
        fileName = "Stocks.txt";
    }
    
    public StockIO(String fileName){
        setFileName(fileName);
        this.fileName = fileName;
    }
    
    //behaviosrs
    public ArrayList<Stock> getData(){
        ArrayList<Stock> data = new ArrayList<>();
        
       try{
           //load the arraylist with the data from file
           BufferedReader inFile = new BufferedReader(new FileReader(fileName));
           String inputLine = "";
           StringTokenizer tokens;
           
           //get the first line
           inputLine = inFile.readLine();
           
           //cycle through the file to get each line
           while(inputLine != null){
               //break line into parts
               tokens = new StringTokenizer(inputLine, ",");
               String company = tokens.nextToken();
               double shares = Double.parseDouble(tokens.nextToken());
               double purchasePrice = Double.parseDouble(tokens.nextToken());
               double currentPrice = Double.parseDouble(tokens.nextToken());
               
               //create a stock and add to arraylist
               Stock stk = new Stock(company, shares, purchasePrice, currentPrice);
               data.add(stk);
               
               //read next line
               inputLine = inFile.readLine();
           }
           
           //close file
           inFile.close();
       }
       catch(IOException ex){
           JOptionPane.showMessageDialog(null, 
                    "Error, unable to read file: " + ex.getMessage(), 
                    fileName, JOptionPane.ERROR_MESSAGE);
       }
        
        return data;
    }
    
    public void saveData(ArrayList<Stock> data){
        //companyName,numberOfShares,purchasePrice,currentPrice
        try{
            //create a pipe to the file (open file ready to write)
            BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
            
            //write the data to stock
            for (int i=0;i<data.size();i++){
                Stock stk = data.get(i);
                outFile.write(stk.getName() + ',');
                outFile.write("" + stk.getNumberOfShares() + ',');
                outFile.write("" + stk.getPurchasePrice() + ',');
                outFile.write("" + stk.getCurrentPrice() + ',');
                outFile.newLine(); //go to new line
            }
            outFile.close();//close out file
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null, 
                    "Error, unable to write to file: " + ex.getMessage(), 
                    fileName, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //getters and setters
    public String getFileName(){
        return fileName;
    }
    
    public void setFileName(String fileName){
        if (fileName.length() > 0){
            this.fileName = fileName;
        }
        else{
            this.fileName = "Stocks.txt";
        }
    }
}
