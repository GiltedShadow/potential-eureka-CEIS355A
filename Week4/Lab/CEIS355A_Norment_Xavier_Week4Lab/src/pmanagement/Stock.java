/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pmanagement;

/**
 *
 * @author never
 * Program Name: CEIS355A_Norment_Xavier_Week4Lab.java
 * Programmer's Name: Xavier Norment
 * Program Description:
 *      maintains a stock list with available add, remove and view gain/loss
 */
public class Stock {
    private String name;
    private double numberOfShares, purchasePrice, currentPrice;
    
    public Stock(){
        name = "N/A";
        numberOfShares = 0.0;
        purchasePrice = 0.0;
        currentPrice = 0.0;
    }

    public Stock(String name, double numberOfShares, 
            double purchasePrice, double currentPrice) {
        setName(name);
        setNumberOfShares(numberOfShares);
        setPurchasePrice(purchasePrice);
        setCurrentPrice(currentPrice);
    }
    
    @Override
    public String toString(){
        // only show public information
        return name;
    }
    
    public double getGainLoss(){
        return (numberOfShares * (currentPrice - purchasePrice));
    }

    public void setName(String name) {
        if (!name.equals("")){
            this.name = name;
        }
        else{
            this.name = "N/A";
        }
    }

    public void setNumberOfShares(double numberOfShares) {
        if (numberOfShares > 0.0){
            this.numberOfShares = numberOfShares;
        }
        else{
            this.numberOfShares = 0.0;
        }
    }

    public void setPurchasePrice(double purchasePrice) {
        if (purchasePrice > 0.0){
            this.purchasePrice = purchasePrice;
        }
        else{
            this.purchasePrice = 0.0;
        }
    }

    public void setCurrentPrice(double currentPrice) {
        if (currentPrice > 0.0){
            this.currentPrice = currentPrice;
        }
        else{
            this.currentPrice = 0.0;
        }
    }

    
    
    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getNumberOfShares() {
        return numberOfShares;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }
    
    public String getName(){
        return name; 
    }
}
