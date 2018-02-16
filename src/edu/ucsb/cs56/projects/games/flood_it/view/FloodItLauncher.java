package edu.ucsb.cs56.projects.games.flood_it.view;

import java.util.Scanner;

public class FloodItLauncher {


    /**
     * Main method for the game
     */
    public static void main(String args[]) {
        //maybe error prone

        //int dimension = (int) args[0];
        //int numColors = (int) args[1];
        int dimension;
        int numColors = 0;
        int difficultyLevel = 0;
        Scanner S = new Scanner(System.in);
        System.out.println("Welcome to FloodIt!");
        System.out.println("Enter the dimension you want: (between 4 and 16)");
        dimension = S.nextInt();
        while (dimension < 4 || dimension > 16) {
            System.out.println("Invalid input");
            dimension = S.nextInt();
        }
        System.out.println("Enter the number of colors you want: (between 3 and 8)");
        numColors = S.nextInt();
        while (numColors < 3 || numColors > 8) {
            numColors = S.nextInt();
            System.out.println("Invalid input");
        }
        System.out.println("Enter 1 for easy, 2 for medium, 3 for hard.");
        difficultyLevel = S.nextInt();
        while (difficultyLevel < 1 || difficultyLevel > 3) {
            difficultyLevel = S.nextInt();
            System.out.println("Invalid input");
        }
        FloodItGUI game = new FloodItGUI(dimension, numColors, difficultyLevel);
        game.init();
    }

}
