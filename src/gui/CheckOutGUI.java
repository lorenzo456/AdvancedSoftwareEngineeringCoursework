package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import gui.OrderGUI;
import domain.Basket;
import domain.MenuList;


public class CheckOutGUI  extends JFrame implements ActionListener {
	private JButton b1, b2;
	private JPanel p, p1, p2;
	private JFrame f;
	private String name;
	private MenuList menu;
	private Basket basket;
	private JTextArea text;
	private JLabel label;
	private OrderGUI orderGUI;

	public CheckOutGUI(MenuList menuList, Basket basket, String name, OrderGUI orderGUI) {
		this.basket = basket;
		this.menu = menuList;
		this.name = name; 
		this.orderGUI = orderGUI;
		gui();

	}

	private void gui() {
		f = new JFrame(name);
   		f.setVisible(true);
   		f.setSize(800, 500);
   		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   		
   		
   		
   		b1 = new JButton("Go Back");
   		b1.addActionListener(this);
   		b2 = new JButton("Pay");
   		b2.addActionListener(this);
   		
   		p = new JPanel();
   		p.setBackground(Color.GREEN);
   		p.add(b1);
   		p.add(b2);
   		
   		p1 = new JPanel();
   		p1.setBackground(Color.WHITE);
   		text = new JTextArea();
   		text.setEditable(false);
   		text.setText(basket.DisplayBasket());
   		p1.add(text);
   		
   		label = new JLabel();
   		label.setText("Checkout");
   		p2 = new JPanel();
   		p2.setBackground(Color.CYAN);
   		p2.add(label);
   		
   		f.add(p, BorderLayout.SOUTH);
   		f.add(p1, BorderLayout.CENTER);
   		f.add(p2, BorderLayout.NORTH);
   		
   		f.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == b1) 
		{
			new OrderGUI(menu, basket);
			f.dispose(); 
		}
			else if(event.getSource() == b2) 
		{
			//Customer confirms order
			
			orderGUI.printOrdersToFile();
			new ByeGUI(menu, basket);
			f.dispose();	   		
	   		
		}
				
	}

}
