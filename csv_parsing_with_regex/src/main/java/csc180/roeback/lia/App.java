package csc180.roeback.lia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class App{
    public static void main(String [] args){
        StringBuilder peopleCsv = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("OpenSourse\\csv_parsing_with_regex\\src\\main\\java\\csc180\\roeback\\lia\\people.to.regex.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                peopleCsv.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String people = peopleCsv.toString();
        Pattern pattern = Pattern.compile("([a-zA-Z0-9-']+\\s+[a-zA-Z0-9-']+),(\\d{3}-\\d{2}-\\d{4}),([a-zA-Z0-9.! # $ % & ' * + - \\/ = ? ^ _ { | } ~ .`]+@[a-zA-Z0-9-]+\\.+[a-zA-Z]{2,}),(\\d{3}-\\d{3}-\\d{4})");
        Matcher matcher = pattern.matcher(people);
        if(matcher.find()){
            while(matcher.find()){
                System.out.println("\nName: " + matcher.group(1) + "\nPhone Number: " + matcher.group(4));
            }
        }
    }
}
