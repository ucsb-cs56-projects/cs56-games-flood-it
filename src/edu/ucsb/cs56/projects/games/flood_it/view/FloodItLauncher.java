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
        FloodItStartMenuGUI start = new FloodItStartMenuGUI();
        while(!start.isGameStarted()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        FloodItController controller = new FloodItController(start.getDimensions(), start.getNumColors(), start.getDifficulty());
        FloodItGUI game = new FloodItGUI(controller);
        game.init();
    }

}
