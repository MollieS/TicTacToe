package ttt;

public class ConsoleDisplay implements Display {

    public void gameOptions() {
        write("How would you like to play?");
        write("1. Human v Human");
        write("2. Human v Random Computer");
        write("3. Random Computer v Human");
        write("4. Human v Perfect Computer");
        write("5. Perfect Computer v Human");
    }

    public void write(String message) {
        System.out.println(message);
    }

    public void takenCell() {
        write("Already taken");
    }

    public void invalidLocation() {
        write("Invalid location");
    }

    public void invalidInput() {
        write("Please choose a valid option");
        write("");
    }

    public void displayTurn(Marks mark) {
        write("");
        write(mark + "'s turn: choose a location");
    }

    public void promptForLocation() {
        write("-------------------------------");
        write("Please choose a location from 1 to 9");
        write("");
    }

    public void draw() {
        write("-------------------------------");
        write("It's a draw!");
        write("-------------------------------");
    }

    public String currentMark(Marks mark) {
        return mark.toString();
    }

    public void greet() {
        clearScreen();
        write("---------------------------------");
        write("Welcome to Tic Tac Toe");
        write("---------------------------------");
    }

    public void displayMarks(Marks mark1, Marks mark2) {
        write("Player Two's mark is " + mark2);
        write("Player One's mark is " + mark1);
        write("");
    }

    public void clearScreen() {
        write("\033[H\033[2J");
        System.out.flush();
    }

    public void winner(Marks mark) {
        write("");
        write(mark + " wins!");
        write("-----------------------");
    }

    public void replay() {
        write("Would you like to play again?");
        write("Type 1 to play, any other key to quit");
    }

    public void goodbye() {
        write("Thanks for playing!");
        write("Goodbye!");
    }

    public void boardOptions() {
        write("What size board would you like?");
        write("1. 3 x 3");
        write("2. 4 x 4");
        write("");
    }
}
