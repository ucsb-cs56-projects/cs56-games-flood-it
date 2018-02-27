package edu.ucsb.cs56.projects.games.flood_it.view;

import java.util.Scanner;

public class FloodItLauncher {


    /**
     * Class for the Flood it game Launcher
     * Main method for the game
     *
     * @author Gustav Schoelin
     * @author Karl Wang
     */
    public static void main(String args[]) {
        //maybe error prone
        FloodItStartMenuGUI start = new FloodItStartMenuGUI();
        while(!start.isGameStarted()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //int dimension = (int) args[0];
        //int numColors = (int) args[1];
       /* int dimension;
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
            System.out.println("Invalid input");
            numColors = S.nextInt();
        }
        System.out.println("Enter 1 for easy, 2 for medium, 3 for hard.");
        difficultyLevel = S.nextInt();
        while (difficultyLevel < 1 || difficultyLevel > 3) {
            System.out.println("Invalid input");
            difficultyLevel = S.nextInt();
        }*/
        FloodItController controller = new FloodItController(start.getDimensions(), start.getNumColors(), start.getDifficulty());
        FloodItGUI game = new FloodItGUI(controller);
        game.init();
    }

}
