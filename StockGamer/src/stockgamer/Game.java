/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockgamer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author jain7317
 * 
 * 
 * for this class, just get from the text file once, then use the Array List for everything!!!
 * 
 * 
 * 
 * 
 */
public class Game {
    
    // RULES FOR TEXTFILE:
    
    // a == username
    // b == password
    // c == name
    // d == money value
    // e == net Money
 
   // f == all of the stocks person bought, then space, then the number of stocks
    // it will work like a line will be added every time the person purchases the stocks
    // even if it is the same company, with the time, and date of the sale.
    
    
    
    
    
    public Game() throws FileNotFoundException{
       list_of_all_things = new ArrayList<>();
       displayList = FXCollections.observableArrayList();
       list_of_all_things.add("33this is a atet");
       
       
        handleLoad();
        //handleSave();
                
    }
    
    public void setCurrentValue(){
        
    }
    
    public void get_person_via_textfile(){
        try{
            FileReader reader = new FileReader("src/resources/file.txt");
            Scanner in = new Scanner(reader);
            while(in.hasNextLine())
            {
                String temp = in.nextLine();
                if (temp.equals("a")){
                    
                    
                    
                }
               
            }
        } catch (FileNotFoundException ex) {
            System.out.println("SOMETHING HAS GONE HORRIBLY WRONG WE'RE ALL GONNA DIE!");
        }
    }
    
     public String getUsername(int personNumber){
         
         String the_username = "";
        try{
            FileReader reader = new FileReader("src/resources/file.txt");
            Scanner in = new Scanner(reader);
            while(in.hasNextLine())
            {
                String temp = in.nextLine();
                if (Integer.parseInt(temp.substring(0,2)) == personNumber){
                    if(temp.substring(2,3).equals("a")){
                        
                    }
                    
                    
                }
               
            }
        } catch (FileNotFoundException ex) {
            System.out.println("SOMETHING HAS GONE HORRIBLY WRONG WE'RE ALL GONNA DIE!");
        }
        
        return the_username;
    }
     // CHANGE THIS RIGHT NOW!!!!!!!!!!!
     
      
     // this is called by the sign up functino to get the highest number to then make a new person.
      public int getHighestNumber (){
          
             int high = 00;
       for(String temp : list_of_all_things){
           if (Integer.parseInt(temp.substring(0,2))>high){
                    high = Integer.parseInt(temp.substring(0,2));
                    //System.out.println("it actually actually works");
                } 
       }
               
       
        
        return high;
    }
      
      public void add_line(String line){
          list_of_all_things.add(line);
          //System.out.println("does this aaaaaaaactualy work?");
      }
      
      public void transfer_to_list(){
          try{
            FileReader reader = new FileReader("src/resources/file.txt");
            Scanner in = new Scanner(reader);
         
            while(in.hasNextLine())
            {
                String temp = in.nextLine();
               
               
            }
        } catch (FileNotFoundException ex) {
            System.out.println("SOMETHING HAS GONE HORRIBLY WRONG WE'RE ALL GONNA DIE!");
        }
        
      }
      
      public void testSave(){
          
          String test = "src/resources/file.txt";
         // System.out.println(test);
//          


          
//          for(String line : List_of_all_things){
//            System.out.println(" " + line);
//        }
      }
      
    public void handleSave() {
        String outFile = "src/resources/file.txt";
//        try {
//                PrintWriter out = new PrintWriter(outFile);
////                for(int i = 0; i < list_of_all_things.size(); i++)
////                {
////                    out.println(list_of_all_things.get(i));
////                }
//                out.close();
//            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Something went wrong!");
//        }
//
//        System.out.println("save worked");
        
    }
   
    private void handleLoad()
    {
        try{
            FileReader reader = new FileReader("src/resources/file.txt");
            Scanner in = new Scanner(reader);
            while(in.hasNextLine())
            {
                String temp = in.nextLine();
                list_of_all_things.add(temp);
                //displayList.add(temp);
//                listView.setItems(displayList);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("SOMETHING HAS GONE HORRIBLY WRONG WE'RE ALL GONNA DIE!");
        }
        
      
    }
    
    private ArrayList<String> list_of_all_things;
    private ArrayList<String> symbols_bought = new ArrayList<String>();
    private ObservableList displayList;
    private  PrintWriter out;
    }
    
  
    
    
   
    

