public class FileIO {
    public static void main(String [] args){
        ConsoleIO.promptForString("Say hi", false);
        ConsoleIO.promptForInt("Give me a Number Between 1 and 10", 1, 10);
        ConsoleIO.promptForBoolean("Are you cool?", "Yes", "No");
        String[] options = new String[3];
        options[0] = "Settings";
        options[1] = "Conroles";
        options[2] = "Play";
        ConsoleIO.promptForMenuSelection(options, true);
    }
}
