package de.tum.in.ase.eist;

import eistbrecher.DisplaySize;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDisplaySize {

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDisplay() {
        DisplaySize display = new DisplaySize(0, 0);
        new DisplaySize(-1, Integer.MAX_VALUE + 1);
    }

    @Test
    public void testScaleYTo() {
        DisplaySize display = new DisplaySize(100, 100);
        display.scaleYTo(400);
        assertEquals (400, display.getX());
        assertEquals (400, display.getY());
    }

    @Test
    public void testScaleXTo() {
        DisplaySize display = new DisplaySize(100, 100);
        display.scaleXTo(400);
        assertEquals (400, display.getX());
        assertEquals (400, display.getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidScale() {
        DisplaySize display = new DisplaySize(100, 100);
        display.scaleYTo(-100);
    }

    @Test
    public void testScaleToXNotEqualY() {
        DisplaySize display = new DisplaySize(200, 100);
        display.scaleXTo(300);
        assertEquals(300, display.getX());
        assertEquals(150, display.getY());
    }
}
