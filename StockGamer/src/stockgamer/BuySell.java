/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockgamer;

/**
 *
 * @author labdhijain
 */
public class BuySell {
    public BuySell(String name){
        this.name = name;
    }
    
    public void incriment(){
        count++;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCount(){
        return count;
    }
    
    
    
    private String name;
    private int count;
    
}
