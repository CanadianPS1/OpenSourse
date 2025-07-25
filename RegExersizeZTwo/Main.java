package RegExersizeZTwo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] args){
        System.out.println("--------------------------");
        FindNameAndID("User: Sarah, ID: 3249");
        FindNameAndID("User: Gatric, ID: 1234");
        System.out.println("--------------------------");
        FindProductAndPrice("Product: Mouse, Price: $49.99");
        FindProductAndPrice("Product: Dog, Price: $5.66");
        System.out.println("--------------------------");
        FindDateComponents("04/22/2023");
        FindDateComponents("05/24/2006");
        System.out.println("--------------------------");
        FindEmailDomainName("mike@openai.com");
        FindEmailDomainName("spielenermode@gmail.com");
        System.out.println("--------------------------");
        FindAreaCodeInPhoneNumber("(415) 829-9990");
        FindAreaCodeInPhoneNumber("(814) 812-9384");
        System.out.println("--------------------------");
    }
    public static void FindAreaCodeInPhoneNumber(String pap){
        Pattern pattern = Pattern.compile("\\((\\d{3})\\)\\s\\d{3}-\\d{4}");
        Matcher matcher = pattern.matcher(pap);
        if(matcher.find()){
            String areaCode = matcher.group(1);
            System.out.println("Area Code: " + areaCode);
        }else{
            System.err.println("Did not match the regex");
        }
    }
    public static void FindEmailDomainName(String pap){
        Pattern pattern = Pattern.compile("\\w+@(\\w+).\\w{3}");
        Matcher matcher = pattern.matcher(pap);
        if(matcher.find()){
            String domainName = matcher.group(1);
            System.out.println("Domain Name: " + domainName);
        }else{
            System.err.println("Did not match the regex");
        }
    }
    public static void FindDateComponents(String pap){
        Pattern pattern = Pattern.compile("(\\d{2})\\/(\\d{2})\\/(\\d{4})");
        Matcher matcher = pattern.matcher(pap);
        if(matcher.find()){
            String day = matcher.group(1);
            String month = matcher.group(2);
            String year = matcher.group(3);
            System.out.println("Day: " + day);
            System.out.println("Month: " + month);
            System.out.println("Year: " + year);
        }else{
            System.err.println("Did not match the regex");
        }
    }
    public static void FindProductAndPrice(String pap){
        Pattern pattern = Pattern.compile("Product:\\s(\\w+),\\sPrice:\\s\\$(\\d+.\\d{2})");
        Matcher matcher = pattern.matcher(pap);
        if(matcher.find()){
            String product = matcher.group(1);
            String price = matcher.group(2);
            System.out.println("Product: " + product);
            System.out.println("Price: " + price);
        }else{
            System.err.println("Did not match the regex");
        }
    }
    public static void FindNameAndID(String nai){
        Pattern pattern = Pattern.compile("User:\\s(\\w+),\\sID:\\s(\\d{4})");
        Matcher matcher = pattern.matcher(nai);
        if(matcher.find()){
            String name = matcher.group(1);
            String id = matcher.group(2);
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
        }else{
            System.err.println("Did not match the regex");
        }
    }
}
