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
    private int difficultyLevel;
    private Integer MOVES_LEFT;
    //static variables
    //static Integer MOVES_LEFT = new Integer(25);

    public FloodItGUI(int dimension, int numColors, int difficultyLevel){
	this.dimension = dimension;
	this.numColors = numColors;
	this.difficultyLevel = difficultyLevel;
    }

    //initialize JFrame
    public void init(){
	//set MovesLeft (scales number of moves based on number of colors and dimension selected using 25 moves for a 6 color, 14x14 grid as a baseline.
	MOVES_LEFT = (int)Math.floor(dimension*numColors*25/84);//Thanks, autoboxing!
	if(difficultyLevel == 1) MOVES_LEFT = (int)Math.floor(MOVES_LEFT*.8);
	if(difficultyLevel == 3) MOVES_LEFT = /*Math.min(
						       (int)(Math.floor(MOVES_LEFT*Math.sqrt(dimension)*Math.pow(numColors,.25)/1.5)),
						       (int)( MOVES_LEFT*Math.sqrt(dimension)*Math.sqrt(numColors)/2));*/
				     (int)Math.floor(MOVES_LEFT * 2.33);
	//set JFrame properties
	frame = new JFrame("Flood It! by SM and KJ and KB and CL and DH and DBN");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1000,800);

	grid = PopulateGrid(dimension, numColors, difficultyLevel);
	
	gridBoard = new FloodItGrid(grid, colors);

	buttonInstruction = new JButton("Instructions");
	
	//set JTextArea properties for the big message returning box

	messageArea = new JTextArea(40,20);
	messageArea.setEditable(false);

	JScrollPane messageScroller = new JScrollPane(messageArea);
	messageScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

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
		
			if(MOVES_LEFT != 0 && !checkWin() && grid[0][0]!=k){
			    countdown.setText(decrementAMove().toString());
			    messageArea.append(colorNames[k] +"\n");
			    floodIt(0,0,k,grid[0][0]);
			    gridBoard.redrawLabel(grid,colors);
			    if(checkWin())
				messageArea.append("You Win :D\n");
			    else if(MOVES_LEFT == 0)
				messageArea.append("You Lose :(\n");
			}
			else if(MOVES_LEFT != 0&&!checkWin())
			    messageArea.append("Invalid move.\n");
		    }
		});
	}
	
	//add buttonPanel to South component in BorderLayout of JFrame
	frame.getContentPane().add(BorderLayout.SOUTH,buttonPanel);
	
	//Container for text and instructions button
        textContainer = new Container();
	textContainer.setLayout(new BoxLayout(textContainer, BoxLayout.Y_AXIS));
	
	//add Components to textContainer
	//textContainer.add(messageScroller);
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
    public int[][] PopulateGrid(int dimension, int numColors, int difficultyLevel)
    {
	if(difficultyLevel == 1)
	    return PopulateGridEasy(dimension,numColors);
	if(difficultyLevel == 2)
	    return PopulateGridMedium(dimension,numColors);
	if(difficultyLevel == 3)
	    return PopulateGridHard(dimension,numColors);
	return PopulateGridMedium(dimension,numColors);
    }
    public int[][] PopulateGridEasy(int dimension, int numColors)
    {
	int previousColor = (int)(Math.random()*numColors);
	int[][] result = new int[dimension][dimension];
	for(int i=0; i<dimension; i++)
	    {
		for(int j=0; j<dimension; j++)
		    {
			if(Math.random()<.5)
			{
			    previousColor = (int)(Math.random()*numColors);
			}
			else if(Math.random()<.5)
			{
			    if(i>1)
				previousColor = result[i-1][j];
			}
			result[i][j] = previousColor;
		    }
	    }
	return result;


    }
    public int[][] PopulateGridMedium(int dimension, int numColors)
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
    public int[][] PopulateGridHard(int dimension, int numColors)
    {
	int currentColor = (int)(Math.random()*numColors);
	int [][] result = new int[dimension][dimension];
	for(int i=0; i<dimension; i++)
	    {
		for(int j=0; j<dimension; j++)
		    {
			if(i==0&&j==0) result[i][j] = (int)(Math.random()*numColors);
			if(i!=0 && j!=0)
			    {
				while(currentColor == result[i-1][j] || currentColor == result[i][j-1])
				    currentColor = (int) (Math.random()*numColors);
				result[i][j] = currentColor;
			    }
			else if(i!=0)
			    {
				while(currentColor == result[i-1][j])
				    currentColor = (int) (Math.random()*numColors);
				result[i][j] = currentColor;
			    }
			else if(j!=0)
			    {
				while(currentColor == result[i][j-1])
				      currentColor = (int)(Math.random()*numColors);
				result[i][j] = currentColor;
			    }
			    
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
	int numColors = 8;
	int difficultyLevel = 3;

	FloodItGUI game = new FloodItGUI(dimension, numColors, difficultyLevel);
	game.run();
	
	
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
    }
 
      	
    

    public void floodIt(int x, int y, int newColor, int oldColor)
    {
	//Adapted from Wikipedia's algorithm: en.wikipedia.org/wiki/Flood_fill
	if(x<0 || y<0 || x>=grid.length || y>= grid.length) return;
	if(grid[x][y] != oldColor) return;
	grid[x][y] = newColor;
	floodIt(x, y+1, newColor, oldColor);
	floodIt(x, y-1, newColor, oldColor);
	floodIt(x+1, y, newColor, oldColor);
	floodIt(x-1, y, newColor, oldColor);
	return;
    }
    public boolean checkWin()
    {
	for(int i=0; i<grid.length; i++)
	    for(int j=0; j<grid.length; j++)
		if(grid[i][j]!=grid[0][0]) return false;
	return true;
		
    }
}
