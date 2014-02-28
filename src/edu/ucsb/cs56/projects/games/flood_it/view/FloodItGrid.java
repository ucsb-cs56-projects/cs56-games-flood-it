package edu.cs56.projects.games.flood_it.view;


import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
    public FloodItGrid(){
    	
    	label = new JLabel("");
    	this.setBackground(Color.MAGENTA);
    	this.add(label);

    }




}
