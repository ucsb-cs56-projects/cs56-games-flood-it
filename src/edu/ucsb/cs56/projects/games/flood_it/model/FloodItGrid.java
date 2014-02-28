package edu.ucsb.cs56.projects.games.flood_it.model;

public class FloodItGrid {
     private int rows;
     private int cols;

     public FloodItGrid(int r, int c) {
        // set rows and cols here\
	 rows = r;
	 cols = c;

	 int 
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
