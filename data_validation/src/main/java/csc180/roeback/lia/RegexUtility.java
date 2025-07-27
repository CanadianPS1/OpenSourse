package csc180.roeback.lia;
public interface RegexUtility {
	boolean isValidHumanName(String name);
	boolean isValidEmailAddress(String email);
	boolean isValidMovieBefore1995(String movie);
	boolean isValidSSN(String ssn);
	boolean validatePasswordComplexity(String password, int minLength, int minUpper, int minLower, int minNumeric, int minSymbols);
	String[] getHTMLTagsContents(String html, String tagName);
	String[] getHTMLLinkURL(String html);
}