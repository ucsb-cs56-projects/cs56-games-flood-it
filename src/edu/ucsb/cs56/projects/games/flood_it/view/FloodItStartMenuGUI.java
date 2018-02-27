package edu.ucsb.cs56.projects.games.flood_it.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Class for Flood it game StartMenuGUI
 *
 * @author Gustav Schoelin
 */

public class FloodItStartMenuGUI {

    private JFrame frame;
    private JComboBox<String> dimensionsChooser;
    private JComboBox<Integer> numColorsChooser;
    private JComboBox<String> difficultyChooser;
    private boolean gameStarted = false;
    private int dimensions;
    private int numColors;
    private int difficulty;

    public FloodItStartMenuGUI() {
        frame = new JFrame("Welcome to FloodIt!");
        frame.setSize(600, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/3-frame.getSize().height/2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel textPanel = new JPanel();
        textPanel.add(new JLabel("<html><br>Welcome to FloodIt!<br>Choose size, number of colors and difficulty<br><br></html>"));
        frame.getContentPane().add(BorderLayout.NORTH, textPanel);

        dimensionsChooser = new JComboBox<String>();
        for (int i = 4; i <= 16; i++) {
            dimensionsChooser.addItem(i + "x" + i);
        }

        numColorsChooser = new JComboBox<Integer>();
        for (int i = 3; i <= 8; i++) {
            numColorsChooser.addItem(i);
        }

        String[] difficulties = {"Easy", "Medium", "Hard"};
        difficultyChooser = new JComboBox<String>(difficulties);

        JPanel chooserPanel = new JPanel();
        chooserPanel.add(new JLabel("Size:"));
        chooserPanel.add(dimensionsChooser);
        chooserPanel.add(new JLabel("Number of colors:"));
        chooserPanel.add(numColorsChooser);
        chooserPanel.add(new JLabel("Difficulty:"));
        chooserPanel.add(difficultyChooser);
        frame.getContentPane().add(BorderLayout.CENTER, chooserPanel);

        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new startButtonListener());
        JButton exitButton = new JButton(("Exit"));
        exitButton.addActionListener(new exitButtonListener());

        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);

        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

        frame.setVisible(true);
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public int getDimensions() {
        return dimensions;
    }

    public int getNumColors() {
        return numColors;
    }

    public int getDifficulty() {
        return difficulty;
    }

    class startButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dimensions = dimensionsChooser.getSelectedIndex() + 4;
            numColors = numColorsChooser.getSelectedIndex() + 3;
            difficulty = difficultyChooser.getSelectedIndex() + 1;

            gameStarted = true;
            frame.setVisible(false);
            frame.dispose();
        }
    }

    class exitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
