import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FloodItGUI extends JFrame implements ActionListener{
	
			public void init(){
			JFrame frame = new JFrame("Flood It!");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1000,800);
			
			JButton buttonRed = new JButton("Red");
			JButton buttonBlue = new JButton("Blue");
			JButton buttonGreen = new JButton("Green");
			JButton buttonYellow = new JButton("Yellow");
	        JButton buttonInstruction = new JButton("Instruction");
			
	        JTextArea message = new JTextArea(50,20);
	        
			JPanel buttonPanel = new JPanel();
			
	        buttonPanel.add(buttonRed);
	        buttonPanel.add(buttonBlue);
	        buttonPanel.add(buttonGreen);
	        buttonPanel.add(buttonYellow);
	        
	        frame.getContentPane().add(BorderLayout.SOUTH,buttonPanel);
	                
	        Container textContainer = new Container();
	        textContainer.setLayout(new BoxLayout(textContainer, BoxLayout.Y_AXIS));
	        textContainer.add(message);
	        textContainer.add(buttonInstruction);
	        
	        frame.getContentPane().add(BorderLayout.EAST,textContainer);
	        
			frame.setVisible(true);
		}
		
		public void run(){
			init();
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
