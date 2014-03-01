package edu.ucsb.cs56.projects.games.flood_it.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/** Test class for Flood It Grid

    @author Chris Luo
    @author Kevin Briggs
    @version 2014/02/27 for prog1, cs56, W14
    @see FloodItGrid
*/

public class FloodItGridTest{

/** Test case for constructor
    @see FloodItGrid#FloodItGrid
*/

@Test
public void test_constructor(){
    FloodItGrid g1 = new FloodItGrid(12, 12);
    assertEquals(12, g1.getRows());
    assertEquals(12, g1.getCols());
}

    /** Test case for getRows method
	@see FloodItGrid#getRows
    */

    @Test
    public void test_getRows(){
	FloodItGrid g1 = new FloodItGrid(12, 12);
	assertEquals(12, g1.getRows());
    }

    /** Test case for getCols method
	@see FloodItGrid#getCols
    */

    @Test
    public void test_getCols(){
	FloodItGrid g1 = new FloodItGrid(12, 12);
	assertEquals(12, g1.getCols());
    }

    /** Test case for toString method
	@see FloodItGrid#toString
    */

    @Test
    public void test_toString(){
	FloodItGrid g1 = new FloodItGrid(12, 12);
	assertEquals("FloodItGrid[rows=12,cols=12]", g1.toString());
    }




}
