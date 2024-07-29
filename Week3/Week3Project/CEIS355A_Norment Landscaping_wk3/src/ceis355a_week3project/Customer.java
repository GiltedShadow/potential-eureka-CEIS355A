/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ceis355a_week3project;

import java.text.DecimalFormat;

/**
 *
 * @author never
 * Program Name: CEIS355A_Norment Landscaping.java
 * Programmer's Name: Xavier Norment
 * Program Description:
 *      create estimated on a landscaping project based on user input
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
        this.name = name;
        this.address = address;
        this.yardType = yardType;
        this.length = length;
        this.width = width;
        this.totalCost = totalCost;
        this.customerID = customerID;
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


}
