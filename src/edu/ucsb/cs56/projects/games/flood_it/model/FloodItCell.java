package edu.ucsb.cs56.projects.games.flood_it.model;


import java.awt.Color;


/**
 * Class for the individual cells
 * 
 *
 * @author Chris Luo
 * @author Kevin Briggs
 */

//the class for the individual squares on a grid

public class FloodItCell{


	private Color c;
	private int row; //row number
	private int col; //column number


	//constructor for a cell
	public FloodItCell(int x, int y, Color z) {
		row = x;
		col = y;
		c = z;

	}


	//getters and setters

	public int getRow(){
		return row;
    	}

    	public int getCol(){
		return col;
    	}


	public Color getColor(){
		return c;
    	}



	public void setColor(Color x){

		c = x;
		
	}



}
