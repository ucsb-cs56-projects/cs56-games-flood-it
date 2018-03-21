package edu.ucsb.cs56.projects.games.flood_it.view;

import java.util.Collections;
import java.util.Arrays;

/**
 * Class for Flood it game Controller
 *
 * @author Gustav Schoelin
 * @author Karl Wang
 */

public class FloodItController {

    private int numColors;
    private int dimension;
    private int difficultyLevel;
    private int movesLeft;
    private int[][] grid;
    private int[][] startGrid;
    private int startMoves;

    /**
     * FloodItController constructor creates an instance of the game
     *
     * @param dimension       the grid will be dimension x dimension
     * @param numColors       the number of colors available
     * @param difficultyLevel how difficult the game is
     */
    public FloodItController(int dimension, int numColors, int difficultyLevel) {
        this.dimension = dimension;
        this.numColors = numColors;
        this.difficultyLevel = difficultyLevel;
        populateGrid(dimension, numColors, difficultyLevel);
        
        if (difficultyLevel == 1)
            this.movesLeft = (int) (calculateBaselineMovesLeft(dimension * dimension, dimension));
        if (difficultyLevel == 2)
            this.movesLeft = (int) (calculateBaselineMovesLeft(dimension * dimension, dimension / 2));
        if (difficultyLevel == 3)
            this.movesLeft = (int) (calculateBaselineMovesLeft(dimension * dimension, 1));

        startGrid = gridCopy(grid);
        startMoves = movesLeft;
    }

    /**
     * populateGrid populates the grid of a given size and difficulty level
     *
     * @param dimension       the grid will be dimension x dimension
     * @param numColors       the number of colors in the grid
     * @param difficultyLevel a number 1,2,3 representing easy medium or hard
     * @return dimensionxdimension matrix of ints represnting the game board
     */
    public void populateGrid(int dimension, int numColors, int difficultyLevel) {
        if (difficultyLevel == 1)
            grid =  populateGridEasy(dimension, numColors);
        if (difficultyLevel == 2)
            grid =  populateGridMedium(dimension, numColors);
        if (difficultyLevel == 3)
            grid =  populateGridHard(dimension, numColors);
    }

    /**
     * populateGridEasy populates an easy grid of a given size
     *
     * @param dimension the grid will be dimension x dimension
     * @param numColors the number of colors in the grid
     * @return dimensionxdimension matrix of ints represnting the game board
     */
    public int[][] populateGridEasy(int dimension, int numColors) {
        int previousColor = (int) (Math.random() * numColors);
        int[][] result = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (Math.random() < .5) {
                    previousColor = (int) (Math.random() * numColors);
                } else if (Math.random() < .5) {
                    if (i > 1)
                        previousColor = result[i - 1][j];
                }
                result[i][j] = previousColor;
            }
        }
        return result;
    }

    /**
     * populateGridMedium populates a medium grid of a given size
     *
     * @param dimension the grid will be dimension x dimension
     * @param numColors the number of colors in the grid
     * @return dimensionxdimension matrix of ints represnting the game board
     */
    public int[][] populateGridMedium(int dimension, int numColors) {
        int[][] result = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                result[i][j] = (int) (Math.random() * numColors);
            }
        }
        return result;
    }


    /**
     * populateGridHard populates a hard grid of a given size
     *
     * @param dimension the grid will be dimension x dimension
     * @param numColors the number of colors in the grid
     * @return dimensionxdimension matrix of ints represnting the game board
     */
    public int[][] populateGridHard(int dimension, int numColors) {
        int currentColor = (int) (Math.random() * numColors);
        int[][] result = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i == 0 && j == 0) result[i][j] = (int) (Math.random() * numColors);
                if (i != 0 && j != 0) {
                    while (currentColor == result[i - 1][j] || currentColor == result[i][j - 1])
                        currentColor = (int) (Math.random() * numColors);
                    result[i][j] = currentColor;
                } else if (i != 0) {
                    while (currentColor == result[i - 1][j])
                        currentColor = (int) (Math.random() * numColors);
                    result[i][j] = currentColor;
                } else if (j != 0) {
                    while (currentColor == result[i][j - 1])
                        currentColor = (int) (Math.random() * numColors);
                    result[i][j] = currentColor;
                }
            }
        }
        return result;
    }

    /**
     * calculates the number of moves given to the player
     * by running random simulations on the grid
     * the average of the top results is provided as the recommended number of moves
     * 
     * @return recommended number of moves, not adjusted for difficulty
     */
    private double calculateBaselineMovesLeft(int iterations, int tops){
        if(tops > iterations){
            throw new IllegalArgumentException("requesting the average of more result than that is generated");
        }
        int[] testResults = new int[iterations]; //the choice of 30 iterations is completely arbitrary. Feel free to change it. 

        for(int i = 0; i < testResults.length; i++){
            int[][] testGrid = gridCopy(this.grid);
            int movesUsed = 0;
            while(!checkWin(testGrid)){
                int newColor;
                do{
                    newColor = (int) (Math.random() * numColors);
                }while(newColor == testGrid[0][0]);
                floodIt(0, 0, newColor, testGrid[0][0], testGrid);
                movesUsed++;
            }
            testResults[i] = movesUsed;
        }

        Arrays.sort(testResults);

        int sum = 0;
        for (int i = 0; i < tops; i++) {
            sum += testResults[i];
        }
        return (double)sum / tops;
    }

    /**
     * floodIt redraws the matrix after the player makes a move
     * it is adapted from Wikipedia's algorithm: en.wikipedia.org/wiki/Flood_fill
     *
     * @param x        the x location in the matrix
     * @param y        the y location in the matrix
     * @param newColor the new color being painted
     * @param oldColor the color to be repainted
     */
    public void floodIt(int x, int y, int newColor, int oldColor) {
        floodIt(x, y, newColor, oldColor, this.grid);
    }

    /**
     * floodIt redraws the matrix after the player makes a move
     * it is adapted from Wikipedia's algorithm: en.wikipedia.org/wiki/Flood_fill
     *
     * @param x        the x location in the matrix
     * @param y        the y location in the matrix
     * @param newColor the new color being painted
     * @param oldColor the color to be repainted
     * @param grid     the grid to be worked on
     */
    private void floodIt(int x, int y, int newColor, int oldColor, int[][] grid) {
        if(newColor == oldColor){
            throw new IllegalArgumentException("newColor and oldColor should not be the same!");
        }
        if (x < 0 || y < 0 || x >= grid.length || y >= grid.length) return;
        if (grid[x][y] != oldColor) return;
        grid[x][y] = newColor;
        floodIt(x, y + 1, newColor, oldColor, grid);
        floodIt(x, y - 1, newColor, oldColor, grid);
        floodIt(x + 1, y, newColor, oldColor, grid);
        floodIt(x - 1, y, newColor, oldColor, grid);
        return;
    }

    /**
     * checkWin checks if the player has won the game
     *
     * @return true if win, false if not.
     */
    public boolean checkWin() {
        return checkWin(this.grid);
    }

    /**
     * checkWin checks if the player has won the game
     *
     * @return true if win, false if not.
     * @param grid     the grid to be worked on
     */
    private boolean checkWin(int[][] grid) {
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++)
                if (grid[i][j] != grid[0][0]) return false;
        return true;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getDimension() {
        return dimension;
    }

    public int getNumColors() {
        return numColors;
    }

    public int[][] getGrid() {
        return grid;
    }

    public Integer getMovesLeft() {
        return movesLeft;
    }

    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }

    /**
     * utility method for copying a grid
     * to be used in calculateMovesLeft()
     *
     * @return         a copy of the provided grid
     * @param grid     the grid to be worked on
     */
    private int[][] gridCopy(int[][] grid){
        int [][] newGrid = new int[grid.length][];
        for(int i = 0; i < grid.length; i++){
            newGrid[i] = grid[i].clone();
        }
        return newGrid;
    }

    public void reset() {
        grid = gridCopy(startGrid);
        movesLeft = startMoves;
    }
}
