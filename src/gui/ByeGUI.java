package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import domain.Basket;
import domain.MenuList;

public class ByeGUI {
	private JFrame f;
  	private JPanel p;
   	private JTextArea t;
   	
   	private JFrame g;


	public ByeGUI() {
		gui();
	}

	private void gui() {
		f = new JFrame("Thanks");
   		f.setVisible(true);
   		f.setSize(80, 50);
   		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		
   		t = new JTextArea();
   		t.setEditable(false);
   		t.setText("\n\n\n    Thank you for your purchase    \n\n\n    Your order is being processed    \n\n\n");
   		p = new JPanel();
   		p.setBackground(Color.WHITE);
   		p.add(t);
   		f.add(p);
   		f.pack();
   		
   		// add button to come back shopping! (new order, same customerID?).
   		
   		/*
   		 * 
   		 * g = new JFrame("New Order");
   		g.setVisible(true);
   		g.setSize(40, 50);
   		 */
   		

		
	}

}
