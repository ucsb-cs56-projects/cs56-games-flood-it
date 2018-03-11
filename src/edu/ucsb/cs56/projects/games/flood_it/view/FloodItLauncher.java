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
        waitForMenu(start);
        FloodItController controller = new FloodItController(start.getDimensions(), start.getNumColors(), start.getDifficulty());
        FloodItGUI game = new FloodItGUI(controller);
        game.init();

        while(true) {
            if (game.isNewGame()) {
                start.setGameStarted(false);
                start.show();
                waitForMenu(start);
                controller = new FloodItController(start.getDimensions(), start.getNumColors(), start.getDifficulty());
                game = new FloodItGUI(controller);
                game.init();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void waitForMenu(FloodItStartMenuGUI start) {
        while(!start.isGameStarted()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
