package edu.ucsb.cs56.projects.games.flood_it.model;



import java.awt.Color;
import java.lang.math;

/**
 * Class for the grid
 * 
 *
 * @author Chris Luo
 * @author Kevin Briggs
 */

public class FloodItGrid {
     private int rows;
     private int cols;
     private int numColors = 6;
     private Color[][] board;  


    public static final Color purple = new Color(99, 95, 170);
    public static final Color blue = new Color(70, 177, 226);
    public static final Color green = new Color(126, 157, 30);
    public static final Color yellow = new Color(243, 246, 29);
    public static final Color red = new Color(220, 74, 32);
    public static final Color pink = new Color(237, 112, 161);







     public FloodItGrid(int r, int c) {
        // set rows and cols here
	 rows = r;
	 cols = c;

	board = new Color[rows][cols];

	for(int i=0; i<rows; i++)
		for(int j=0; j<cols; j++)
			Color[i][j] = randColor();
	 
     }


	
	public Color randColor(){
		Random r = new Random();

    
    		int r2 = r.nextInt((numColors + 1));

    		switch(r2){
			case 0:
				return purple;
			case 1:
				return blue;
			case 2:
				return green;
			case 3:
				return pink;
			case 4:
				return yellow;
			case 5:
				return red;
		}
	
	}

	
    // add getters for rows and cols, but no setters.
    public int getRows(){
	return rows;
    }

    public int getCols(){
	return cols;
    }

    // add a toString method that just prints something like:
    //     FloodItGrid[rows=8,cols=6]

    public String toString(){
	return "FloodItGrid[rows=" + rows + ",cols=" + cols + "]";

    }
}
