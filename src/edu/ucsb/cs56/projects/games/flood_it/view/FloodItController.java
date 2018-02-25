package edu.ucsb.cs56.projects.games.flood_it.view;

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
        //set MovesLeft (scales number of moves based on number of colors and dimension
        //selected using 25 moves for a 6 color, 14x14 grid as a baseline.
        movesLeft = (int) Math.floor(dimension * numColors * 25 / 84);
        if (difficultyLevel == 1) movesLeft = (int) Math.floor(movesLeft * .8);
        if (difficultyLevel == 3) movesLeft = (int) Math.floor(movesLeft * 2.33);
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
     * populateGridEasy populates a medium grid of a given size
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
     * populateGridEasy populates a hard grid of a given size
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
     * floodIt redraws the matrix after the player makes a move
     * it is adapted from Wikipedia's algorithm: en.wikipedia.org/wiki/Flood_fill
     *
     * @param x        the x location in the matrix
     * @param y        the y location in the matrix
     * @param newColor the new color being painted
     * @param oldColor the color to be repainted
     */
    public void floodIt(int x, int y, int newColor, int oldColor) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid.length) return;
        if (grid[x][y] != oldColor) return;
        grid[x][y] = newColor;
        floodIt(x, y + 1, newColor, oldColor);
        floodIt(x, y - 1, newColor, oldColor);
        floodIt(x + 1, y, newColor, oldColor);
        floodIt(x - 1, y, newColor, oldColor);
        return;
    }

    /**
     * checkWin checks if the player has won the game
     *
     * @return true if win, false if not.
     */
    public boolean checkWin() {
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
}
