/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockgamer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import org.jsoup.Jsoup;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
/**
 *
 * @author jain7317
 *
 * This is used to get all the web facts from the Internet. All classes may call
 * this class, and the code in here is encapsulated, meaning that the code
 * inside this class is used only in this class, and in no other class, and the
 * other classes only call the methods they want to run to get information on
 * the high level.
 *
 * The information of this class is obtained from Yahoo finance Yahoo finance is
 * the best option for this, because it does not have encrypted data in its
 * source code. Also
 *
 */
public class WebFacts {

    public WebFacts(String symbol) throws IOException {

        // after, make sure that the symbol passed to SYM is a correct symbol
        SYM = symbol.toUpperCase();
        datesHist = new ArrayList<>();
        valuesHist = new ArrayList<>();
        current_Price_Name();
    }

    // the following method returns the current price of the 
    // specific symbol
    public void current_Price_Name() throws IOException {

        URL url = new URL("https://finance.yahoo.com/quote/" + SYM + "/");

        URLConnection urlConnect = url.openConnection();
        // urlConnect.setRequestProperty("User-Agent", "Mozilla/10.0");
        InputStreamReader inStream = new InputStreamReader(urlConnect.getInputStream());

        BufferedReader buff = new BufferedReader(inStream);

        String line = buff.readLine();
        String allCode = "";
        boolean found = false;
        //System.out.println("Fw(500) Pstart(10px) Fz(24px) C($dataGreen)\" data-reactid=\"35\"> ");
        while (line != null && !found) {

            if (line.contains(SYM)) {
                //System.out.println(line);
                allCode += line;

            }

            if (line.contains("\"},\"currency\":\"USD\",\"regularMarketPrice\":{\"raw\":")) {
                int x = line.indexOf("\"regularMarketPrice\":{\"raw\":") + 28;

                //value = Double.parseDouble(line.substring(x, line.indexOf(".", x) + 3));
                // CHANGE THE 2
                found = true;
            }

            if (line.contains("</script><meta charset=\"utf-8\"/><title>")) {
                int x = line.indexOf("</script><meta charset=\"utf-8\"/><title>") + 39;

                //value = Double.parseDouble(line.substring(x, line.indexOf(".", x) + 3));
                // CHANGE THE 2
                companyName = line.substring(x, line.indexOf(" Stock Price, Quote, History"));
                
                if(companyName.contains("amp;")){
                    companyName = companyName.replace("amp;", "");
                }

            }

            if (line.contains("Fw(500) Fz(14px) C($dataGreen)\" data-reactid=\"16\">")) {

                int x = line.indexOf("Fw(500) Fz(14px) C($dataGreen)\" data-reactid=\"16\">") + 50;
                over_all_change = line.substring(x, line.indexOf("</span><div id=\"quote-market-notice\""));

            }

            if (line.contains("Fw(500) Fz(14px) C($dataRed)\" data-reactid=\"16\">")) { // Fw(500) Fz(14px) C($dataRed)" data-reactid="16">

                int x = line.indexOf("Fw(500) Fz(14px) C($dataRed)\" data-reactid=\"16\">") + 49;
                over_all_change = line.substring(x, line.indexOf("</span><div id=\"quote-market-notice\""));

            }

//            if (line.contains("Previous Close</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\""
//                    + " data-test=\"PREV_CLOSE-value\" data-reactid=\"14\">"
//                    + "<span class=\"Trsdu(0.3s) \" data-reactid=\"15\">")) { // class="Trsdu(0.3s) " data-reactid="41">
//                int x = line.indexOf("Previous Close</span></td><td class=\"Ta(end) Fw(600) "
//                        + "Lh(14px)\" data-test=\"PREV_CLOSE-value\" data-reactid=\"14\"><span"
//                        + " class=\"Trsdu(0.3s) \" data-reactid=\"15\">") + 155;
//                System.out.println("previous close");
//                previousClose = line.substring(x, line.indexOf("</span></td></tr><tr class=\"Bxz(bb)"));
//            }
//////
//            if (line.contains("Open</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"OPEN-value\" data-reactid=\"19\"><span class=\"Trsdu(0.3s) \" data-reactid=\"20\">")) {
//                int x = line.indexOf("Open</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"OPEN-value\" data-reactid=\"19\"><span class=\"Trsdu(0.3s) \" data-reactid=\"20\">") +139 ;
//                System.out.println("open");
//                 open = line.substring(x, line.indexOf("</span></td></tr><tr class=\"Bxz(bb) Bdbw(1px) Bdbs(s) Bdc($c-fuji-grey-c) H(36px) \" data-reactid=\"21\"><td class=\"C(black) W(51%)\" data-reactid=\"22\"><span data-reactid=\"23\">Bid"));
//            }
//
//             if(line.contains("Bid</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"BID-value\" data-reactid=\"24\">" ) ){ 
//                  int x = line.indexOf("Bid</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"BID-value\" data-reactid=\"24\">")+92;
//               bid = line.substring(x, line.indexOf("</td></tr><tr class=\"Bxz(bb) Bdbw(1px) Bdbs(s) Bdc($c-fuji-grey-c) H(36px) \" data-reactid=\"25\"><td class=\"C(black) W(51%)\" data-reactid=\"26\">"));
//             }
//             if(line.contains("Ask</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"ASK-value\" data-reactid=\"28\">" ) ){ 
//                  int x = line.indexOf("Ask</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"ASK-value\" data-reactid=\"28\">")+92;
//               ask = line.substring(x, line.indexOf("</td></tr><tr class=\"Bxz(bb) Bdbw(1px) Bdbs(s) Bdc($c-fuji-grey-c) H(36px) \" data-reactid=\"29\">"));
//             }
//             if(line.contains("d=\"31\">Day&#x27;s Range</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"DAYS_RANGE-value\" data-reactid=\"32\">" ) ){ 
//                  int x = line.indexOf("d=\"31\">Day&#x27;s Range</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"DAYS_RANGE-value\" data-reactid=\"32\">")+119;
//               daysRange = line.substring(x, line.indexOf("</td></tr><tr class=\"Bxz(bb) Bdbw(1px) Bdbs(s) Bdc($c-fuji-grey-c) H(36px) \" data-reactid=\"33\"><td class=\"C(black) W(51%)\" dat"));
//             }
//             if(line.contains("52 Week Range</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"FIFTY_TWO_WK_RANGE-value\" data-reactid=\"36\">" ) ){ 
//                  int x = line.indexOf("52 Week Range</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"FIFTY_TWO_WK_RANGE-value\" data-reactid=\"36\">")+117;
//               weekRange = line.substring(x, line.indexOf("</td></tr><tr class=\"Bxz(bb) Bdbw(1px) Bdbs(s) Bdc($c-fuji-grey-c) H(36px) \" data-reactid=\"37\"><td class=\"C(black) W(51%)\" data-reactid=\"38\">"));
//             }
//             if(line.contains("Volume</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"TD_VOLUME-value\" data-reactid=\"40\"><span class=\"Trsdu(0.3s) \" data-reactid=\"41\">" ) ){ 
//                  int x = line.indexOf("Volume</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"TD_VOLUME-value\" data-reactid=\"40\"><span class=\"Trsdu(0.3s) \" data-reactid=\"41\">")+146;
//               volume = line.substring(x, line.indexOf("</span></td></tr><tr class=\"Bxz(bb) Bdbw(1px) Bdbs(s) Bdc($c-fuji-grey-c) H(36px) Bdbw(0)! \" data-reactid=\"42\"><"));
//             }
//
//if(line.contains("Avg. Volume</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"AVERAGE_VOLUME_3MONTH-value\" data-reactid=\"45\"><span class=\"Trsdu(0.3s) \" data-reactid=\"46\">" ) ){ 
//                  int x = line.indexOf("Avg. Volume</span></td><td class=\"Ta(end) Fw(600) Lh(14px)\" data-test=\"AVERAGE_VOLUME_3MONTH-value\" data-reactid=\"45\"><span class=\"Trsdu(0.3s) \" data-reactid=\"46\">")+163;
//               averageVolume = line.substring(x, line.indexOf("</span></td></tr></tbody></table></div><div class=\"D(ib) W(1/2) Bxz(bb) Pstart(12px) Va(t) ie-7_D(i"));
//             }
            line = buff.readLine();
        }

    }

    // the following method returns the highest value of the day
    public double dayHigh() {
        return 1.0;
    }

    // the following method returns the lowest value of the day.
    public double dayLow() {
        return 1.0;
    }

    public String get_symbol() {
        return SYM;
    }

    public String get_current_price() {
        return value;
    }

    public String get_overall_change() {
        return over_all_change;
    }

    public String getName() {
        return companyName;
    }

    public String get_previous_value() {
        return previousClose;
    }

    public ArrayList getHistValues(){
        return valuesHist;
    }
    
    public ArrayList getHistDates(){
        return datesHist;
    }
//    
    public String get_open() {
        return open;
    }
    
     public String bid(){
        return bid;
    }
      public String ask(){
        return ask;
    }
       public String daysRange(){
        return daysRange;
    }
        public String weekRange(){
        return weekRange;
    }
         public String volume(){
        return volume;
    }
          public String averageVolume(){
        return averageVolume;
    }

    public ArrayList<String> getHistory() throws MalformedURLException, IOException {

        ArrayList<String> chartData = new ArrayList<>();

        URL url = new URL("https://finance.yahoo.com/quote/" + SYM + "/history?p=" + SYM);

        URLConnection urlConnect = url.openConnection();
        // urlConnect.setRequestProperty("User-Agent", "Mozilla/10.0");
        InputStreamReader inStream = new InputStreamReader(urlConnect.getInputStream());

        BufferedReader buff = new BufferedReader(inStream);

        String line = buff.readLine();
        String allCode = "";
        int days = 0;
        Date today = new Date();
        
       
        Calendar myDate = Calendar.getInstance(); // set this up however you need it.

        int dow = myDate.get(Calendar.DAY_OF_WEEK);
        int mont = myDate.get(Calendar.MONTH);
        int dat = myDate.get(Calendar.DAY_OF_MONTH);
        int yaer = myDate.get(Calendar.YEAR);
        boolean isWeekday = ((dow >= Calendar.MONDAY) && (dow <= Calendar.FRIDAY));

        String getMonth = "";
        String getDate = "";
        String getYear = "";
        
        
         Day tryThis = new Day(mont, dow, dat, yaer);


        // get month, date, and year of 
        while (line != null) {

            if (line.contains(SYM)) {
               
                allCode += line;

            }
            if (line.contains(today.toString().substring(4, 10) + today.toString().substring(today.toString().length() - 4, today.toString().length()))) {
                
                for (int i = 0; i < 365; i++) {
isWeekday = ((dow >= Calendar.MONDAY) && (dow <= Calendar.FRIDAY));
                    if (isWeekday) {
                        int startPart1 = line.indexOf(tryThis.returnDate());
                        int end = line.indexOf(".", startPart1) + 2;
                        int start = line.indexOf(".", startPart1);
                        
                        while(!line.substring(start, start + 1).equals(">")){
                            
                            start -=1;
                            
                        }

                        opens.add(line.substring(start, i));
                        //

                        //int index_of_date = line.indexOf(myDate.substring());
                    }
                    
                    tryThis.incriment();
                    
                    
                }

            }

            line = buff.readLine();
        }
        
        //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for(int i = 0; i< opens.size(); i++){
            //(opens.get(i));
        }
        return chartData;
    }
    
    
    public void getHistoryPart2() throws IOException{
        
        System.out.println("it worked for amzn");
        
        
        String url = "https://finance.yahoo.com/quote/"+ SYM + "/history?p=" + SYM;
        ArrayList<String> downServers = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            if( cols.size() >1){
               //("col1 ----!!!"+ cols.get(0).text() + "Col 2---"+ cols.get(1).text());
               if(!cols.get(1).text().contains("Dividend")){
                   datesHist.add(cols.get(0).text());
                   
                   String pricePART2 = cols.get(1).text();
        
        if(pricePART2.contains(",")){
            pricePART2 = pricePART2.replace(",", "");
        }
        
        //double numberPrice = Double.parseDouble(pricePART2);
        
               valuesHist.add(pricePART2);
               }
            }else{
                //System.out.println("Other Content: " + cols.get(0).text());
            }
        
        }




        
}
    
    
     public void getInfo() throws IOException{
        
        String url = "https://finance.yahoo.com/quote/" + SYM + "/";
        ArrayList<String> downServers = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
            if( cols.size() >1){
               //("col1 ----!!!"+ cols.get(0).text() + "Col 2---"+ cols.get(1).text());
               if(cols.get(0).text().contains("Previous Close")){
                   
               previousClose = (cols.get(1).text());
               }
               if(cols.get(0).text().contains("Open")){
                  
              open = (cols.get(1).text());
              value = open;
               }
               if(cols.get(0).text().contains("Bid")){
                   bid = (cols.get(1).text());
               }
               if(cols.get(0).text().contains("Ask")){
                  ask = (cols.get(1).text());
               }
               if(cols.get(0).text().contains("Day's Range")){
                   daysRange = (cols.get(1).text());
               }
               if(cols.get(0).text().contains("52 Week Range")){
                   weekRange = (cols.get(1).text());
               }
               if(cols.get(0).text().contains("Volume")){
                   volume = (cols.get(1).text());
               }
               if(cols.get(0).text().contains("Avg. Volume")){
                  averageVolume = (cols.get(1).text());
               }
            }else{
                //System.out.println("Other Content: " + cols.get(0).text());
            }
        
        }




        
}

   
    

    private String companyName;
    private final String SYM;
    private String value;
    private ArrayList<String> opens = new ArrayList<>();
    private String over_all_change = "the temp";
    private String previousClose;
    private String open;
    private String bid;
    private String ask;
    private String daysRange;
    private String weekRange;
    private String volume;
    private String averageVolume;
    private ArrayList<String> datesHist;
    private ArrayList<String> valuesHist;
}


