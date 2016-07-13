package cli_ttt;

import cli_ttt.consoleui.ConsoleBoard;
import cli_ttt.consoleui.ConsoleDisplay;
import cli_ttt.consoleui.ConsoleInput;
import cli_ttt.players.ConsolePlayer;
import ttt.game.GameMenu;
import ttt.game.Marks;

public class Main {

    public static void main(String[] args) {
        ConsoleDisplay display = new ConsoleDisplay();
        ConsoleBoard consoleBoard = new ConsoleBoard();
        ConsoleInput input = new ConsoleInput();
        ConsolePlayer player = new ConsolePlayer(Marks.X, input);
        ConsolePlayer player2 = new ConsolePlayer(Marks.O, input);
        GameMenu menu = new GameMenu(input, display, consoleBoard, player, player2);
        menu.start();
    }
}