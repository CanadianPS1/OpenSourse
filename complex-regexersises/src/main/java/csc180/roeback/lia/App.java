package csc180.roeback.lia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {
    public static void main(String [] args) throws ParseException, FileNotFoundException, IOException{
        
        if("/home/lia/documents/project/main.cpp".matches("(\\/[\\w\\/]+)\\.\\w+")){
            System.out.println("Linix Path Correct");
        }
        if("jane_doe+newsletter@sub.domain.co.uk".matches("(^[a-zA-Z0-9.! # $ % & ' * + - \\/ = ? ^ _ { | } ~ .`]+@)([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}")){
            System.out.println("Valid Email");
        }
        //("[a-zA-Z-0-9_@$.^]+") grabs key from the json
        JSONParser parser = new JSONParser();
        try{
            JSONArray json = (JSONArray) parser.parse(new FileReader("OpenSourse\\complex-regexersises\\src\\main\\java\\csc180\\roeback\\lia\\stocks.json"));
            String jsonString = json.toJSONString();
            Pattern pattern = Pattern.compile("(\"[a-zA-Z-0-9_@$.^]+\")");
            Matcher matcher = pattern.matcher(jsonString);
            if(matcher.find()){
                while(matcher.find()){
                    System.out.println(matcher.group());
                }
            }
        }catch(ParseException e) {
            System.err.println(e);
        }
        try {
            String filePath = "OpenSourse\\complex-regexersises\\src\\main\\java\\csc180\\roeback\\lia\\myProjects.html";
            String doc = new String(Files.readAllBytes(Paths.get(filePath)));
            Pattern pattern = Pattern.compile("https:\\/(\\/[a-zA-Z0-9.-]+)+");
            Matcher matcher = pattern.matcher(doc);
            if(matcher.find()){
                while(matcher.find()){
                    System.out.println(matcher.group());
                }
            }
           
        } catch (IOException e) {
        }
    }
}