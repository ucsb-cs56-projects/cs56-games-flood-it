package edu.ucsb.cs56.projects.games.flood_it.model;



import java.awt.Color;
import java.lang.Math;
import java.util.*;

/**
 * Class for the grid
 * 
 *
 * @author Chris Luo
 * @author Kevin Briggs
 */

public class FloodItGrid {
     private int rows; //number of total rows in the grid
     private int cols; //numbber of total columns in the grid
     private int numColors = 6;
     private FloodItCell[][] board; //the board is a 2-d array of FloodItCell's 
     private FloodItCell[] currentSquares; //this keeps track of the player's current 							set of squares

     private int nextIndex; //the next free index in the currentSquares array


    public static final Color purple = new Color(99, 95, 170);
    public static final Color blue = new Color(70, 177, 226);
    public static final Color green = new Color(126, 157, 30);
    public static final Color yellow = new Color(243, 246, 29);
    public static final Color red = new Color(220, 74, 32);
    public static final Color pink = new Color(237, 112, 161);
	

   public static final Color error = new Color(0,0,0);




	//constructor for the grid

     public FloodItGrid(int r, int c) {
        // set rows and cols here
	 rows = r;
	 cols = c;

	currentSquares = new FloodItCell[rows*cols]; //set of player's squares
	
	board = new FloodItCell[rows][cols]; //new board

	//randomly fill the board with colors
	for(int i=0; i<rows; i++){
		for(int j=0; j<cols; j++){
			Color t = randColor(); //make a random color
			board[i][j] = new FloodItCell(i,j,t); // create a new cell

		  }
	}
	 
	
	currentSquares[0] = board[0][0]; //the player starts with the square in the 						top left corner
	nextIndex = 1;
     }


	//randomly choose one of the six colors
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
			default: 
				break;
	
		}
		return error;
	
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



	//this function implements "flood it". It first sets the currently owned squares to the chosen color. then it adds the adjacent squares of that color to the list of controlled colors. to do this it deals with different end cases

    public FloodItCell[] Floodit(Color c){

		//set the colors of currently owned squares to the chosen color
		for(int i=0; i< currentSquares.length; i++){
			
			int k = currentSquares[i].getRow();
			int j = currentSquares[i].getCol();
			board[k][j].setColor(c);

		}



		//find the adjacent colors to add to the currentSquares list
		for(int i=0; i< currentSquares.length; i++){
			
			int n = currentSquares[i].getRow();
			int m = currentSquares[i].getCol();

			//end case for top left
			if(n == 0 && m == 0){

				if (board[n][m+1].getColor() == c){
					currentSquares[nextIndex] = board[n][m+1];
					nextIndex++;
				}
				if (board[n+1][m].getColor() == c){
					currentSquares[nextIndex] = board[n+1][m];
					nextIndex++;
				}
			}
			
			//end case for bottom left
			else if(n == rows && m == 0){

				if (board[n][m-1].getColor() == c){
					currentSquares[nextIndex] = board[n][m-1];
					nextIndex++;
				}
				if (board[n+1][m].getColor() == c){
					currentSquares[nextIndex] = board[n+1][m];
					nextIndex++;
				}
			}


			//end case for bottom right
		     else if(n == rows && m == cols){

				if (board[n][m-1].getColor() == c){
					currentSquares[nextIndex] = board[n][m-1];
					nextIndex++;
				}
				if (board[n-1][m].getColor() == c){
					currentSquares[nextIndex] = board[n-1][m];
					nextIndex++;
				}
			}

			//end case for top right
			else if(n == 0 && m == cols){

				if (board[n][m-1].getColor() == c){
					currentSquares[nextIndex] = board[n][m-1];
					nextIndex++;
				}
				if (board[n-1][m].getColor() == c){
					currentSquares[nextIndex] = board[n-1][m];
					nextIndex++;
				}
			}


			// case for top, non-corner row
			else if(n == 0){

				if (board[n][m+1].getColor() == c){
					currentSquares[nextIndex] = board[n][m+1];
					nextIndex++;
				}
				if (board[n+1][m].getColor() == c){
					currentSquares[nextIndex] = board[n+1][m];
					nextIndex++;
				}
				if (board[n-1][m].getColor() == c){
					currentSquares[nextIndex] = board[n-1][m];
					nextIndex++;
				}
			}
			
			//case for bottom non corner
			else if(n == rows){

				if (board[n][m-1].getColor() == c){
					currentSquares[nextIndex] = board[n][m-1];
					nextIndex++;
				}
				if (board[n+1][m].getColor() == c){
					currentSquares[nextIndex] = board[n+1][m];
					nextIndex++;
				}
				if (board[n-1][m].getColor() == c){
					currentSquares[nextIndex] = board[n-1][m];
					nextIndex++;
				}
			}

			//case for left column non corner
			else if(m == 0){

				if (board[n][m+1].getColor() == c){
					currentSquares[nextIndex] = board[n][m+1];
					nextIndex++;
				}
				if (board[n][m-1].getColor() == c){
					currentSquares[nextIndex] = board[n][m-1];
					nextIndex++;
				}
				if (board[n+1][m].getColor() == c){
					currentSquares[nextIndex] = board[n+1][m];
					nextIndex++;
				}
			}

			//case for right non-corner
			else if(m == cols){

				if (board[n][m+1].getColor() == c){
					currentSquares[nextIndex] = board[n][m+1];
					nextIndex++;
				}
				if (board[n][m-1].getColor() == c){
					currentSquares[nextIndex] = board[n][m-1];
					nextIndex++;
				}
				if (board[n-1][m].getColor() == c){
					currentSquares[nextIndex] = board[n-1][m];
					nextIndex++;
				}
			}
			
			//normal case (middle of grid/ not an end)
			else {
			
				if (board[n][m+1].getColor() == c){
					currentSquares[nextIndex] = board[n][m+1];
					nextIndex++;
				}
				if (board[n][m-1].getColor() == c){
					currentSquares[nextIndex] = board[n][m-1];
					nextIndex++;
				}
				if (board[n-1][m].getColor() == c){
					currentSquares[nextIndex] = board[n-1][m];
					nextIndex++;
				}
				if (board[n+1][m].getColor() == c){
					currentSquares[nextIndex] = board[n+1][m];
					nextIndex++;
				}


			}
			

		}
		//return the currently owned squares to be painted in the GUI
		return currentSquares;

	} 




}
