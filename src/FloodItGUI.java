import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * Class for the Flood it game JFrame
 * includes the main method
 * 
 * @author Sophia Mao
 * @author Kai Jann
 */

public class FloodItGUI extends JFrame implements ActionListener{
    
    //private variables for all the GUI components
    private JFrame frame;
    private FloodItInstructGui instructions;
    private JTextArea messageArea;
    private JButton buttonRed;
    private JButton buttonBlue;
    private JButton buttonGreen;
    private JButton buttonYellow;
    private JButton buttonInstruction;
    private JPanel buttonPanel;
    private JTextField countdown;
    private JLabel movesLeft;
    
    //static variables
    static Integer MOVES_LEFT = new Integer(25);
	
    public void init(){
	frame = new JFrame("Flood It!");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1000,800);
	
	
	buttonInstruction = new JButton("Instructions");
	
 	messageArea = new JTextArea(50,20);
	messageArea.setEditable(false);

	countdown = new JTextField(MOVES_LEFT.toString(),2);
	countdown.setEditable(false);

	movesLeft = new JLabel("moves left:");
	
	buttonPanel = new JPanel();
	
	buttonPanel.add(movesLeft);
	buttonPanel.add(countdown);
	
	buttonRed = new JButton("Red");
	buttonRed.setBackground(Color.RED);
	buttonPanel.add(buttonRed);
	buttonRed.addActionListener(new ActionListener(){
		public void actionPerformed( ActionEvent e ){
		    messageArea.append("red \n");
		    countdown.setText(decrementAMove().toString());

		}
	    });
	
	buttonBlue = new JButton("Blue");
	buttonBlue.setBackground(Color.BLUE);
	buttonBlue.setForeground(Color.WHITE);
	buttonPanel.add(buttonBlue);
	buttonBlue.addActionListener(new ActionListener(){
		public void actionPerformed( ActionEvent e ){
		    messageArea.append("blue \n");
		    countdown.setText(decrementAMove().toString());

		}
	    });
	
	buttonGreen = new JButton("Green");
        buttonGreen.setBackground(Color.GREEN);
	buttonPanel.add(buttonGreen);
	buttonGreen.addActionListener(new ActionListener(){
		public void actionPerformed( ActionEvent e ){
		    messageArea.append("green \n");
		    countdown.setText(decrementAMove().toString());

		}
	    });
	
	
	JButton buttonYellow = new JButton("Yellow");
        buttonYellow.setBackground(Color.YELLOW);
       	buttonPanel.add(buttonYellow);
	buttonYellow.addActionListener(new ActionListener(){
		public void actionPerformed( ActionEvent e ){
		    messageArea.append("yellow \n");
		    countdown.setText(decrementAMove().toString());

		}
	    });
	
	
	
	
	
	frame.getContentPane().add(BorderLayout.SOUTH,buttonPanel);
	
	Container textContainer = new Container();
	textContainer.setLayout(new BoxLayout(textContainer, BoxLayout.Y_AXIS));
	
	
	textContainer.add(messageArea);
	textContainer.add(buttonInstruction);
	buttonInstruction.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    instructions = new FloodItInstructGui();
		    messageArea.append("you have clicked the instructions\n");
		}
	    });
	
	

	frame.getContentPane().add(BorderLayout.EAST,textContainer);
	
	frame.setVisible(true);
    }
    



    public void run(){
	init();
    }





    public Integer decrementAMove(){
	if(MOVES_LEFT <= 0){
	    messageArea.append("Out of moves!\n");
	    return 0;
	}
	else{
	    Integer numMoves = new Integer(--MOVES_LEFT);
	    return numMoves;
	}
    }
    



    
    public static void main(String args[]){

	FloodItGUI game = new FloodItGUI();
	game.run();
	
	
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
    }
}
