package cli_ttt.consoleui;

import ttt.GameException;
import ttt.Input;
import ttt.game.BoardOption;
import ttt.game.GameOption;

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

    public Integer getGameChoice(GameOption[] gameOptions) {
        String input = getInput();
        for (GameOption option : gameOptions) {
            if (option.key.equals(input)) {
                return Integer.valueOf(input);
            }
        }
        return null;
    }

    public Integer getBoardChoice(BoardOption[] boardOptions) {
        String input = getInput();
        for (BoardOption option : boardOptions) {
            if (option.key.equals(input)) {
                return Integer.valueOf(input);
            }
        }
        return null;
    }

    public Integer getUserLocation(List<Integer> board, int boardSize) throws GameException {
        String input = getInput();
        if (!isAnInteger(input)) {
            throw GameException.notANumber();
        }
        int location = (convertToInt(input) - 1);
        if (board.contains(location)) { return location; }
        return getError(boardSize, location);
    }

    private Integer getError(int boardSize, int location) throws GameException {
        if (location > boardSize - 1) {
            throw GameException.outOfBounds();
        } else {
            throw GameException.takenCell();
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
