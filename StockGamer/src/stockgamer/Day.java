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
public class Day {
    
    public Day(int month, int dayOfWeek, int date, int year){
        numWeekDay = dayOfWeek;
        Year = year;
                numMonth = month;
                Day = date;
    }
    
    public void incriment(){
        
        // if day is Sun, Mon, Tue, Wed, Thurs, increment 1
        // else if if day is Fri,  increment by 3
        // else if day = Sat, sout there is a aproblem NUNU
        //
        if(numMonth == 1 || numMonth == 3 || numMonth == 5 ||
                numMonth == 7 || numMonth == 8|| numMonth == 10 ||numMonth == 12){
            if(Day == 31){
                Day = 1;
                numMonth +=1;
            }else if(Day < 31){
                Day+=1;
            }
            numWeekDay +=1;
        }else if( numMonth == 4|| numMonth == 6 || numMonth == 9 || numMonth == 11){
            if(Day == 30){
                Day = 1;
                numMonth +=1;
            }else if(Day < 30){
                Day+=1;
            }
            numWeekDay +=1;
        }else if(numMonth == 2){ // February
            if(Day == 28){
                Day = 1;
                numMonth +=1;
            }else if(Day < 28){
                Day+=1;
            }
            numWeekDay +=1;
        }
    }
    
    public void decrement(){
        if(Day == 1){
            if(numMonth == 2 || numMonth == 4|| numMonth == 6 || numMonth == 9 || numMonth == 11){
            numMonth -= 1;
            Day = 31;
        }else if(numMonth == 3)
        {
           numMonth -= 1;
           
           if(Year%4 == 0){
               Day = 27; 
           }else{
               Day = 28;
           }
            
        }
            
               
            }
    }
    
    public void changeDay(int numChange){
        
        if(numChange<0){
            
        }
        
    }
    // returns the final Date
    public String returnDate(){
        String finalDate = "";
        
        finalDate = month  + " "+ Day + ", " + Year;
        return finalDate;
    }
    // updates the string based on the number inputted
    public void updateMonthString(){
        switch(numMonth){
            case(1):
                month = "Jan";
                break;
                case(2):
                    month = "Feb";
                break;
                case(3):
                    month = "Mar";
                break;
                case(4):
                    month = "Apr";
                break;
                case(5):
                    month = "May";
                break;
                case(6):
                    month = "Jun";
                break;
                case(7):
                    month = "Jul";
                break;
                case(8):
                    month = "Aug";
                break;
                case(9):
                    month = "Sep";
                break;
                case(10):
                    month = "Oct";
                break;
                case(11):
                    month = "Nov";
                    
                break;
                case(12):
                    month = "Dec";
                break;
                
        }
    }
    
    
    
    
    private int numMonth;
    private int Day;
    
    private int numWeekDay;
    
    private int Year;
    private String month;
    
}
