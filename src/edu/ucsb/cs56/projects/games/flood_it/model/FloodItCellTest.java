package edu.ucsb.cs56.projects.games.flood_it.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.awt.Color;


/** Test class for Flood It Cell

    @author Chris Luo
    @author Kevin Briggs
    @version 2014/02/27 for proj1, cs56, W14
    @see FloodItCell
*/

public class FloodItCellTest{

    public static final Color purple = new Color(99, 95, 170);
    public static final Color blue = new Color(70, 177, 226);
    public static final Color green = new Color(126, 157, 30);
    public static final Color yellow = new Color(243, 246, 29);
    public static final Color red = new Color(220, 74, 32);
    public static final Color pink = new Color(237, 112, 161);

    /** Test case for constructor
	@see FloodItCell#FloodItCell
    */

@Test
public void test_constructor(){
    FloodItCell c1 = new FloodItCell(12,12,blue);
    assertEquals(12, c1.getRow());
    assertEquals(12, c1.getCol());
    assertEquals(blue, c1.getColor());
}

    /** Test case for getRow method
	@see FloodItCell#getRow
    */

    @Test
    public void test_getRow(){
	FloodItCell c1 = new FloodItCell(12,12,blue);
	assertEquals(12, c1.getRow());
    }

    /** Test case for getCol method
	@see FloodItCell#getCol
    */

    @Test
    public void test_getCol(){
	FloodItCell c1 = new FloodItCell(12,12,blue);
	assertEquals(12, c1.getCol());
    }

    /** Test case for getColor method
	@see FloodItCell#getColor
    */

    @Test
    public void test_getColor(){
	FloodItCell c1 = new FloodItCell(12,12,blue);
	assertEquals(blue, c1.getColor());
    }

    /** Test case for setColor(){
	@see FloodItCell#setColor
    */

    @Test
    public void test_setColor(){
	FloodItCell c1 = new FloodItCell(12,12,blue);
	c1.setColor(red);
	assertEquals(red, c1.getColor());
    }
}
