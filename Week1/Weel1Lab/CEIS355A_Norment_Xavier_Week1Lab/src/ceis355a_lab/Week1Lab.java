package ceis355a_lab;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author never
 * Program Name: CEIS355A_Norment_Xavier_Week1Lab.java
 * Programmer's Name: Xavier Norment
 * Program Description:
 *      Grab input from users and return their BMI
 */
public class Week1Lab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HealthProfile hp = new HealthProfile();
        while(true){
            String name="";
            int age=0, weight=0, heightIn=0, heightFt=0;
            
            Scanner input = new Scanner(System.in);
            System.out.print("Enter name or X to quit: ");
            name = input.nextLine();
            if (name.toLowerCase().equals("x")){
                System.exit(0);
            }
            hp.setName(name);
            System.out.print("Your age: ");
            age = input.nextInt();
            hp.setAge(age);
            System.out.print("Your weight: ");
            weight = input.nextInt();
            hp.setWeight(weight);
            System.out.print("Your height - feet: ");
            heightFt = input.nextInt();
            System.out.print("Your height - inches: ");
            heightIn = input.nextInt();
            hp.setHeight(heightFt, heightIn);
            
            System.out.println("\nHealth Profile for "+name);
            System.out.printf("BMI: %.1f\n",hp.getBMI());
            System.out.println("BMI Category: "+hp.getCategory());
            System.out.println("Max heart rate: "+hp.getMaxHR());
        }
    }
}
