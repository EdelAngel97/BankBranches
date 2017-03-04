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
public class Bank {
    
    private ArrayList<Branch> branches;
    
    public Bank(){
        this.branches = new ArrayList();
    }
    public boolean addBranch(String name){
        int n=findbranch(name);
        if(n==-1){
            this.branches.add(new Branch(name));
            System.out.println("Branch added");
            return true;
        }
        System.out.println("Branch exists");
        return false;
    }
    public boolean addCustomer(String bName, String cName, double amount){
        int n = findbranch(bName);
        if(n==-1){
            System.out.println("Branch doesn´t exist");
            return false;
        }
        if(this.branches.get(n).addCustomer(cName, amount)){
        System.out.println("Customer added to " + bName);
        return true;
        }
        return false;
    }
    public boolean addTransaction(String bName, String cName, double amount){
        int n = findbranch(bName);
        if(n==-1){
            System.out.println("Branch doesn´t exist");
            return false;
        }
        if(this.branches.get(n).addTransaction(cName, amount)){
        System.out.println("Transaction added to " + cName + " at " + bName + " branch");
        return true;
        }
        return false;
    }
    public boolean getTransactions(String bName, String cName){
        int n = findbranch(bName);
        if(n==-1){
            System.out.println(cName + " doesn´t exist!");
            return false;
        }
        if(this.branches.get(n).findCustomer(cName)!=-1){
            System.out.println("Customer "+cName+" transactions at "+bName+" branch are:");
            for(double temp : this.branches.get(n).getTransactions(cName)){
                System.out.println(temp);
            }
            return true;
        }
        System.out.println(cName + " doesn´t exist in " + bName);
        return false;
    }
    public void getCustomers(String bName){
        int n = findbranch(bName);
        if(n==-1){
            System.out.println("Branch doesn´t exist");
        }
        System.out.println("Customers at branch " + bName);
        for(Customer temp : this.branches.get(n).getCustomers()){
            System.out.println(temp.getName());
        }
    }
        public boolean getCustomersWithTransactions(String bName){
        int n = findbranch(bName);
        if(n==-1){
            System.out.println("Branch doesn´t exist");
            return false;
        }
        for(Customer temp : this.branches.get(n).getCustomers()){
            getTransactions(bName, temp.getName());
        }
        return true;
    }
    public int findbranch(String name){
        for(Branch temp : this.branches){
            if(temp.getName().equalsIgnoreCase(name)){
                return branches.indexOf(temp);
            }
        }
        return -1;
}
}
