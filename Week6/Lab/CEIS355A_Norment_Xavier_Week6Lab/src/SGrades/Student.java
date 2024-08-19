/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SGrades;

/**
 *
 * @author never
 * Program Name: CEIS355A_Norment_Xavier_Week6Lab.java
 * Programmer's Name: Xavier Norment
 * Program Description:
 *      Will take and average grades provided in a GUI and saved in a SQL 
 *      database named week6lab within ceis355a
 */
public class Student {
    //attr
    private String name;
    private double test1, test2, test3;
    
    //constructors

    public Student() {
        name = "N/A";
        test1 = 0.0;
        test2 = 0.0;
        test3 = 0.0;
    }

    public Student(String name, double test1, double test2, double test3) {
        setName(name);
        setTest1(test1);
        setTest2(test2);
        setTest3(test3);
    }
    
    //behaviors

    @Override
    public String toString() {
        return name;
    }
    
    public double getAverage(){
        return (test1 + test2 + test3) / 3.0;
    }
    
    public String getLetterGrade(){
        double avg = getAverage();
        
        if (avg >= 90.0){
            return "A";
        }
        else if (avg >= 80.0){
            return "B";
        }
        else if (avg >= 70.0){
            return "C";
        }
        else if (avg >= 60.0){
            return "D";
        }
        else{
            return "F";
        }
    }
    
    //gett sett

    public String getName() {
        return name;
    }

    public double getTest1() {
        return test1;
    }

    public double getTest2() {
        return test2;
    }

    public double getTest3() {
        return test3;
    }

    public void setName(String name) {
        if (name.length() <= 0){
            this.name = "N/A";
        }
        else{
        this.name = name;
        }
    }

    public void setTest1(double test1) {
        if (test1 <= 0.0){
            test1 = 0.0;
        }
        else{
        this.test1 = test1;
        }
    }

    public void setTest2(double test2) {
        if (test2 <= 0.0){
            test2 = 0.0;
        }
        else{
        this.test2 = test2;
        }
    }

    public void setTest3(double test3) {
        if (test3 <= 0.0){
            test3 = 0.0;
        }
        else{
        this.test3 = test3;
        }
    }
    
    
    
}
