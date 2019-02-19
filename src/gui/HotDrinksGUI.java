package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import domain.Basket;
import domain.MenuList;

public class HotDrinksGUI extends JFrame implements ActionListener  {
	private Basket basket;
	private MenuList menuList;
  	private JFrame f;
  	private JPanel up, down, left, right, center;
	private JButton b1, b2, b3, b4, b5;
   	private JLabel lab_up, lab_right, lab_down;
   	private JCheckBox box1, box2,box3,box4;
   	private JTextArea text_up, text_left;
   	private JComboBox numitems;

	public HotDrinksGUI() {
		gui();
	}

	public HotDrinksGUI(Basket basket, MenuList menuList) {
		this.basket = basket;
		this.menuList = menuList;
		gui();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == b1) {
			System.out.println("box #1 is clicked");
		text_left.setText("Super Duper Friends!\nWith five drinks, the sixth* is for free \n\n\n\n*the one that costs less");//(d1.GetDescription());
		} else if(event.getSource() == b2) {
			System.out.println("box #2 is clicked");
			text_left.setText("Big Family!\n15% discount for \n3 meals plus 3 cold drinks and 3 desserts");//(d2.GetDescription());
		} else if(event.getSource() == b3) {
			System.out.println("box #3 is clicked");
			text_left.setText("Lucky me!\n10% discount for \none meal plus one drink and one dessert");//(d3.GetDescription());
		} else if(event.getSource() == b4) {
			System.out.println("box #4 is clicked");
			text_left.setText("Sweet Break!\n5% discount for \none drink plus one dessert");//(d4.GetDescription());
		} else if (event.getActionCommand().equals("Go Back")) {
	        JFrame orderGui = new OrderGUI(this.basket, this.menuList);
		}	
		
	}
	
	private void gui() {
   		f = new JFrame("Hot Drinks");
   		f.setVisible(true);
   		f.setSize(800, 500);
   		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame.DISPOSE_ON_CLOSE);
   		
   		
   		
   		//create buttons for displaying offers and the "Back" button.
   		b1 = new JButton("Super duper friends"); //d1 = new Discount("Super duper friends", "With five drinks, the sixth* is for free\n\n\n\n*the one that costs less", null);
   	    b2 = new JButton("Big Family"); //d2 = new Discount("Big Family", "15% discount for 3 meals plus 3 cold drinks and 3 desserts", null);
   	    b3 = new JButton("Lucky me"); //d3 = new Discount("Lucky me", "10% discount for one meal plus one drink and one dessert", null);
 	    b4 = new JButton("A sweet break"); //d4 = new Discount("A sweet break", "5% discount for one drink plus one dessert", null);
 	    b5 = new JButton("Go Back");
 	    
 	    b1.addActionListener(this);
 	    b2.addActionListener(this);
 	    b3.addActionListener(this);
 	    b4.addActionListener(this);
 	    b5.addActionListener(this);

	
 	    //panel up
 	    up = new JPanel();
  		up.setBackground(Color.CYAN);
  		lab_up = new JLabel("Be hungry no more");
  		up.add(lab_up);
  		
  		//panel right
  		right = new JPanel();
  		right.setBackground(Color.ORANGE);
  		lab_right = new JLabel("Basket");
  		right.add(lab_right);
  		
  		//panel center
  		center = new JPanel();
  		center.setBackground(Color.WHITE);
  		text_up = new JTextArea(25,15);
  		text_up.setEditable(false);
  		//create list food
   		MenuList food = new MenuList();
//  		text_up.setText(food.getHotDrinks());
  		center.add(text_up);
  		
  		//panel left
  		left = new JPanel();
  		left.setBackground(Color.GRAY);
  		text_left = new JTextArea(25,15);
  		text_left.setEditable(false);
  		text_left.setText("Offers!");
  		left.add(text_left);

 	    
 	    //create South Panel for buttons and fill it
 	    down = new JPanel();
 	    down.setBackground(Color.GREEN);
 	    down.add(b1);
 	    down.add(b2);
 	    down.add(b3);
 	    down.add(b4);
 	    down.add(b5, BorderLayout.EAST);
 	    
 	    
 	    
 	    //add panel to JFrame
 	    
 	    f.add(down, BorderLayout.SOUTH);
 	    f.add(up, BorderLayout.NORTH);
 		f.add(right, BorderLayout.EAST);
 		f.add(center, BorderLayout.CENTER);
 		f.add(left, BorderLayout.WEST);
 		
 		//scalable
 		f.pack();
		this.setVisible(true);
	}


public static void main (String[] arg) {
	new HotDrinksGUI();
}
}


