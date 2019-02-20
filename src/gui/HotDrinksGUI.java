package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import gui.OrderGUI;
import domain.Basket;
import domain.Item;
import domain.ItemCategory;
import domain.MenuList;



public class HotDrinksGUI extends JFrame implements ActionListener  {
	private  Basket basket;
	private  TreeSet<Item> menuList;
	private MenuList menu;
  	private JFrame f;
  	private JPanel up, down, left, right, center;
	private JButton b1, b2, b3, b4, b5;
   	private JLabel lab_up;
   	private JTextArea text_left, text_right;
   	private JComboBox num;
	private String[] ids;

	public HotDrinksGUI(MenuList menuList, Basket basket) {
		this.basket = basket;
		this.menuList = menuList.menuList;
		this.menu = menuList;
		gui();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == b1) {
			System.out.println("box #1 is clicked");
		text_left.setText("Super Duper Friends!\n\n Buy 5 drinks \nand get the 6* for free \n\n\n\n*the one that costs least");//(d1.GetDescription());
		} else if(event.getSource() == b2) {
			System.out.println("box #2 is clicked");
			text_left.setText("Big Family!\n\n15% discount for \n3 meals plus 3 cold drinks \nand 3 desserts");//(d2.GetDescription());
		} else if(event.getSource() == b3) {
			System.out.println("box #3 is clicked");
			text_left.setText("Lucky me!\n\n10% discount for \none meal plus one drink \nand one dessert");//(d3.GetDescription());
		} else if(event.getSource() == b4) {
			System.out.println("box #4 is clicked");
			text_left.setText("Sweet Break!\n\n5% discount for \none drink plus one dessert");//(d4.GetDescription());
		} else if (event.getActionCommand().equals("Go Back")) {
	        OrderGUI orderGui = new OrderGUI();
	        f.dispose();
		}	
		
	}
	
	private void gui() {
   		f = new JFrame("Hot Drinks");
   		f.setVisible(true);
   		f.setSize(800, 500);
   		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   		
   		//create buttons for displaying offers and the "Back" button.
   		b1 = new JButton("Super duper friends"); 
   	    b2 = new JButton("Big Family"); 
   	    b3 = new JButton("Lucky me"); 
 	    b4 = new JButton("A sweet break"); 
 	    b5 = new JButton("Go Back");
 	    
 	    b1.addActionListener(this);
 	    b2.addActionListener(this);
 	    b3.addActionListener(this);
 	    b4.addActionListener(this);
 	    b5.addActionListener(this);

	
 	    //panel up
 	    up = new JPanel();
  		up.setBackground(Color.CYAN);
  		lab_up = new JLabel("Be hungry no more!");
  		up.add(lab_up);
  		
  	  //panel right

  		right = new JPanel();
  		right.setBackground(Color.ORANGE);
  		text_right = new JTextArea(25,15);
  		
  		//panel center
  		center = new JPanel();
  		
  		
   		int index = 0;
  		ids = new String[11];
  		String[] a = new String[11];
  	
  		String temp = "Menu List\n\n";
		
  		for (Item i : menu.getListOfItems()) {
  			
   			 if (i.getCategory() == ItemCategory.HotDrink) {
   				temp += i.getCost()  + "    --    " +i.getName() + "    --    " + i.getDescription() + "\n" ;
   			 	ids[index] = i.getId();
   			 	a[index] = i.getCost()  + "    --    " +i.getName() + "    --    " + i.getDescription() + "\n";
   			 	index++;
   			 } else {
   			 }
   			
  		}
  		
  		String[] order = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		JComboBox<Object> num = new JComboBox<Object>(order);
  		
  		// 1 RadioButton
  		
	    JRadioButton b_1 = new JRadioButton(a[0]);
	    b_1.addActionListener(e -> {
	    	final String tempId = ids[0];
			num.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
	               String s = (String) num.getSelectedItem();    //.getSelectedItem();//get the selected item
            	   System.out.print("BUTTON PRESSED");
            	   if(num.getSelectedIndex()>= 0) 
            	   {
                	   OnSelected(tempId, num.getSelectedIndex());
            	   }

				}
			});
	    	
	    	
	    	
	    	System.out.println(ids[0]);
        });
	    
	    //2 Radio button
	    
	    JRadioButton b_2 = new JRadioButton(a[1]);
	    b_2.addActionListener(e -> {
	    	final String tempId = ids[1];
			
			num.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
	               String s = (String) num.getSelectedItem();    //.getSelectedItem();//get the selected item
	               for (int i = 0; i < order.length; i++) {
	               switch (s) {//check for a match
	                   case "0":
	                   	   basket.RemoveFromBasketById(tempId);
	                       break;
	                       
	                   case "1":
	                       basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,1);
	                       break;
	                   
	                   case "2":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,2);
	                       break;
	                       
	                   case "3":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,3);
	                       break;
	                   
	                   case "4":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,4);
	                       break;
	                       
	                   case "5":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,5);
	                       break;
	                   
	                   case "6":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,6);
	                       break;
	                       
	                   case "7":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,7);
	                       break;
	                   
	                   case "8":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,8);
	                       break;
	                       
	                   case "9":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,9);
	                       break;
	                       
	                   case "10":
	                	   basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,10);
	                       break;
	               }
	                   
	               } 
				}
			});
			
			
	    	System.out.println(ids[1]);
        });
	    
	    //3 Radio Button
	    
	    JRadioButton b_3 = new JRadioButton(a[2]);
	    b_3.addActionListener(e -> {
	    	final String tempId = ids[2];
			
			num.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
			    String s = (String) num.getSelectedItem();    //.getSelectedItem();//get the selected item
	               for (int i = 0; i < order.length; i++) {
	               switch (s) {//check for a match
	                   case "0":
	                   	   basket.RemoveFromBasketById(tempId);
	                       break;
	                       
	                   case "1":
	                       basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,1);
	                       break;
	                   
	                   case "2":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,2);
	                       break;
	                       
	                   case "3":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,3);
	                       break;
	                   
	                   case "4":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,4);
	                       break;
	                       
	                   case "5":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,5);
	                       break;
	                   
	                   case "6":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,6);
	                       break;
	                       
	                   case "7":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,7);
	                       break;
	                   
	                   case "8":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,8);
	                       break;
	                       
	                   case "9":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,9);
	                       break;
	                       
	                   case "10":
	                	   basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,10);
	                       break;
	               }
	                   
	               } 
				}
			});
	   
        });
	    
	    // 4 Radio Button
	    
	    JRadioButton b_4 = new JRadioButton(a[3]);
	    b_4.addActionListener(e -> {
	    	final String tempId = ids[3];

			num.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
			    String s = (String) num.getSelectedItem();    //.getSelectedItem();//get the selected item
	               for (int i = 0; i < order.length; i++) {
	               switch (s) {//check for a match
	                   case "0":
	                   	   basket.RemoveFromBasketById(tempId);
	                       break;
	                       
	                   case "1":
	                       basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,1);
	                       break;
	                   
	                   case "2":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,2);
	                       break;
	                       
	                   case "3":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,3);
	                       break;
	                   
	                   case "4":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,4);
	                       break;
	                       
	                   case "5":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,5);
	                       break;
	                   
	                   case "6":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,6);
	                       break;
	                       
	                   case "7":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,7);
	                       break;
	                   
	                   case "8":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,8);
	                       break;
	                       
	                   case "9":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,9);
	                       break;
	                       
	                   case "10":
	                	   basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,10);
	                       break;
	               }
	                   
	               } 
				}
			});
	   
        });    
	    
	    // 5 Radio Button
	    
	    JRadioButton b_5 = new JRadioButton(a[4]);
	    b_5.addActionListener(e -> {
	    	final String tempId = ids[4];
			
			num.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
			    String s = (String) num.getSelectedItem();    //.getSelectedItem();//get the selected item
	               for (int i = 0; i < order.length; i++) {
	               switch (s) {//check for a match
	                   case "0":
	                   	   basket.RemoveFromBasketById(tempId);
	                       break;
	                       
	                   case "1":
	                       basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,1);
	                       break;
	                   
	                   case "2":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,2);
	                       break;
	                       
	                   case "3":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,3);
	                       break;
	                   
	                   case "4":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,4);
	                       break;
	                       
	                   case "5":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,5);
	                       break;
	                   
	                   case "6":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,6);
	                       break;
	                       
	                   case "7":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,7);
	                       break;
	                   
	                   case "8":
	                   		basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,8);
	                       break;
	                       
	                   case "9":
	                   		basket.RemoveFromBasketById(tempId);
	                   		basket.AddToBasket(tempId,9);
	                       break;
	                       
	                   case "10":
	                	   basket.RemoveFromBasketById(tempId);
	                       basket.AddToBasket(tempId,10);
	                       break;
	               }
	               //central part for right
	         		 
	               } 
				} 
			});
			
        });
	   
  		
  		//end part right
  		right.add(text_right);
  		
	    
	    num.addActionListener(this);
	    ButtonGroup group = new ButtonGroup();
  		group.add(b_1);
  		group.add(b_2);
  		group.add(b_3);
  		group.add(b_4);
  		group.add(b_5);
		
	    
  		//System.out.println(menuList);
  		GridLayout grid = new GridLayout(6,1);
  		center.setLayout(grid);
  		center.add(b_1);
  		center.add(b_2);
  		center.add(b_3);
  		center.add(b_4);
  		center.add(b_5);
  		center.add(num);
  		  	
  		
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
 		f.add(center, BorderLayout.CENTER);//BorderLayout.CENTER);
 		f.add(left, BorderLayout.WEST);
 		
 		//scalable
 		f.pack();
		this.setVisible(true);
	}
	
	private void OnSelected(String id, int amount) 
	{
		if(amount == 0) 
		{
			System.out.println("REMOVE ALL ITEMS");
			basket.RemoveAllItemsOfId(id);

        }
		else 
        {
	        for(int j = 0; j < amount; j++) 
	        {
	    		basket.AddToBasket(id,1);
	        }
        }
	text_right.setText(basket.DisplayBasket());
	}
}


/*
public static void main (String[] arg) {
	new HotDrinksGUI(menuList, basket);
	new basket
}


*/
