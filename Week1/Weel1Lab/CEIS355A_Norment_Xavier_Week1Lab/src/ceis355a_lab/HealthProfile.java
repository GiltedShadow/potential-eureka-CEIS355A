/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ceis355a_lab;

/**
 *
 * @author never
 * Program Name: CEIS355A_Norment_Xavier_Week1Lab.java
 * Programmer's Name: Xavier Norment
 * Program Description:
 *      Grab input from users and return their BMI
 */
public class HealthProfile {
    private String hpName;
    private double hpAge, hpWeight, hpHeightInches;
    private double hpBMI;
    
    public void setName(String providedName){
        this.hpName = providedName;
    }
    public void setAge(int providedAge){
        this.hpAge = providedAge;
    }
    public void setWeight(int providedWeight){
        this.hpWeight = providedWeight;
    }
    public void setHeight(int providedFeet, int providedInches){
        this.hpHeightInches = ((providedFeet*12)+providedInches);
    }
    public String getName(){
        return hpName;
    }
    public double getAge(){
        return hpAge;
    }
    public double getWeight(){
        return hpWeight;
    }
    public double getHeight(){
        return hpHeightInches;
    }
    public double getBMI(){
        this.hpBMI = ((hpWeight*703)/(hpHeightInches*hpHeightInches));
        return hpBMI;
    }
    public String getCategory(){
        if (hpBMI<18.5){
            return "Underweight";
        }
        else if ((hpBMI>=18.5)&&(hpBMI<=24.9)){
            return "Normal";
        }
        else if ((hpBMI>=25)&&(hpBMI<=29.9)){
            return "Overweight";
        }
        else{
            return "Obese";
        }
    }
    public double getMaxHR(){
        return 220-hpAge;
    }
}
