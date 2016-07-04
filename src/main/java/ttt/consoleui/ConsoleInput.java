package ttt.consoleui;

import ttt.GameException;
import ttt.Input;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public boolean isAnInteger(String input) {
        return input.matches("[0-9]+");
    }

    public String getReplay() {
        String stream = getInput();
        return stream;
    }

    public Integer getMenuChoice(List<Integer> options) {
        Integer choice =  validateChoice();
        if (options.contains(choice)) { return choice; }
        return null;
    }

    public Integer getUserLocation(List<Integer> board, int boardSize) throws GameException {
        String input = getInput();
        if (!isAnInteger(input)) {
            throw GameException.notANumber();
        }
        int location = (convertToInt(input) - 1);
        if (board.contains(location)) { return location; }
        if (location > boardSize) {
            throw GameException.outOfBounds();
        } else {
            throw GameException.takenCell();
        }
    }

    private Integer validateChoice() {
        String input = getInput();
        if (isAnInteger(input)) {
            return convertToInt(input);
        } else {
            return null;
        }
    }

    private int convertToInt(String input) {
        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (Exception ex) {
            choice = 0;
        }
        return choice;
    }


}
