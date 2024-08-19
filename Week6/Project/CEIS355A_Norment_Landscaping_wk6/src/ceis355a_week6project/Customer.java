/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ceis355a_week6project;

import java.text.DecimalFormat;

/**
 *
 * @author never
 * Program Name: CEIS355A_Norment_Landscaping_wk6.java
 * Programmer's Name: Xavier Norment
 * Program Description:
 *      create estimated on a landscaping project based on user input
 * 
 * ||||Debugging statements added due to customer ID not pulling or updating properly
 * Found the setters here checking the wrong information, always pulling the safety
 * even when not needed||||
 */
public class Customer {
    private String name, address, yardType;
    private double length, width, totalCost;
    private int customerID;

    public Customer() {
        customerID = 0;
        name = "N/A";
        address = "N/A";
        yardType = "N/A";
        length = 0.0;
        width = 0.0;
        totalCost = 0.0;
    }

    public Customer( int customerID, String name, String address, String yardType, double length, double width, double totalCost) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.yardType = yardType;
        this.length = length;
        this.width = width;
        this.totalCost = totalCost;
        
    }
    
    @Override
    public String toString( )
    {
         return name;      // only show the Customer’s name
    }
    
    public String getDetails( )
    {
         DecimalFormat fmt = new DecimalFormat( "$#,##0.00" );
         String output = name + "\n";
         output += address + "\n";
         output += "Type: " + yardType + "\n";
         output += "Width: " + width + "\n";
         output += "Length: " + length + "\n";
         output += "Total Cost: " + fmt.format(totalCost); //currency
         

    return output;
    }
    
    //getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getYardType() {
        return yardType;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public int getCustomerID() {
        return customerID;
    }

    //setters
    public void setName(String name) {
        if(name.length() <=0){
            this.name = "N/A";
        }
        else{
        this.name = name;
        }
    }

    public void setAddress(String address) {
        if(address.length() <= 0){
            this.address = "N/A";
        }
        else{
        this.address = address;
        }
    }

    public void setYardType(String yardType) {
        if(yardType.length() <= 0){
            this.yardType = "N/A";
        }
        else{
        this.yardType = yardType;
        }
    }

    public void setLength(double length) {
        if(length <=0.0){
            this.length = 0.0;
        }
        else{
        this.length = length;
        }
    }

    public void setWidth(double width) {
        if(width <= 0.0){
            this.width = 0.0;
        }
        else{
        this.width = width;
        }
    }

    public void setTotalCost(double totalCost) {
        if(totalCost <= 0.0){
            this.totalCost = 0.0;
        }
        else{
        this.totalCost = totalCost;
        }
    }

    public void setCustomerID(int customerID) {
        if(customerID <= 0){
            this.customerID = 0;
            //System.out.println("Customer ID not set"+customerID);
        }
        else{
        this.customerID = customerID;
        //System.out.println("Customer ID updated to "+ customerID);
        }
    }
}
