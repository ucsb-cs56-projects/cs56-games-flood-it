package edu.ucsb.cs56.projects.games.flood_it.view;

import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.util.Random;

/** Class for the board of Flood It
  @author Sophia Mao
  @author Kai Jann
  @author Chris Luo
  @author Kevin Briggs
*/

//@@@ TODO: implement draw board for the game board
// use an ArrayList<Color> for each color cube in the grid 

public class FloodItGrid extends JPanel {
    
    
    private JLabel label;
	
    public FloodItGrid(int[][] grid, Color[] colors){
    	
    	label = new JLabel("test");
    	//this.setBackground(Color.MAGENTA);
    	//this.add(label);
	this.setLayout(new GridLayout(grid.length,grid.length));
	//int i=0;

	
	for(int j=0; j<grid.length; j++){
	    for(int k=0; k<grid.length; k++){
		JPanel currentPanel = new JPanel();
		currentPanel.setBackground(colors[grid[j][k]]);
		add(currentPanel);
		
	    }
	}
    }

    public void redrawLabel(int [][] grid, Color[] colors){
	removeAll();

	setLayout(new GridLayout(grid.length, grid.length));
	for(int j=0; j<grid.length; j++){
	    for(int k=0; k<grid.length; k++){
		JPanel current = new JPanel();
		current.setBackground(colors[grid[j][k]]);
		add(current);
	    
	    }
	}
    }

		  
       
}
