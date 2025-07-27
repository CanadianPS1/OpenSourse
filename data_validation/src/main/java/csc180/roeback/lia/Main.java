package csc180.roeback.lia;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main implements RegexUtility{
    /**
	 * Be sure to account for middle name, middle initial, and prefix (Mr, Ms, Miss, Mrs, Dr).  Ensure proper capitalization.
	 * @param name the name to check
	 * @return true if valid; otherwise false
	 */
    @Override
    public boolean isValidHumanName(String name){
        if(name.matches("\\w+.\\s\\w+\\s\\w+")) return true;
        else return false;
    }
    /**
	 * Username must be at least 1 non-numeric character.  After the first character and before the '@' can be any alpha (any case)
	 * any numeric, and only the symbols '_' and '.'.
	 * The domain name section must contain at least a 1 character sub-domain.  Again the first character must be alpha (in either case)
	 * and the remaining characters can be alpha or numeric.  The top-level domain can be 3-4 alphanumeric characters of either case.
	 * @param email the email address to check
	 * @return true if valid; otherwise false
	 */
    @Override
    public boolean isValidEmailAddress(String email){
        if(email.matches("[^0-9]\\w+@\\w+\\.\\w{3}")) return true;
        else return false;
    }
    /**
	 * Returns if movie title has a release year before 1995.
	 * @param movie in format: "Star Wars (1977)"
	 * @return true if valid; else false
	 */
    @Override
    public boolean isValidMovieBefore1995(String movie){
        Pattern pattern = Pattern.compile("\\w+\\s\\w+\\s\\((\\d{4})\\)");
        Matcher matcher = pattern.matcher(movie);
        if(matcher.find()){
            return Integer.parseInt(matcher.group(1)) < 1995;
        }else return false;
    }
    /**
	 * A US compliant SSN
	 * reserach what digits are allowed in which locations (some have minimum values)
	 * @param ssn
	 * @return
	 */
    @Override
    public boolean isValidSSN(String ssn){
        Pattern pattern = Pattern.compile("(\\d{3})-(\\d{2})-(\\d{4})");
        Matcher matcher = pattern.matcher(ssn);
        if(matcher.find()){
            if(!(matcher.group(1).equals("000")) && !(matcher.group(2).equals("00")) && !(matcher.group(1).equals("0000"))){
                if(!(matcher.group(1).equals("666"))){
                    if(!(Integer.parseInt(matcher.group(1)) < 999 && Integer.parseInt(matcher.group(1)) > 900)){
                        return true;
                    }else return false;
                } else return false;
            }else return false;
        }else return false;
    }
    /**
	 * Validate that a given password matches the given complexity requirements
	 * @param password the password to check
	 * @param minLength the minimum length the password is allowed to be
	 * @param minUpper the minimum number of upper case alpha characters the password must have
	 * @param minLower the minimum number of lower case alpha characters the password must have
	 * @param minNumeric the minimum number of numeric characters the password must have
	 * @param minSymbols the minimum number of non-alphanumeric characters the password must have
	 * @return
	 */
    @Override
    public boolean validatePasswordComplexity(String password, int minLength, int minUpper, int minLower, int minNumeric, int minSymbols){
        if(password.length() >= minLength){
            int amountOfUppers = 0;
            for(int i = 0; i < password.length(); i++){
                if(Character.isUpperCase(password.charAt(i))) amountOfUppers++;
            }
            if(amountOfUppers >= minUpper){
                int amountOfLowers = 0;
                for(int i = 0; i < password.length(); i++){
                    if(Character.isLowerCase(password.charAt(i))) amountOfLowers++;
                }
                if(amountOfLowers >= minLower){
                    int amountOfNumbers = 0;
                    for(int i = 0; i < password.length(); i++){
                        if(Character.isDigit(password.charAt(i))) amountOfNumbers++;
                    }
                    if(amountOfNumbers >= minNumeric){
                        int amountOfSymbles = 0;
                        for(int i = 0; i < password.length(); i++){
                            int type = Character.getType(password.charAt(i));
                            if(type == Character.MATH_SYMBOL || 
                                type == Character.CURRENCY_SYMBOL || 
                                type == Character.MODIFIER_SYMBOL || 
                                type == Character.OTHER_SYMBOL ||
                                type == Character.CONNECTOR_PUNCTUATION ||
                                type == Character.DASH_PUNCTUATION ||
                                type == Character.START_PUNCTUATION ||
                                type == Character.END_PUNCTUATION ||
                                type == Character.INITIAL_QUOTE_PUNCTUATION ||
                                type == Character.FINAL_QUOTE_PUNCTUATION ||
                                type == Character.OTHER_PUNCTUATION) amountOfSymbles++;
                        }
                        if(amountOfSymbles >= minSymbols) return true;
                        else return false;
                    }else return false;
                }else return false;
            }else return false;
        }else return false;
    }
    /**
	 * Get the content of all occurences of an html tag given it's name and the html string in which it occurs
	 * @param html the html string to be searched
	 * @param tagName the tagName for which the inner content should be returned
	 * @return
	 */
    @Override
    public String[] getHTMLTagsContents(String html, String tagName){
        ArrayList<String> tags = new ArrayList<>();
        Pattern pattern = Pattern.compile("<!DOCTYPE\\s+html>");
        Matcher matcher = pattern.matcher(html);
        if(matcher.find()){
            String dummy = "";
            for(int i = html.indexOf(tagName); i < html.length(); i++){
                if(html.charAt(i) == ' ') continue;
                if(html.charAt(i) == '<'){
                    String checkForEnd = "";
                    checkForEnd =  "" + html.charAt(i);
                    if(checkForEnd.contains(tagName)){
                        tags.remove(0);
                        return tags.toArray(new String[0]);
                    }
                    tags.add(dummy);
                    dummy = "";
                    while(true){
                        i++;
                        checkForEnd += html.charAt(i);
                        if(checkForEnd.contains(tagName)){
                            tags.remove(0);
                            return tags.toArray(new String[0]);
                        }
                        if(html.charAt(i) == '>') break;
                    }
                }
                if(html.charAt(i) == '>'){
                    continue;
                }else dummy += html.charAt(i);
            }
        }else{
            System.out.println("Is not a HTML doc");
        }
        tags.remove(0);
        return tags.toArray(new String[0]);
    }
    /**
	 * For all occurrences of a link tag ("<a href=..") in the string html
	 * return the URL to which the link goes
	 * @param html the string to be searched
	 * @return an array of link destinations
	 */
    @Override
    public String[] getHTMLLinkURL(String html){
        ArrayList<String> words = new ArrayList<>();
        if(html.matches("<a\\s+href=.+")){
            for(int i = 0; i < html.length(); i++){
                if(html.charAt(i) == '/'){
                    String dummy = "";
                    int endPoint = i;
                    for(int j = i; j < html.length(); j++){
                        if(html.charAt(j) == '/'){
                            words.add(dummy);
                            dummy = "";
                            continue;
                        }else dummy = dummy + html.charAt(j);
                        endPoint = j;
                    }
                    i = endPoint;
                }
            }
        }else{
            System.err.println("Not Valid <a>");
        }
        return words.toArray(new String[0]);
    }
    
}
