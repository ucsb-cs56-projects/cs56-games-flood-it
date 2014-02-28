package edu.ucsb.cs56.projects.games.flood_it.view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/** 
    Class where Pop-up JFrame for instructions (Flood it) is created.
    @author Sophia Mao
    @version 5/31/13 for proj 2, cs56, S13
    @author Chris Luo
    @author Kevin Briggs
    @version 2/28/14 for proj 1, cs56, W14
*/

public class FloodItInstructGui{
    public FloodItInstructGui(){
	
	
	//initialize and set JFrame visible and size
	JFrame frame = new JFrame ("Rules");
	frame.setVisible(true);
	frame.setSize(400,400);
	
	// create a new JTextArea to place on JFrame
	JTextArea rules = new JTextArea(50, 50);
	
	//From instructions.txt, read in the lines in the file and print instructions into the JTextArea declared above.
	// use try catch block to check to make sure txt file exists.
	try{
	    String line;
	    String fileName = "./src/instructions.txt"; //@@@ need to change when packaging happens.
	    
	    FileInputStream in = new FileInputStream(fileName);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    
	    //use a while loop to read all the text in txt file
	    while(( line = br.readLine()) != null){
		rules.append(line + "\n");
	    }
	}catch(Exception e){
	    // print out current user directory and also exception method
	    System.out.println("specified file or directory does not exist in " + System.getProperty("user.dir") + "\n exception message" + e);
	}
	
	//initialize aspects of JTextArea
	rules.setEditable(false);
	rules.setLineWrap(true);
	rules.setWrapStyleWord(true);
	
	//add JTextArea to a JScrollPane
	JScrollPane scroller = new JScrollPane(rules);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	//add JScrollPane to the frame
	frame.add(scroller);
	
    }
    
    
}




