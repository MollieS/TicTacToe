package ttt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputTest {

    private InputFake input;

    @Before
    public void setUp() {
        this.input = new InputFake();
    }

    @Test
    public void doesNotAllowLettersForLocation() {
        assertFalse(input.isAnInteger("HELLO"));
    }

    @Test
    public void getsReplayAnswer() {
        input.set("y");
        assertTrue(input.getReplay().contains("y"));
    }

    @Test
    public void getsValidBoardChoice() {
        input.set("1");
        assertEquals(Integer.valueOf(1), input.getMenuChoice(Arrays.asList(1, 2)));
    }

    @Test
    public void doesNotReturnInvalidInput() {
        input.set("Hello");
        assertEquals(null, input.getMenuChoice(Arrays.asList(1, 2)));
    }

    @Test
    public void doesNotReturnInvalidBoardOption() {
        input.set("3");
        assertEquals(null, input.getMenuChoice(Arrays.asList(1, 2)));
    }

    @Test
    public void getValidGameChoice() {
        input.set("1");
        assertEquals(Integer.valueOf(1), input.getMenuChoice(Arrays.asList(1, 2)));
    }

    @Test
    public void doesNotReturnInvalidGameInput() {
        input.set("Hello");
        assertEquals(null, input.getMenuChoice(Arrays.asList(1, 2)));
    }

    @Test
    public void doesNotReturnInvalidGameChoice() {
        input.set("30");
        assertEquals(null, input.getMenuChoice(Arrays.asList(1, 2)));
    }

    @Test
    public void doesNotReturnInvalidLocationInput() {
        input.set("Hello");
        assertEquals(null, input.getUserLocation(Arrays.asList(1, 2)));
    }

    @Test
    public void formatsLocationForBoard() {
        input.set("2");
        assertEquals(Integer.valueOf(1), input.getUserLocation(Arrays.asList(1, 2)));
    }

    @Test
    public void doesNotReturnInvalidLocation() {
        input.set("9");
        assertEquals(null, input.getUserLocation(Arrays.asList(1, 2)));
    }
}
