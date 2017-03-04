/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankbranches;

import java.util.ArrayList;

/**
 *
 * @author LuisGuillermo
 */
public class Customer {
   
    private String name;
    private ArrayList<Double> transactions = new ArrayList();
    
    public Customer(String name, double initialAmount){
        this.name=name;
        this.transactions.add(initialAmount);
    }
    
    public String getName() {
        return name;
    }
    public ArrayList<Double> getTransactions() {
        return transactions;
    }
    
    public void addTransaction(double amount){
        this.transactions.add(amount);
    }

}
