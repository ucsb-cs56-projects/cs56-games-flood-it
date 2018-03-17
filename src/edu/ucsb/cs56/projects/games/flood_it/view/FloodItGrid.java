package edu.ucsb.cs56.projects.games.flood_it.view;

import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.util.Random;

/**
 * FloodItGrid represents the game board with a Grid of JPanels.
 * FloodItGrid is itself a JPanel composed
 *
 * @author Dylan Hanson
 * @author Daniel Ben-Naim
 * @author Sophia Mao
 * @author Kai Jann
 * @author Chris Luo
 * @author Kevin Briggs
 */
public class FloodItGrid extends JPanel {

    /**
     * FloodItGrid initializes a grid with a given size and given colors
     *
     * @param grid   A NxN Matrix of integers representing colors in an array
     * @param colors an array of Colors
     */
    public FloodItGrid(int[][] grid, Color[] colors) {
        this.setLayout(new GridLayout(grid.length, grid.length));
        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid.length; k++) {
                JPanel currentPanel = new JPanel();
                currentPanel.setBackground(colors[grid[j][k]]);
                add(currentPanel);

            }
        }
    }

    /**
     * redrawLabel redraws the grid given same params as constructor
     * <p>
     * This is the utility function of the class for redrawing the
     * grid when the user makes a move.
     *
     * @param grid   A NxN Matrix of integers representing colors in an array
     * @param colors an array of Colors
     */
    public void redrawLabel(int[][] grid, Color[] colors) {
        removeAll();

        setLayout(new GridLayout(grid.length, grid.length));
        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid.length; k++) {
                JPanel current = new JPanel();
                current.setBackground(colors[grid[j][k]]);
                add(current);

            }
        }
    }


}
