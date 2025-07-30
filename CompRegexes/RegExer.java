package CompRegexes;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class RegExer {
    public static void main(String [] args) throws ParseException{
        
        if("/home/lia/documents/project/main.cpp".matches("(\\/[\\w\\/]+)\\.\\w+")){
            System.out.println("Linix Path Correct");
        }
        if("jane_doe+newsletter@sub.domain.co.uk".matches("(^[a-zA-Z0-9.! # $ % & ' * + - \\/ = ? ^ _ { | } ~ .`]+@)([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}")){
            System.out.println("Valid Email");
        }
        //("[a-zA-Z-0-9_@$.^]+") grabs key from the json
        JSONArray stockReport = (JSONArray) parser.parse(new FileReader("OpenSourse\\stock_statement_generator\\src\\main\\java\\csc180\\roeback\\lia\\stocks.json"));
    }
}
