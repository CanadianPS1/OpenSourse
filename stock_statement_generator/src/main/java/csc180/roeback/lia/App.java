package csc180.roeback.lia;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class App{
    public static void main(String [] args ){
        JSONParser parser = new JSONParser();
        try {
            int i = 50;
            //grabs the JSON and gets the i person from it
            JSONArray stockReport = (JSONArray) parser.parse(new FileReader("OpenSourse\\stock_statement_generator\\src\\main\\java\\csc180\\roeback\\lia\\stocks.json"));
            JSONObject person = (JSONObject) stockReport.get(i);
            //grabs all the info and throws it into a var
            String name = person.get("first_name") + " " + person.get("last_name");
            String ssn = person.get("ssn") + "";
            String phone = person.get("phone") + "";
            String email = person.get("email") + "";
            String accountNumber = person.get("account_number") + "";
            LocalDate date = LocalDate.now();
            JSONArray trades = (JSONArray) person.get("stock_trades");
            String startingCashString = person.get("beginning_balance") + "";
            double cash = Double.parseDouble(startingCashString.substring(startingCashString.indexOf('$') + 1));
            double stockEarnings = 0;
            //prints everything to the console for testing
            System.out.println(" ________________________________________________________");
            System.out.println("|" + printer("", 54) + "||");
            System.out.println("|" + printer(date + "", 54) + "||");
            System.out.println("|" + printer("Name: " + name, 54) + "||");
            System.out.println("|" + printer("SSN: " + ssn, 54) + "||");
            System.out.println("|" + printer("Email: " + email, 54) + "||");
            System.out.println("|" + printer("Phone: " + phone, 54) + "||");
            System.out.println("|" + printer("Account#: " + accountNumber, 54) + "||");
            System.out.println("||======================================================||");
            System.out.println("|| TYPE | SYMBOL |    PRICE   |  SHARES  |     TOTAL    ||");
            System.out.println("||======|========|============|==========|==============||");
            for(Object trading : trades){
                JSONObject trade = (JSONObject) trading;
                String type = trade.get("type").toString();
                String symbol = trade.get("stock_symbol").toString();
                String price = trade.get("price_per_share").toString();
                String shares = trade.get("count_shares").toString();
                int index = price.indexOf('$');
                double priceDouble = Double.parseDouble(price.substring(index + 1));
                double total = priceDouble * Integer.parseInt(shares);
                BigDecimal bd = new BigDecimal(total);
                bd = bd.setScale(2, RoundingMode.HALF_UP);
                total = bd.doubleValue();
                //echos all the trades
                System.out.println("|" + printer(type,6) + printer(symbol,8) + printer("" + price,12) + printer(shares, 10) + printer("$" + total, 14) + "||");
                if(type.equals("Sell")){
                    cash += total;
                    stockEarnings -= total;
                }else{
                    cash -= total;
                    stockEarnings += total;
                }
            }
            //rounds everything off
            BigDecimal cr = new BigDecimal(cash);
            cr = cr.setScale(2, RoundingMode.HALF_UP);
            cash = cr.doubleValue();
            BigDecimal earnings = new BigDecimal(stockEarnings);
            earnings = earnings.setScale(2, RoundingMode.HALF_UP);
            stockEarnings = earnings.doubleValue();
            System.out.println("||======================================================||");
            System.out.println("|" + printer("Cash Amount: $" + cash, 54) + "||");
            System.out.println("|" + printer("Stock Earnings: $" + stockEarnings, 54) + "||");
            System.out.println("||______________________________________________________||");

        }catch(IOException e) {
            System.out.println(e);
        } 
    }
    public static String printer(String word, int widthOfSection){
        try{
            String string = "";
            int wordLength = word.length();
            double firstHalf, secondHalf;
            firstHalf = Math.floor((widthOfSection - wordLength)/2);
            secondHalf = (widthOfSection - wordLength) - firstHalf;
            string += "|";
            for(int i = 0; i < firstHalf; i++){
                string += " ";
            }
            string += word;
            for(int i = 0; i < secondHalf; i++){
                string += " ";
            }
            //string += "|";
            return string;
        }catch(Exception e){
            System.out.println("ERROR: Number was Longer then box width");
        }
        return "";
    }
}
