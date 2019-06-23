/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockgamer;


import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.scene.image.Image;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.L;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 *
 * @author jain7317
 * 
 * 
 * 
 * The following GUI controller combines all data from all child classes
 * 
 * 
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private Button buyButton, sellButton, seeBought;
    @FXML
    private Label label,totalValue, netMoney, netMoney1, showMoney1,greetings,  currentValue, name_symbol, changeValue, showMoney, previousClose, open, bid, ask, daysRange, weekRange, volume, avgVolume, marketCap,beta, peRatio, eps, earningsDate,  exDividend, yearTarget, nameOfPerson;
    
    // put the following textField in SceneBuilder!!!!
    @FXML
    private TextField symbol, name, password1, password2, username, startUp, SYMTextField, loginUsername, loginPassword ;
    
    @FXML
    private ImageView background;
    @FXML
    private double startTime;
    
    @FXML
    private int timeSpent;
    private Person player ;
    private String personNum;
    
    @FXML
    private ListView boughtStocks;
    
    @FXML
    CategoryAxis xAxis = new CategoryAxis();
    @FXML
     NumberAxis yAxis = new NumberAxis();
    
     @FXML
    private LineChart<String,Number> chart;
    
     
     @FXML
     private int searchTimes;
    private Object XYChart;
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        signUp = true;
        
        changeScenes(event, "signUp.fxml");
   
       
    }
    
   
   
    @FXML
    private void signUp(ActionEvent event)throws IOException {
        // CHANGE THIS!!!!
        
        list = new ArrayList<String>();
            handleLoad();
            
        boolean name1 = false;
        boolean username1 = false;
        boolean password = false;
        
        for(int i = 0; i< list.size(); i++){
            if(list.get(i).substring(2,3) == "a" && list.get(i).substring(3) == username.getText()){
                username1 = true;
            }
        }
        
        for(int i = 0; i< list.size(); i++){
            if(list.get(i).substring(2,3) == "b" && list.get(i).substring(3) == password1.getText()){
                password = true;
            }
        }
        
        for(int i = 0; i< list.size(); i++){
            if(list.get(i).substring(2,3) == "c" && list.get(i).substring(3) == name.getText()){
                name1 = true;
            }
        }
        
      
        
        if(password1.getText().equals(password2.getText()) && name1 == false && password == false && username1 == false){
            
            list = new ArrayList<String>();
            handleLoad();
            ArrayList<String> tempString = new ArrayList<>();
            for(int i = 0; i< list.size(); i++){
                tempString.add(list.get(i).substring(2));
            }
            
            ////CHANGE THIS ASAP 我不喜欢我。
               
            
            
            
            list = new ArrayList<String>();
            handleLoad();
//           newGame = new Game();
            int highest = getHighestNumber() + 1;
           // System.out.println(highest + "  highest");
            
            player = new Person(Double.parseDouble(startUp.getText()) ,name.getText() , username.getText(),password1.getText(), highest);
            
            
//            
            //System.out.println("it works 1000001");
            list.add(player.get_number() + "a" + player.get_player_username());
            list.add(player.get_number() + "b" + player.get_player_password());
            list.add(player.get_number() + "c" + player.get_player_name());
            list.add(player.get_number() + "d" + player.getMoney());
            list.add(player.get_number() + "e" + player.getMoney());
            
            personNum = player.get_number();
       
        
       
 
        }else {
             System.out.println("you did not work nunu!");
             password2.clear();
             password2.setPromptText("not the correct password");
             
        }
        handleSave();
        getHome(event);
    }
    
    @FXML
    public void start() {
       
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (startTime > 0) {

                    int x = (int) (Math.floor(startTime / 1000000000));
                    int y = (int) ((now / 1000000000));
                    //System.out.println(y - x);
                    timeSpent = y - x ;

                    

                    // open gl
                }
            }
        }.start();
        
    }
    
    @FXML
    public double getTwoDigits(double input){
        int roundDoub = (int) (input * 100);
        double output = ((double)(roundDoub)) / 100.0;
        return output;
    }
    
    
    @FXML
    private void setChart() throws IOException{
      // chart = new LineChart<String,Number>(xAxis, yAxis);
      
      ArrayList<String> testing = temp.getHistory();
      XYChart.Series series = new XYChart.Series();
      series.setName(temp.getName());
      
      
      
     
      // you know what to do, just find the date in every line, and the next "." after the date is the decimal point in 
      //
      
      ArrayList<String> dates = temp.getHistDates();
      ArrayList<String> values = temp.getHistValues();
      
      for(int i = 0; i< dates.size(); i++){
          series.getData().add(new XYChart.Data(dates.get(i), Double.parseDouble(values.get(i))));
          
      
      }
    chart.getData().add(series);
          
         
          // YAASSSSSSSSSSSSSSS IIIIIIIIIIIT WOOOOOOOOOORKSSSSSSSSS :)
          

      //temp.getHistory();

    }
    
    @FXML
    private void searchTheSYM(ActionEvent event) throws IOException {
       
        //System.out.println("it worked!");
        
        
        
         temp = new WebFacts(SYMTextField.getText());
         
        temp.getInfo();
        name_symbol.setText(temp.getName());
        currentValue.setText(temp.get_current_price() + "");
        changeValue.setText(temp.get_overall_change());
       // previousClose.setText(temp.get_previous_value());
        open.setText(temp.get_open());
        bid.setText(temp.bid());
        ask.setText(temp.ask());
        daysRange.setText(temp.daysRange());
        weekRange.setText(temp.weekRange());
        avgVolume.setText(temp.averageVolume());
        volume.setText(temp.volume());
        //System.out.println(temp.get_previous_value());
       // System.out.println(temp.get_open());
        
        
        // bid, ask, daysRange, weekRange, volume, avgVolume, 
        
        String usernameTemp = "";
        String passwordTemp = "";
        String nameTemp = "";
        double cash = 0.0;
        double investMoney = 0.0;
        
        
        ArrayList<String> buys = new ArrayList<>();
        listOfUsers = new ArrayList<>();
        handleLoad_1();
        list = new ArrayList<String>();
        handleLoad();
        personNum = listOfUsers.get(listOfUsers.size() - 1);
//        System.out.println(personNum+"gethme");
        //System.out.println("personNum" + personNum);
        for(int i = 0; i< list.size(); i++){
           // System.out.println("helloooooo");
            //System.out.println(list.get(i).substring(0, 2));
            //System.out.println(list.get(i));
            if((personNum).equals(list.get(i).substring(0, 2))){
                
                if(list.get(i).substring(2,3).equals("a")){
//                    greetings .setText("Hi " + list.get(i).substring(3) + "!");
passwordTemp = list.get(i).substring(3);
                }else if(list.get(i).substring(2,3).equals("b")){
                    
                   usernameTemp = list.get(i).substring(3);
                }else if(list.get(i).substring(2,3).equals("c")){
                    nameTemp = list.get(i).substring(3);
                    
                }else if(list.get(i).substring(2,3).equals("d")){
                    cash = Double.parseDouble(list.get(i).substring(3));
                    showMoney1.setText("$" + list.get(i).substring(3));
                }else if(list.get(i).substring(2,3).equals("e")){
                    netMoney1.setText("$" + list.get(i).substring(3));
                }else if(list.get(i).substring(2,3).equals("f")){
                    buys.add(list.get(i).substring(3));
                    //System.out.println(list.get(i).substring(3));
                }
            }
        }
        
         String pricePART2 = temp.get_current_price();
        
        if(pricePART2.contains(",")){
            pricePART2 = pricePART2.replace(",", "");
        }
        
        double numberPrice = Double.parseDouble(pricePART2);
        
        if(searchTimes == 0){
            
        
        
        
        player = new Person(cash, nameTemp, usernameTemp, passwordTemp, Integer.parseInt(personNum));
        player.setInvetedMoneyTo(cash);
        
         for(int i =0; i< buys.size(); i++){
             
             System.out.println(buys.get(i));
             
             
             
              String pricePART3 = buys.get(i).substring(buys.get(i).indexOf(")") + 1);
        
        if(pricePART3.contains(",")){
            pricePART3 = pricePART3.replace(",", "");
        }
        
        double numberPrice1 = Double.parseDouble(pricePART3);
             
             
             
             double changeBy = numberPrice1;
             
            player.changeInvestedMoney(-changeBy);
        }
        
        
        for(int i =0; i< buys.size(); i++){
            
            
            WebFacts newBuys = new WebFacts(buys.get(i).substring(buys.get(i).indexOf("(") + 1, buys.get(i).indexOf(")")));
            newBuys.current_Price_Name();
            player.changeInvestedMoney(numberPrice);
        }
        
        
        }
       
        // initialize player here!
      if(player.getMoney()<= numberPrice){
          
          buyButton.setDisable(true);
          
      }else {
          buyButton.setDisable(false);
      }
        
         ArrayList<String> tempUse = new ArrayList<>();
        
        for(int i = 0; i< list.size(); i++){
         if(list.get(i).substring(0,2).equals(personNum)){
             if(list.get(i).substring(2,3).equals("f")){
                 
                 tempUse.add(list.get(i).substring(3));
                
             }
         }   
        }
        
        sellButton.setDisable(true);
        for(int i = 0; i< tempUse.size();i++){
            if(tempUse.get(i).contains(temp.getName())){
                sellButton.setDisable(false);
            }
        }
        
        ArrayList<String> annualOpens = temp.getHistory();
        if(temp.get_overall_change().contains("+")){
            
            
           
            changeValue.setTextFill(Color.web("#55FF55"));
        }else if(temp.get_overall_change().contains("-")){
            changeValue.setTextFill(Color.web("#FF5555"));
        }
        temp.getHistoryPart2();
        
        setChart();
        
       searchTimes +=1;
        
        
    }
    
    @FXML
    private void loginButton(ActionEvent event)throws IOException {
        
       
           changeScenes(event, "FXMLDocument_1.fxml");
 
        
        
    }
    
    @FXML
    private void changeScenes(ActionEvent event, String fxml) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        Scene scene = new Scene(root);
       
        stageTheEventSourceNodeBelongs.setScene(scene);
        stageTheEventSourceNodeBelongs.show();
       
       
    }
   
    
   @FXML
    private void getHome(ActionEvent event) throws IOException{
        personNum = player.get_number();
////       
        list = new ArrayList<String>();
        handleLoad();
        listOfUsers = new ArrayList<>();
        handleLoad_1();
        listOfUsers.add(personNum);
//        System.out.println(listOfUsers.size());
        handleSave_1();
        
        changeScenes(event, "FXMLDocument.fxml");
        ArrayList<String> buys = new ArrayList<>();
        listOfUsers = new ArrayList<>();
        handleLoad_1();
        list = new ArrayList<String>();
        handleLoad();
        
        personNum = listOfUsers.get(listOfUsers.size() - 1);
//        System.out.println(personNum+"gethme");
//        //System.out.println("personNum" + personNum);
//        for(int i = 0; i< list.size(); i++){
//           // System.out.println("helloooooo");
//            System.out.println(list.get(i).substring(0, 2));
//            //System.out.println(list.get(i));
//            if((personNum).equals(list.get(i).substring(0, 2))){
//                System.out.println("1111");
//                if(list.get(i).substring(2,3).equals("a")){
////                    greetings .setText("Hi " + list.get(i).substring(3) + "!");
//                }else if(list.get(i).substring(2,3).equals("d")){
//                    System.out.println("222");
//                    //showMoney1.setText("$");
//                }else if(list.get(i).substring(2,3).equals("e")){
//                    netMoney1.setText("$");
//                }
//            }
//        }
//        
       
    }
    
    @FXML
    private void getHome1(ActionEvent event) throws IOException{
//         String personNum = player.get_number();
////       
////        list = new ArrayList<String>();
////        handleLoad();
//        ArrayList<String> buys = new ArrayList<>();
//        System.out.println(list.size());
//        for(int i = 0; i< list.size(); i++){
//            if(list.get(i).substring(0, 2).equals(personNum)){
//                if(list.get(i).substring(2,3).equals("a")){
////                    greetings .setText("Hi " + list.get(i).substring(3) + "!");
//                }else if(list.get(i).substring(2,3).equals("d")){
//                    showMoney.setText("$" + list.get(i).substring(3));
//                }else if(list.get(i).substring(2,3).equals("e")){
//                    netMoney.setText("$" + list.get(i).substring(3));
//                }
//            }
//        }
        changeScenes(event, "FXMLDocument.fxml");
       
    }
    
    
    @FXML
    private void login(ActionEvent event) throws IOException{
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<String> usernames = new ArrayList<>();
        list = new ArrayList<String>();
        handleLoad();
        System.out.println(list.size() + " list.size");
        String personNum = "";
        boolean actualMatch = false;
        
        for(int i = 0; i< list.size(); i++){
            
            if(list.get(i).substring(2,3).equals("a") && list.get(i).substring(3).equals(loginUsername.getText())){
                usernames.add(list.get(i));
                System.out.println("login is working u");
            }
        }
        
        System.out.println("user.size");
        
        for(int i = 0; i< list.size(); i++){
            
            if(list.get(i).substring(2,3).equals("b") && list.get(i).substring(3).equals(loginPassword.getText())){
              passwords.add(list.get(i));
                              System.out.println("login is working p");
                              System.out.println(list.get(i));

            }
        }
        System.out.println("lananananana");
        for(int i = 0; i< usernames.size(); i++){
            for(int j = 0; j< passwords.size(); j++){
                if(usernames.get(i).substring(0,2).equals(passwords.get(j).substring(0,2))){
                    personNum = usernames.get(i).substring(0,2);
                    actualMatch = true;
                    System.out.println("wow! matching worked");
                }
            }
        }
        
        // untill here, we have the number taken IF there is a amatch
        
    
        
        // we have set the number value in the other text file
        
        if(actualMatch){
            listOfUsers = new ArrayList<>();
            handleLoad_1();
            listOfUsers.add(personNum);
            handleSave_1();
            
            changeScenes(event, "FXMLDocument.fxml");
        }
        
       
       
       
    }
    
    @FXML
    private void exit(ActionEvent event) throws IOException{
//                System.out.println(list.size() + "size");
    list = new ArrayList<>();
    handleLoad();
    listOfUsers = new ArrayList<>();
    handleLoad_1();
    
    personNum = listOfUsers.get(listOfUsers.size()-1);
    
//    for(int i = 0; i< list.size(); i++){
//        if(list.get(i).substring(0,2).equals(listOfUsers.get(listOfUsers.size()-1))){
//            if(list.get(i).substring(2,3).equals("a")){
//                
//                list.set(i, personNum + "a" + player.get_player_username());
//                
//            }else if(list.get(i).substring(2,3).equals("b")){
//                
//                list.set(i, personNum + "b" + player.get_player_password());
//                
//            } else if(list.get(i).substring(2,3).equals("c")){
//                
//                list.set(i, personNum + "c" + player.get_player_name());
//                
//            }else if(list.get(i).substring(2,3).equals("d")){
//                
//                list.set(i, personNum + "d" + player.getMoney());
//                
//            }
//        }
//    }
    
handleSave();
        changeScenes(event, "FXMLDocument_2.fxml");
//       handleSave();

       
    }
    
    @FXML
    private void getProfile(ActionEvent event) throws IOException{
//       //String personNum = player.get_number();
//       
        list = new ArrayList<String>();
        handleLoad();
        ArrayList<String> buys = new ArrayList<>();
        
        for(int i = 0; i< list.size(); i++){
            if(list.get(i).substring(0, 2).equals(personNum)){
                if(list.get(i).substring(2,3).equals("a")){
                  //  greetings .setText("Hi " + list.get(i).substring(3) + "!");
                }else if(list.get(i).substring(2,3).equals("d")){
                    //showMoney.setText("$" + list.get(i).substring(3));
                }else if(list.get(i).substring(2,3).equals("e")){
                   // netMoney.setText("$" + list.get(i).substring(3));
                }
            }
        }
//       
       
        System.out.println();
        changeScenes(event, "myProfile.fxml");
       
        
        
       
    }
    
    @FXML
    private void seeBoughtButton(ActionEvent event){
        ArrayList<String> tempDisplay = new ArrayList<>();
        ObservableList displayList = FXCollections.observableArrayList();
        
        list = new ArrayList<>();
        handleLoad();
        
        listOfUsers = new ArrayList<>();
        handleLoad_1();
        
        String personNum1 = listOfUsers.get(listOfUsers.size()-1);
        
        for(int i = 0; i< list.size(); i++){
         if(list.get(i).substring(0,2).equals(personNum1)){
             if(list.get(i).substring(2,3).equals("f")){
                 
                 tempDisplay.add(list.get(i).substring(3));
                 displayList.add(list.get(i).substring(3));
             }
              if(list.get(i).substring(2,3).equals("d")){
                 
                 totalValue.setText(list.get(i).substring(3));
             }
              
              if(list.get(i).substring(2,3).equals("c")){
                 
                 nameOfPerson.setText(list.get(i).substring(3));
             }
              
         }   
        }
        
        boughtStocks.setItems(displayList);
        
        
        
        
    }
    
    
    @FXML
    private void before_change_to_get_Profile(String num) throws IOException{
        String personNum = num;
//       
        list = new ArrayList<String>();
        handleLoad();
        ArrayList<String> buys = new ArrayList<>();
        
        for(int i = 0; i< list.size(); i++){
            if(list.get(i).substring(0, 2).equals(personNum)){
                if(list.get(i).substring(2,3).equals("a")){
                    greetings .setText("Hi " + list.get(i).substring(3) + "!");
                }else if(list.get(i).substring(2,3).equals("d")){
                    showMoney.setText("$" + list.get(i).substring(3));
                }else if(list.get(i).substring(2,3).equals("e")){
                    netMoney.setText("$" + list.get(i).substring(3));
                }
            }
        }
//       
    }
    
    @FXML
    private void change_to_get_Profile(ActionEvent event) throws IOException{
        System.out.println("heloo");
         changeScenes(event, "myProfile.fxml");
    }
    
    @FXML
    private void getBuySell(ActionEvent event) throws IOException{
        changeScenes(event, "buySell.fxml");
       
    }
    
    @FXML
    public void changeScene(Stage stage) throws IOException{
    Parent pane = FXMLLoader.load(getClass().getResource("FXMLDocument_1.fxml"));

    stage.getScene().setRoot(pane);
}
    
     @FXML
    private void handleSave() {
        
//        for(int i = 0; i< list.size();i++){
//            System.out.println(list.get(i));
//            System.out.println("list");
//        }
        String outFile = "src/resources/file.txt";
        try {
                PrintWriter out = new PrintWriter(outFile);
                for(int i = 0; i < list.size(); i++)
                {
                   // System.out.println("list printed");
                    out.println(list.get(i));
                }
                out.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Something went wrong!");
        }
         System.out.println("main handle save");
        
    }
    
    
    @FXML
    private void handleLoad()
    {
        
      
        try{
            FileReader reader = new FileReader("src/resources/file.txt");
            Scanner in = new Scanner(reader);
            while(in.hasNextLine())
            {
                String temp = in.nextLine();
                list.add(temp);
//                displayList.add(temp);
//                listView.setItems(displayList);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("SOMETHING HAS GONE HORRIBLY WRONG WE'RE ALL GONNA DIE!");
        }
    }
    
     @FXML
    private void handleSave_1() {
        
//        for(int i = 0; i< list.size();i++){
//            System.out.println(list.get(i));
//            System.out.println("list");
//        }
        String outFile = "src/resources/file_1.txt";
        try {
                PrintWriter out = new PrintWriter(outFile);
                for(int i = 0; i < listOfUsers.size(); i++)
                {
                   // System.out.println("list printed");
                    out.println(listOfUsers.get(i));
                }
                out.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Something went wrong!");
        }
         System.out.println("main handle save");
        
    }
    
    
    @FXML
    private void handleLoad_1()
    {
        
      
        try{
            FileReader reader = new FileReader("src/resources/file_1.txt");
            Scanner in = new Scanner(reader);
            while(in.hasNextLine())
            {
                String temp = in.nextLine();
                listOfUsers.add(temp);
//                displayList.add(temp);
//                listView.setItems(displayList);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("SOMETHING HAS GONE HORRIBLY WRONG WE'RE ALL GONNA DIE!");
        }
    }
    
    
    @FXML
    public int getHighestNumber (){
          
        
        
             int high = 00;
       for(String temp : list){
           if (Integer.parseInt(temp.substring(0,2))>high){
                    high = Integer.parseInt(temp.substring(0,2));
                    System.out.println("it actually actually works");
                } 
       }
               
       
        
        return high;
    }
    
    
    @FXML
    private void buyStocks(ActionEvent event) throws IOException{
        list = new ArrayList<>();
        handleLoad();
        
        list.add(personNum + "f" + temp.getName() + " " + temp.get_current_price());
        //player.
       // double money = 
       temp.current_Price_Name();
       
       String pricePART2 = temp.get_current_price();
        
        if(pricePART2.contains(",")){
            pricePART2 = pricePART2.replace(",", "");
        }
        
        double numberPrice = Double.parseDouble(pricePART2);
       
         player.changeMoney(-numberPrice);
         player.changeInvestedMoney(-numberPrice);
         player.changeInvestedMoney(numberPrice);
         
         netMoney1.setText("$" + player.getInvestedMoney());
         showMoney1.setText("$" + player.getMoney());
         
         for(int i = 0; i< list.size();i++){
             if(list.get(i).substring(0,2).equals(personNum)){
                 if(list.get(i).substring(2,3).equals("d")){
                     list.set(i, personNum + "d" + player.getMoney());
                 }
             }
         }
         
         handleSave();
         
         if(player.getMoney()<= numberPrice){
          
          buyButton.setDisable(true);
          
      }else {
          buyButton.setDisable(false);
      }
         
         
         ArrayList<String> tempUse = new ArrayList<>();
        
        for(int i = 0; i< list.size(); i++){
         if(list.get(i).substring(0,2).equals(personNum)){
             if(list.get(i).substring(2,3).equals("f")){
                 
                 tempUse.add(list.get(i).substring(3));
                
             }
         }   
        }
        
        sellButton.setDisable(true);
        for(int i = 0; i< tempUse.size();i++){
            if(tempUse.get(i).contains(temp.getName())){
                sellButton.setDisable(false);
            }
        }
        
        
    }
    
    // for every bought, the investor's cash 
    //is decreased by the bought price,and then increased by the current price
     
    @FXML
    private void sellStocks(ActionEvent event){
        list = new ArrayList<>();
        handleLoad();
        
         String pricePART2 = temp.get_current_price();
        
        if(pricePART2.contains(",")){
            pricePART2 =  pricePART2.replace(",", "");
        }
        
        double numberPrice = Double.parseDouble(pricePART2);
        
        double currentPrice = numberPrice;
        player.changeMoney(currentPrice);
        showMoney1.setText("$" + player.getMoney());
        for(int i = 0; i< list.size(); i++ ){
            if(list.get(i).substring(0,2).equals(personNum)){
                if(list.get(i).substring(2,3).equals("f")){
                    if(list.get(i).substring(3).contains(temp.getName())){
                        System.out.println("how many times nunu????");
                        list.remove(i);
                        break;
                    }
                }
            }
        }
        
        handleSave();
        
        ArrayList<String> tempUse = new ArrayList<>();
        
        for(int i = 0; i< list.size(); i++){
         if(list.get(i).substring(0,2).equals(personNum)){
             if(list.get(i).substring(2,3).equals("f")){
                 
                 tempUse.add(list.get(i).substring(3));
                
             }
         }   
        }
        
        sellButton.setDisable(true);
        for(int i = 0; i< tempUse.size();i++){
            if(tempUse.get(i).contains(temp.getName())){
                sellButton.setDisable(false);
            }
        }
        
        
        
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        backgroundImage= new Image("resources/stocksF.png");
//        background.setImage(backgroundImage);
        searchTimes = 0;
    
    }   
    private Image backgroundImage;
    private ArrayList<String> list;
    
    private ArrayList<String> listOfUsers;
    public static boolean signUp = false;
    private WebFacts temp;
    private Game newGame;
}


//Plan:

// history graph: 

//~ get numbers
//~ set into graph
//~ if possible, set buttons, to set different graphs

// buy sell:

// enable and disable sell button




