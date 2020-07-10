package eistbrecher;

import eistbrecher.DisplaySize;
import eistbrecher.SmartPosition;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestSmartPosition {

    @Test
    public void testMoveOverBoundRight() {
        int x = 100;
        int y = 100;
        DisplaySize displaySize = new DisplaySize(x, y);
        DisplaySize objectSize = new DisplaySize(1,1);
        SmartPosition position = new SmartPosition(x, y, displaySize, objectSize);
        position.moveXBoundless(1);
        position.moveYBoundless(1);
        assertEquals(1, position.getX());
        assertEquals(1, position.getY());
    }

    @Test
    public void testMoveOverBoundLeft() {
        int x = 0;
        int y = 0;
        DisplaySize displaySize = new DisplaySize(100,100);
        DisplaySize objectSize = new DisplaySize(1,1);
        SmartPosition position = new SmartPosition(x, y, displaySize, objectSize);
        position.moveXBoundless(-1);
        assertEquals(99, position.getX());
    }

    @Test
    public void testMoveOverBoundUp() {
        int x = 0;
        int y = 0;
        DisplaySize displaySize = new DisplaySize(100,100);
        DisplaySize objectSize = new DisplaySize(1,1);
        SmartPosition position = new SmartPosition(x, y, displaySize, objectSize);
        position.moveYBoundless(-1);
        assertEquals(99, position.getY());
    }

    @Test
    public void testMoveOverBoundDown() {
        int x = 100;
        int y = 100;
        DisplaySize displaySize = new DisplaySize(x, y);
        DisplaySize objectSize = new DisplaySize(1,1);
        SmartPosition position = new SmartPosition(x, y, displaySize, objectSize);
        position.moveYBoundless(1);
        assertEquals(1, position.getY());
    }


}
