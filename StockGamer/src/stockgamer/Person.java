/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockgamer;

import java.util.ArrayList;

/**
 *
 * @author jain7317
 */
public class Person {
    
    // constructor
    public Person(double numMoney, String Name, String userName, String Password, int personNum){
       
        username = userName;
        password = Password;
        name = Name;
        moneyValue = numMoney;
        personNumber = personNum;
    }
    
    // when 
    public void setInvetedMoneyTo(double invest){
        investMoneyValue = invest;
    }
    public void bought_stock(){
        
    }
    public String get_player_username(){
        return username;
    }
    public String get_player_password(){
        return password;
    }
    public String get_player_name(){
        return name;
    }
    
     public double getMoney(){
         
         moneyValue = Math.floor(moneyValue * 100) / 100;
         
         
         
         
        return moneyValue;
    }
     
     public double getInvestedMoney(){
         investMoneyValue = Math.floor(investMoneyValue * 100) / 100;
        return investMoneyValue;
    }
     
     public void changeMoney(double amount){
         moneyValue += amount;
     }
     
     public void changeInvestedMoney(double amount){
         investMoneyValue += amount;
     }
     
     public String get_number(){
         
         String finalNumber  = personNumber + "";
         if(finalNumber.length()<2){
             finalNumber = "0" + finalNumber;
         }
         
         return finalNumber;
     }
   
    
    
    
    
    // initializer
    private ArrayList<Game> stocks_bought = new ArrayList<Game>();
    private final String username;
    private final String password;
    private final String name;
    private double moneyValue;
    private double investMoneyValue;
    private final int personNumber;
}
