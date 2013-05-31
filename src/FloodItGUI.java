import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FloodItGUI extends JFrame implements ActionListener{
	
		FloodItGUI(){
		
		
		
		}
	
		public static void main(String args[]){
			
			JFrame frame = new JFrame("Flood It!");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800,800);
			frame.setVisible(true);
			JButton buttonRed = new JButton("Red");
			JButton buttonBlue = new JButton("Blue");
			JButton buttonGreen = new JButton("Green");
			JButton buttonYellow = new JButton("Yellow");

			JPanel panel = new JPanel();
	        panel.add(buttonRed);
	        panel.add(buttonBlue);
	        panel.add(buttonGreen);
	        panel.add(buttonYellow);
	        frame.getContentPane().add(BorderLayout.SOUTH,panel);


			

	}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}
