package cli_ttt.players;

import cli_ttt.consoleui.ConsoleInput;
import ttt.Input;
import ttt.Player;
import ttt.game.Board;
import ttt.game.Marks;

public class ConsolePlayer implements Player {
    private Marks mark;
    private Input input;

    public ConsolePlayer(Marks mark, Input input) {
        this.input = input;
        this.mark = mark;
    }

    public Marks getMark() {
        return mark;
    }

    public int getLocation(Board board) throws Exception {
        return input.getUserLocation(board.availableMoves(), board.size());
    }

    public Class playerType() {
        return getClass();
    }
}
