package ttt;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PlayerFactoryTest {

    private String X = PlayerFactory.Marks.X.mark;
    private String O = PlayerFactory.Marks.O.mark;

    @Test
    public void createsAHumanvHumanGameWhereXGoesFirst() {
        Player player = getPlayer(1, 0);
        assertTrue(player.getClass().equals(new HumanPlayer(X).getClass()));
        assertTrue(player.getMark().equals(X));
    }

    private Player getPlayer(int type, int player) {
        return PlayerFactory.create(type).get(player);
    }

    @Test
    public void createsAHumanvHumanGameWhereOGoesFirst() {
        Player player = getPlayer(2, 0);
        assertTrue(player.getClass().equals(new HumanPlayer(O).getClass()));
        assertTrue(player.getMark().equals(O));
    }

    @Test
    public void createsARandomComputerWhereHumanGoesFirst() {
        Player player = getPlayer(3, 1);
        assertTrue(player.getClass().equals(new ComputerPlayer(new RandomLocationGenerator(), O).getClass()));
        assertTrue(player.getMark().equals(O));
    }

    @Test
    public void createsARandomComputerWhereComputerGoesFirst() {
        Player player = getPlayer(4, 0);
        assertTrue(player.getClass().equals(new ComputerPlayer(new RandomLocationGenerator(), X).getClass()));
        assertTrue(player.getMark().equals(X));
    }

    @Test
    public void createsAPerfectPlayer() {
        Player player = getPlayer(5, 1);
        assertTrue(player.getClass().equals(new PerfectPlayer("O").getClass()));
        assertTrue(player.getMark().equals(O));
    }

    @Test
    public void createsAPerfectPlayerThatGoesFirst() {
        Player player = getPlayer(6, 0);
        assertTrue(player.getClass().equals(new PerfectPlayer("O").getClass()));
        assertTrue(player.getMark().equals(X));
    }
}