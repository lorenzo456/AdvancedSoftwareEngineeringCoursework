package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import domain.Basket;
import domain.Customer;
import domain.MenuList;
import domain.ShopManager;

public class ByeGUI {
	private JFrame f;
  	private JPanel p;
   	private JTextArea t;
   	private JButton close;
   	private MenuList menu;
   	private Basket basket;
   	
   	
   	private JFrame g;


	public ByeGUI(MenuList menu, Basket basket) {
		this.menu = menu;
		this.basket = basket;
		gui();
	}

	private void gui() {
		f = new JFrame("Thanks");
   		f.setVisible(true);
   		f.setSize(80, 50);
   		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  		

   		
   		t = new JTextArea(); 
   		t.setEditable(false);
   		t.setText("\n\n\n    Thank you for your purchase    \n\n\n    Your order is being processed    \n\n\n");
   		
   		close = new JButton("Next Customer");
   		close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	//get random costumer name
            	Customer customer = new Customer("randomName", basket.getBasketAsList(), true);
            	//add customer to queue
            	menu.GetShop().AddToQueue(customer);
            	
            	basket.RemoveAllItemsFromBasket();
    			OrderGUI orderGui = new OrderGUI(menu, basket);
             	f.dispose();
            }
        });
   		p = new JPanel();
   		GridLayout grid = new GridLayout(2,1);
   		p.setLayout(grid);
   		p.setBackground(Color.WHITE);
   		p.add(t);
   		p.add(close);
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
