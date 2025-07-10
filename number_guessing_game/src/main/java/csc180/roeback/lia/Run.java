package csc180.roeback.lia;
import java.util.Random;
import java.util.ArrayList;
<<<<<<< HEAD:number_guessing_game/src/main/java/csc180/roeback/lia/App.java
import ConsoleIO.ConsoleIO;
public class App{
=======
import ConsoleIO.jar;
public class Run{
>>>>>>> 8df7dac5643632f4e59e55559548a90323e357a5:number_guessing_game/src/main/java/csc180/roeback/lia/Run.java
    public static void main( String[] args ){
        promptForDiffuculty();
    }
    //prompts for the diffeculty and starts the game
    public static void promptForDiffuculty(){
        while(true){
            String difficulty = ConsoleIO.promptForString("~SELCT DIFFUCULTY~ \n EASY \n MEDIUM \n HARD", false);
            difficulty = difficulty.toLowerCase();
            if(difficulty.equals("easy")){
                guessing(1,10,5);
            }else if(difficulty.equals("medium")){
                guessing(1,50,5);
            }else if(difficulty.equals("hard")){
                guessing(1,100,5);
            }else{
                continue;
            }
        }
    }
    //the method for prompting guesses and holds the code for the game part of the game
    public static void guessing(int min, int max, int maxTrys){
        Random rand = new Random();
        int trys = 0;
        int guess = 0;
        int randomNum = rand.nextInt(min,max + 1);
        ArrayList<Integer> priorGuesses = new ArrayList<>();
        while(true){
            try{
                while(trys <= maxTrys){
                    guess = ConsoleIO.promptForInt("Guess a Number between " + min + " and " + max + ": ", min, max);
                    if(!priorGuesses.contains(guess)){
                        if(guess == randomNum){
                            System.out.println("YOU GUESSED THE NUMBER!!! \n YOU WON IN " + trys + " GUESSES");
                            break;
                        }else if(guess < randomNum){
                            System.out.println(guess + " is LESS THAN the random num");
                        }else{
                            System.out.println(guess + " is GRATER THAN the random num");
                        }
                        System.out.println("GUESSES: " + trys);
                        priorGuesses.add(guess);
                        trys++;
                    }else{
                        System.out.println("You Entered " + guess + " Twice, your guess has been refunded");
                    }
                }
                if(trys > maxTrys){
                    System.out.println("you FAILED \n the number was " + randomNum + "\n Would you like to play again? \nYES\nNO");
                }else{
                    System.out.println(" Would you like to play again? \\n" + "YES\\n" + "NO");
                }
                while(true){
                    String playAgain = ConsoleIO.promptForString("", false);
                    playAgain = playAgain.toLowerCase();
                    if(playAgain.equals("yes")){
                        promptForDiffuculty();
                    }else if(playAgain.equals("no")){
                        System.out.println("Have a nice day :)");
                        System.exit(0);
                    }
                }
            }catch(NumberFormatException e){
                System.out.println("ERROR: FAILED TO ENTER A CORRECT NUMBER");
            }
        }
    }
}
