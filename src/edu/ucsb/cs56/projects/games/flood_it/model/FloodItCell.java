package edu.ucsb.cs56.projects.games.flood_it.model;


import java.awt.Color;


public class FloodItCell{


	private Color c;
	private int row;
	private int col;


	public FloodItCell(int x, int y, Color z) {
		row = x;
		col = y;
		c = z;

	}

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
