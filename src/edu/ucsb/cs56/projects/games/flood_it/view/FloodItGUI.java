package edu.ucsb.cs56.projects.games.flood_it.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * Class for the Flood it game JFrame
 * includes the main method
 * 
 * @author Sophia Mao
 * @author Dylan Hanson
 * @author Kai Jann
 @author Chris Luo
 @author Kevin Briggs
 */

public class FloodItGUI extends JFrame implements ActionListener{
    
    //private variables for all the GUI components
    private JFrame frame;
    private Container textContainer;
    private FloodItGrid gridBoard;
    private FloodItInstructGui instructions;
    private JTextArea messageArea;
    private JButton buttonRed;
    private JButton buttonBlue;
    private JButton buttonGreen;
    private JButton buttonYellow;
    private JButton buttonInstruction;
    private JPanel buttonPanel;
    private JTextField countdown;
    private JLabel movesLeft;

    //@dhanson
    private int [][] grid;
    private final Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.CYAN,Color.ORANGE,Color.BLACK};
    //private ArrayList<JButton> buttons = new ArrayList<JButton>();
    private String[] colorNames = {"Red","Blue","Green","Yellow","Magenta","Cyan","Orange","Black"};
    private int numColors;
    private int dimension;
    //static variables
    static Integer MOVES_LEFT = new Integer(25);

    public FloodItGUI(int dimension, int numColors){
	this.dimension = dimension;
	this.numColors = numColors;
    }

    //initialize JFrame
    public void init(){
	//set JFrame properties
	frame = new JFrame("Flood It! by SM and KJ and KB and CL and DH and DBN");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1000,800);

	grid = PopulateGrid(dimension, numColors);
	
	gridBoard = new FloodItGrid(grid, colors);

	buttonInstruction = new JButton("Instructions");
	
	//set JTextArea properties for the big message returning box
 	messageArea = new JTextArea(50,20);
	messageArea.setEditable(false);

	//set JTextField properties for countdown box
	countdown = new JTextField(MOVES_LEFT.toString(),2);
	countdown.setEditable(false);

	//JLabel for the countdown JTextArea
	movesLeft = new JLabel("moves left:");
	
	//Panel that holds the color buttons and countdown
	buttonPanel = new JPanel();
	
	//add Countdown components to buttonPanel
	buttonPanel.add(movesLeft);
	buttonPanel.add(countdown);

	//ALL button properties
	for(int i=0; i<numColors; i++)
	{
	    final int k = i;
	    JButton currentButton = new JButton(colorNames[i]);
	    currentButton.setBackground(colors[i]);
	    buttonPanel.add(currentButton);
	    currentButton.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			countdown.setText(decrementAMove().toString());
			if(MOVES_LEFT != 0)
			    messageArea.append(colorNames[k] +"\n");
			floodIt(0,0,k,grid[0][0]);
			gridBoard.redrawLabel(grid,colors);
		    }
		});
	}
		
	
	
	//buttonRed properties
	/*buttonRed = new JButton("Red");
	buttonRed.setBackground(Color.RED);
	buttonPanel.add(buttonRed);
	buttonRed.addActionListener(new ActionListener(){
		public void actionPerformed( ActionEvent e ){
		    countdown.setText(decrementAMove().toString());
		    if(MOVES_LEFT != 0)
			messageArea.append("red \n");
		    floodIt(0,0,0, grid[0][0]); 
		    gridBoard.redrawLabel(grid);//EDITTTTTLMLKMLMLML

		}
	    });
	
	//buttonBlue properties
	buttonBlue = new JButton("Blue");
	buttonBlue.setBackground(Color.BLUE);
	buttonBlue.setForeground(Color.WHITE);
	buttonPanel.add(buttonBlue);
	buttonBlue.addActionListener(new ActionListener(){
		public void actionPerformed( ActionEvent e ){
		    countdown.setText(decrementAMove().toString());
		    if(MOVES_LEFT != 0)
			messageArea.append("blue \n");
		    floodIt(0,0,1,grid[0][0]);
		    gridBoard.redrawLabel(grid);
		}
	    });

	

	
	//buttonGreen properties
	buttonGreen = new JButton("Green");
        buttonGreen.setBackground(Color.GREEN);
	buttonPanel.add(buttonGreen);
	buttonGreen.addActionListener(new ActionListener(){
		public void actionPerformed( ActionEvent e ){
		    countdown.setText(decrementAMove().toString());
		    if(MOVES_LEFT != 0)
			messageArea.append("green \n");
		    
		    floodIt(0,0,2,grid[0][0]);
		    gridBoard.redrawLabel(grid);
		}
	    });
	
	//buttonYellow properties
	JButton buttonYellow = new JButton("Yellow");
        buttonYellow.setBackground(Color.YELLOW);
       	buttonPanel.add(buttonYellow);
	buttonYellow.addActionListener(new ActionListener(){
		public void actionPerformed( ActionEvent e ){
		    countdown.setText(decrementAMove().toString());
		    if(MOVES_LEFT != 0)
			messageArea.append("yellow \n");
		    floodIt(0,0,3,grid[0][0]);
		    gridBoard.redrawLabel(grid);
		}
	    });
	
	*/
	
	
	//add buttonPanel to South component in BorderLayout of JFrame
	frame.getContentPane().add(BorderLayout.SOUTH,buttonPanel);
	
	//Container for text and instructions button
        textContainer = new Container();
	textContainer.setLayout(new BoxLayout(textContainer, BoxLayout.Y_AXIS));
	
	//add Components to textContainer
	textContainer.add(messageArea);
	textContainer.add(buttonInstruction);
	buttonInstruction.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    instructions = new FloodItInstructGui();
		    messageArea.append("you have clicked the instructions\n");
		}
	    });
	
	
	//add textContainer to JFrame
	frame.getContentPane().add(BorderLayout.EAST,textContainer);
	
	frame.getContentPane().add(BorderLayout.CENTER, gridBoard);
	
	frame.setVisible(true);
    }
    


    //@@@ TODO: add javadoc documentation
    public void run(){
	init();
    }




    //@@@ TODO: add javadoc documentation
    public Integer decrementAMove(){
	if(MOVES_LEFT <= 0){
	    messageArea.append("Out of moves!\n");
	    return 0;
	}
	else{
	    Integer numMoves = new Integer(--MOVES_LEFT);
	    return numMoves;
	}
    }
    public int[][] PopulateGrid(int dimension, int numColors)
    {
	int[][] result = new int[dimension][dimension];
	for(int i=0; i<dimension; i++)
	    {
		for(int j=0; j<dimension; j++)
		    {
			result[i][j] = (int)(Math.random()*numColors);
		    }
	    }
	return result;
    }
    


    //main method for Game Flood It
    public static void main(String args[]){
	//maybe error prone
	/**
	int dimension = (int) args[0];
	int numColors = (int) args[1];
	*/
	int dimension = 14;
	int numColors = 3;
	    

	FloodItGUI game = new FloodItGUI(dimension, numColors);
	game.run();
	
	
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
    }
 
      	
    

    public void floodIt(int x, int y, int newColor, int oldColor)
    {
	if(x<0 || y<0 || x>=grid.length || y>= grid.length) return;
	if(grid[x][y] != oldColor) return;
	grid[x][y] = newColor;
	floodIt(x, y+1, newColor, oldColor);
	floodIt(x, y-1, newColor, oldColor);
	floodIt(x+1, y, newColor, oldColor);
	floodIt(x-1, y, newColor, oldColor);
	return;
    }
    
}
