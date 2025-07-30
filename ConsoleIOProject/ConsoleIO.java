package ConsoleIOProject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIO {

	private static BufferedReader buffy = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Generates a prompt that allows the user to enter any response and returns the String.
	 * This method never accepts null inputs. This method will accept
	 * empty or whitespace-only inputs when allowBlank is true.
	 * @param prompt - the prompt to be displayed to the user.
	 * @param allowBlank - determines whether empty/whitespace-only inputs should be accepted
	 * @return the input from the user as a String
	 */
	public static String promptForString(String prompt, boolean allowBlank){
		while(true){
            System.out.println(prompt);
            try{
                String input = buffy.readLine();
                if(input == null && !allowBlank){
                    continue;
                }if(!allowBlank && input.trim().isEmpty()){
                    System.out.println("Input cannot be blank");
					continue;
                }
                return input;
            }catch (IOException e){
                System.out.println("You have a bad exeption try again");
            }
        }
        //throw new UnsupportedOperationException("The promptForString method is not yet implemented.");
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing an int value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the int value
	 */
	public static int promptForInt(String prompt, int min, int max){
		while(true){
            System.out.println(prompt);
            try{
                String inputTemp = buffy.readLine();
				if(inputTemp.trim().isEmpty()){
					continue;
				}
				int input = Integer.parseInt(inputTemp);
                if(input <= max && input >= min){
					return input;
                }else{
					System.out.println("Input cannot be blank or is above or below the max");
					continue;
				}
            }catch (IOException e){
                System.out.println(e);
            }catch(NumberFormatException e){
				System.out.println(e);
			}
        }
        //throw new UnsupportedOperationException("The promptForInt method is not yet implemented.");
	}
	
	/**
	 * Generates a prompt that expects the user to enter one of two responses that will equate
	 * to a boolean value. The trueString represents the case insensitive response that will equate to true. 
	 * The falseString acts similarly, but for a false boolean value.
	 * 		Example: Assume this method is called with a trueString argument of "yes" and a falseString argument of
	 * 		"no". If the user enters "YES", the method returns true. If the user enters "no", the method returns false.
	 * 		All other inputs are considered invalid, the user will be informed, and the prompt will repeat.
	 * @param prompt - the prompt to be displayed to the user
	 * @param trueString - the case insensitive value that will evaluate to true
	 * @param falseString - the case insensitive value that will evaluate to false
	 * @return the boolean value
	 */
	public static boolean promptForBoolean(String prompt, String trueString, String falseString){
		while(true){
            System.out.println(prompt);
            try{
                String input = buffy.readLine();
                if((input.toLowerCase()).equals(trueString.toLowerCase())){
					System.out.println("The String was True");
					return true;
                }else if((input.toLowerCase()).equals(falseString.toLowerCase())){
					System.out.println("The String was False");
					return false;
				}else{
					System.out.println("Invalid Prompt");
					continue;
				}
            }catch (IOException e){
                System.out.println("You have a bad exeption try again");
            }
        }
		//throw new UnsupportedOperationException("The promptForBoolean method is not yet implemented.");
	}

	/**
	 * Generates a console-based menu using the Strings in options as the menu items.
	 * Reserves the number 0 for the "quit" option when withQuit is true.
	 * @param options - Strings representing the menu options
	 * @param withQuit - adds option 0 for "quit" when true
	 * @return the int of the selection made by the user
	 */
	public static int promptForMenuSelection(String[] options, boolean withQuit){
		while(true){
            try{
				if(withQuit){
					System.out.println("[0] Quit");
				}
				for(int i = 0; i < options.length; i++){
					System.out.println("[" + (i + 1) + "]" + options[i]);
				}
				String inputTemp = buffy.readLine();
				int input = Integer.parseInt(inputTemp);
				if(input >= 0 && input <= options.length && withQuit){
					return input;
				}else if(input >= 1 && input <= options.length){
					return input;
				}else{
					continue;
				}

            }catch (IOException e){
                System.out.println("You have a bad exeption try again");
            }
        }
		//throw new UnsupportedOperationException("The promptForMenuSelection method is not yet implemented.");
	}

}