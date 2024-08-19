/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SGrades;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author never
 * Program Name: CEIS355A_Norment_Xavier_Week6Lab.java
 * Programmer's Name: Xavier Norment
 * Program Description:
 *      Will take and average grades provided in a GUI and saved in a SQL 
 *      database named week6lab within ceis355a
 */
public class StudentDB {
    //const
    private final String CON_STRING = "jdbc:mysql://localhost:3306/ceis355a";
    private final String USER_NAME = "root";
    private final String PASSWORD = "devry123";
    
    //behavior
    
    
    public void add(Student stu) throws ClassNotFoundException, SQLException{
        //check for driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(CON_STRING, USER_NAME, PASSWORD);
        
        String sqlStr = "INSERT INTO week6lab (Name, Test1, Test2, Test3) VALUES (?, ?, ?, ?)";
        
        PreparedStatement pstmt = con.prepareStatement(sqlStr);
        pstmt.setString(1, stu.getName());
        pstmt.setDouble(2, stu.getTest1());
        pstmt.setDouble(3, stu.getTest2());
        pstmt.setDouble(4, stu.getTest3());
        
        pstmt.execute();
        
        con.close();
    }
    
    public ArrayList<Student> getAll() throws ClassNotFoundException, SQLException{
        ArrayList<Student> list = new ArrayList<>();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(CON_STRING, USER_NAME, PASSWORD);
        
        String sqlStr = "SELECT * From week6lab";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sqlStr);
        
        while (rs.next()){
            int studentID = rs.getInt(1);
            String name = rs.getString(2);
            double test1 = rs.getDouble(3);
            double test2 = rs.getDouble(4);
            double test3 = rs.getDouble(5);
            
            Student stu = new Student(name, test1, test2, test3);
            
            list.add(stu);
        }
        
        con.close();
        
        return list;
    }
}
