package csc180.roeback.lia;
import java.io.FileReader;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class App{
    public static void main(String [] args ){
        JSONParser parser = new JSONParser();
        try {
            int i = 5;
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
            System.err.println(date);
            System.out.println("Name: " + name);
            System.err.println("SSN: " + ssn);
            System.err.println("Email: " + email);
            System.err.println("Phone: " + phone);
            System.err.println("Account#: " + accountNumber);
            System.err.println("\nTYPE  SYMBOL  PRICE    SHARES    TOTAL");
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
                System.out.println(type + " | " + symbol + " | " + price + " | " + shares + " | $" + total);
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
            System.err.println("Cash Amount: $" + cash + "\nStock Amount: $" + stockEarnings);            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
