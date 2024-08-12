/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pmanagement;

/**
 *
 * @author never
 * Program Name: CEIS355A_Norment_Xavier_Week5Lab.java
 * Programmer's Name: Xavier Norment
 * Program Description:
 *      maintains a stock list with available add, remove and view gain/loss
 */
public class Stock {
    private String companyName;
    private double numberOfShares, purchasePrice, currentPrice;
    
    public Stock(){
        companyName = "N/A";
        numberOfShares = 0.0;
        purchasePrice = 0.0;
        currentPrice = 0.0;
    }

    public Stock(String companyName, double numberOfShares, 
            double purchasePrice, double currentPrice) {
        setName(companyName);
        setNumberOfShares(numberOfShares);
        setPurchasePrice(purchasePrice);
        setCurrentPrice(currentPrice);
    }
    
    @Override
    public String toString(){
        // pull
        return companyName + ": " + numberOfShares + " shares";
    }
    
    public double getGainLoss(){
        return (numberOfShares * (currentPrice - purchasePrice));
    }

    public void setName(String companyName) {
        if (!companyName.equals("")){
            this.companyName = companyName;
        }
        else{
            this.companyName = "N/A";
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
        return companyName; 
    }
}
