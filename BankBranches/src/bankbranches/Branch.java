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
public class Branch {
    
    private String name;
    private ArrayList<Customer> customers;
    
    public Branch(String name){
        this.name= name;
        this.customers = new ArrayList();
    }
    
    public String getName() {
        return name;
    }
    
    public boolean addCustomer(String name, double amount){
        int i = findCustomer(name);
        if(i==-1){
            System.out.println("Customer exists");
            return false;
        }
        this.customers.add(new Customer(name,amount));
        return true;
    }
    
    public boolean addTransaction(String name, double amount){
        int i = findCustomer(name);
        if(i==-1){
            System.out.println("Customer doesn´t exist");
            return false;
        }
        this.customers.get(i).addTransaction(amount);
        return true;
    }
    public ArrayList<Double> getTransactions(String name) {
        int i = findCustomer(name);
        if(i==-1){
            System.out.println("Customer doesn´t exist");
            return null;
        }
        return this.customers.get(i).getTransactions();
    }

    public ArrayList<Customer> getCustomers() {
        if(this.customers.isEmpty())System.out.println("There´s no customers in the branch");
        return customers;
    }
    public int findCustomer(String name){
        for(Customer temp : this.customers){
            if(temp.getName().equalsIgnoreCase(name)){
                return customers.indexOf(temp);
            }
        }
        return -1;
}
}
