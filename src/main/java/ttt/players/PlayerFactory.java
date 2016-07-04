package ttt.players;

import ttt.Input;
import ttt.Player;
import ttt.consoleui.ConsoleInput;
import ttt.game.Marks;

import java.util.Arrays;
import java.util.List;

public class PlayerFactory {


    public static List<Player> create(int type, int boardSize) {
        Player player1;
        Player player2;
        Delay delay = new ComputerDelay();
        Input input = new ConsoleInput();
        RandomLocationGenerator randomGenerator = new RandomLocationGenerator();
        if (type == 1) {
            player1 = new HumanPlayer(Marks.X, input, boardSize);
            player2 = new HumanPlayer(Marks.O, input, boardSize);
        } else if (type == 2) {
            player1 = new HumanPlayer(Marks.X, input, boardSize);
            player2 = new RandomPlayer(randomGenerator, Marks.O, delay);
        } else if (type == 3) {
            player1 = new RandomPlayer(randomGenerator, Marks.X, delay);
            player2 = new HumanPlayer(Marks.O, input, boardSize);
        } else if (type == 4) {
            player1 = new HumanPlayer(Marks.X, input, boardSize);
            player2 = new PerfectPlayer(Marks.O, delay);
        } else if (type == 5) {
            player1 = new PerfectPlayer(Marks.X, delay);
            player2 = new HumanPlayer(Marks.O, input, boardSize);
        } else if (type == 6) {
            player1 = new PerfectPlayer(Marks.X, delay);
            player2 = new PerfectPlayer(Marks.O, delay);
        } else if (type == 7) {
            player1 = new PerfectPlayer(Marks.X, delay);
            player2 = new RandomPlayer(randomGenerator, Marks.O, delay);
        } else if (type == 8) {
            player1 = new RandomPlayer(randomGenerator, Marks.X, delay);
            player2 = new PerfectPlayer(Marks.O, delay);
        } else {
            player1 = new RandomPlayer(randomGenerator, Marks.X, delay);
            player2 = new RandomPlayer(randomGenerator, Marks.O, delay);
        }
        return Arrays.asList(player1, player2);
    }
}
