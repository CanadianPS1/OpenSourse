package csc180.roeback.lia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App{
    public static void main(String [] args){
        System.out.println(new Main().isValidEmailAddress("spielenermode@gmail.com"));
        System.out.println(new Main().isValidEmailAddress("1pielenermode@gmail.com"));
        System.out.println(new Main().isValidMovieBefore1995("Star Wars (1977)"));
        System.out.println(new Main().isValidMovieBefore1995("Star Wars (1996)"));
        System.out.println(new Main().isValidSSN("123-45-6789"));
        System.out.println(new Main().isValidSSN("000-00-0000"));
        System.out.println(new Main().isValidSSN("666-45-6789"));
        System.out.println(new Main().isValidSSN("950-45-6789"));
        System.out.println(new Main().validatePasswordComplexity("B@byGr0k1sS0C00l",10,1,1,2,1));
        System.out.println(new Main().validatePasswordComplexity("BabyGr0k1sS0C00l",10,1,1,2,1));
        try {
            String filePath = "C:\\Users\\Lillia\\OneDrive\\Documents\\GitHub\\WebDev\\Weather\\Weather.html";
            String doc = new String(Files.readAllBytes(Paths.get(filePath)));
            String [] Content = new Main().getHTMLTagsContents(doc,"main");
            for (String Content1 : Content) {
                System.out.println(Content1);
            }
        } catch (IOException e) {
        }
        String[] links = new Main().getHTMLLinkURL("<a href=https://lms.neumont.edu/courses/3568799/assignments/38364932");
        for (String link : links) {
            System.out.println(link);
        }
    }
}
