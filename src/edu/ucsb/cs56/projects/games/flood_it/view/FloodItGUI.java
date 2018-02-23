package edu.ucsb.cs56.projects.games.flood_it.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * Class for the Flood it game JFrame
 * includes the main method
 *
 * @author Daniel Ben-Naim
 * @author Dylan Hanson
 * @author Sophia Mao
 * @author Kai Jann
 * @author Chris Luo
 * @author Kevin Briggs
 */
public class FloodItGUI extends JFrame {

    //private variables for all the GUI components

    private FloodItController controller;
    private JFrame frame;
    private Container textContainer;
    private FloodItGrid gridBoard;
    private FloodItInstructGui instructions;
    private JTextArea messageArea;
    private JButton buttonInstruction;
    private JPanel buttonPanel;
    private JTextField countdown;
    private JLabel movesLeft;
    private int[][] grid;
    private final Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,
            Color.MAGENTA, Color.CYAN, Color.ORANGE, Color.BLACK};
    private String[] colorNames = {"Red", "Blue", "Green", "Yellow", "Magenta", "Cyan", "Orange", "Black"};
    private Integer MOVES_LEFT;

    /**
     * FloodItGUI constructor creates an instance of the game
     *
     * @param controller
     */
    public FloodItGUI(FloodItController controller) {
        this.controller = controller;
    }

    /**
     * init initializes the game and draws the board.
     */
    public void init() {
        int dimension = controller.getDimension();
        int numColors = controller.getNumColors();
        int difficultyLevel = controller.getDifficultyLevel();
        //set MovesLeft (scales number of moves based on number of colors and dimension
        //selected using 25 moves for a 6 color, 14x14 grid as a baseline.
        MOVES_LEFT = (int) Math.floor(dimension * numColors * 25 / 84);//Thanks, autoboxing!
        if (difficultyLevel == 1) MOVES_LEFT = (int) Math.floor(MOVES_LEFT * .8);
        if (difficultyLevel == 3) MOVES_LEFT = (int) Math.floor(MOVES_LEFT * 2.33);
        //set JFrame properties
        frame = new JFrame("Flood It! by SM and KJ and KB and CL and DH and DBN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        grid = controller.populateGrid(dimension, numColors, difficultyLevel);
        gridBoard = new FloodItGrid(grid, colors);
        buttonInstruction = new JButton("Instructions");
        //set JTextArea properties for the big message returning box
        messageArea = new JTextArea(40, 20);
        messageArea.setEditable(false);
        JScrollPane messageScroller = new JScrollPane(messageArea);
        messageScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //set JTextField properties for countdown box
        countdown = new JTextField(MOVES_LEFT.toString(), 2);
        countdown.setEditable(false);
        //JLabel for the countdown JTextArea
        movesLeft = new JLabel("moves left:");
        //Panel that holds the color buttons and countdown
        buttonPanel = new JPanel();
        //add Countdown components to buttonPanel
        buttonPanel.add(movesLeft);
        buttonPanel.add(countdown);
        //ALL button properties
        for (int i = 0; i < numColors; i++) {
            final int k = i;
            JButton currentButton = new JButton(colorNames[i]);
            currentButton.setBackground(colors[i]);
            buttonPanel.add(currentButton);
            currentButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (MOVES_LEFT != 0 && !controller.checkWin() && grid[0][0] != k) {
                        countdown.setText(decrementAMove().toString());
                        messageArea.append(colorNames[k] + "\n");
                        controller.floodIt(0, 0, k, grid[0][0]);
                        gridBoard.redrawLabel(grid, colors);
                        if (controller.checkWin())
                            messageArea.append("You Win :D\n");
                        else if (MOVES_LEFT == 0)
                            messageArea.append("You Lose :(\n");
                    } else if (MOVES_LEFT != 0 && !controller.checkWin())
                        messageArea.append("Invalid move.\n");
                }
            });
        }
        //add buttonPanel to South component in BorderLayout of JFrame
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        //Container for text and instructions button
        textContainer = new Container();
        textContainer.setLayout(new BoxLayout(textContainer, BoxLayout.Y_AXIS));
        //add Components to textContainer
        //textContainer.add(messageScroller);
        textContainer.add(messageArea);
        textContainer.add(buttonInstruction);
        buttonInstruction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                instructions = new FloodItInstructGui();
                messageArea.append("you have clicked the instructions\n");
            }
        });
        //add textContainer to JFrame
        frame.getContentPane().add(BorderLayout.EAST, textContainer);
        frame.getContentPane().add(BorderLayout.CENTER, gridBoard);
        frame.setVisible(true);
    }

    /**
     * decrementAMove decrements a move when a user makes a move
     *
     * @return numMoves an integer representing the number of moves
     */
    public Integer decrementAMove() {
        if (MOVES_LEFT <= 0) {
            messageArea.append("Out of moves!\n");
            return 0;
        } else {
            Integer numMoves = new Integer(--MOVES_LEFT);
            return numMoves;
        }
    }


}
