/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ceis355a_week6project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import java.sql.*;
import java.util.Set;

/**
 *
 * @author never
 * Program Name: CEIS355A_Norment_Landscaping_wk6.java
 * Programmer's Name: Xavier Norment
 * Program Description:
 *      create estimated on a landscaping project based on user input
 * 
 * ||||Debugging statements added due to customer ID not pulling or updating properly
 * found error in Customer.java||||
 */
public class DataIO {
    //const
    private final String CON_STRING = "jdbc:mysql://localhost:3306/ceis355a";
    private final String USER_NAME = "root";
    private final String PASSWORD = "devry123";
    private final String DB_NAME = "ceis355a";
    
    public void add(Customer cust)throws ClassNotFoundException, SQLException{
        //Check for driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //connect to db
        Connection con = DriverManager.getConnection(CON_STRING, USER_NAME, PASSWORD);
        
        //add record
        String sqlStatement = "INSERT INTO landscape (CustomerName, "
                + "CustomerAddress, LandscapeType, YardLength, YardWidth, "
                + "LandscapeCost) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sqlStatement);
        pstmt.setString(1, cust.getName());
        pstmt.setString(2, cust.getAddress());
        pstmt.setString(3, cust.getYardType());
        pstmt.setDouble(4, cust.getLength());
        pstmt.setDouble(5, cust.getWidth());
        pstmt.setDouble(6, cust.getTotalCost());
        
        //execute prepared statement
        pstmt.execute();
        
        //close connection
        con.close();

    }
    
    public ArrayList<Customer> getList()throws ClassNotFoundException, SQLException{
        //get customer object from the file and return in arraylist
        //create an arraylist
        ArrayList<Customer> customers = new ArrayList<Customer>();

        //Check for driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //connect to db
        Connection con = DriverManager.getConnection(CON_STRING, USER_NAME, PASSWORD);

        Statement sqlStatement = con.createStatement();
        String sql = "SELECT * FROM landscape";
        ResultSet rs = sqlStatement.executeQuery(sql);
        
        while (rs.next()){
            ///create customer object and load attr
            Customer cust = new Customer();
            cust.setCustomerID(rs.getInt(1));
            cust.setName(rs.getString(2));
            cust.setAddress(rs.getString(3));
            cust.setYardType(rs.getString(4));
            cust.setLength(rs.getDouble(5));
            cust.setWidth(rs.getDouble(6));
            cust.setTotalCost(rs.getDouble(7));
            
//            System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+
//                    rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getDouble(5)+"|"+
//                    rs.getDouble(6)+"|"+rs.getDouble(7));
            //add customer to object list
            customers.add(cust);
        }
        //close db
        con.close();
        
        // return the ArrayList
        return customers;

    }
    
    public void delete(int customerID)throws ClassNotFoundException, SQLException{
        //Check for driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //connect to db
        Connection con = DriverManager.getConnection(CON_STRING, USER_NAME, PASSWORD);
        
        //delete record
        String deleteStatement = "DELETE FROM landscape WHERE CustomerID = ?";
        PreparedStatement pstmt = con.prepareStatement(deleteStatement);
        pstmt.setInt(1, customerID);
        pstmt.execute();
        
        //close db
        con.close();
    }
}
