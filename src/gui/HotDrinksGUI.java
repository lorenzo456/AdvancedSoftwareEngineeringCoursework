package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import gui.OrderGUI;
import domain.Basket;
import domain.Item;
import domain.ItemCategory;
import domain.MenuList;



public class HotDrinksGUI extends JFrame implements ActionListener  {
	private Basket basket;
	private static TreeSet<Item> menuList;
  	private JFrame f;
  	private JPanel up, down, left, right, center;
	private JButton b1, b2, b3, b4, b5, b6;
   	private JLabel lab_up, lab_right, lab_down;
   	private JCheckBox box1, box2,box3,box4;
   	private JTextArea text_up, text_left, text_right;
   	private JComboBox numitems;
	private String[] ids;

	public HotDrinksGUI(TreeSet<Item> menuList) {
		gui();
		this.menuList = menuList;
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
  		basket = new Basket();
  		text_right.setText(basket.DisplayBasket());  		
  		right.add(text_right);
  		
  		//panel center
  		center = new JPanel();
  		center.setBackground(Color.WHITE);
  		text_up = new JTextArea(25,35);
  		text_up.setEditable(false);
   		
  		// Checkbox needed

  
  		
  		 
   	 /*
  		  * 
  		  * dropdown to add before i.GetName()
 	 		*/
  		
  		MenuList m= new MenuList();
   		int index = 0;
  		ids = new String[11];
  		String[] a = new String[11];
  	
  		String temp = "Menu List\n\n";
		
  		for (Item i : m.getListOfItems()) {
  			
   			 if (i.getCategory() == ItemCategory.HotDrink) {
   				temp += i.getCost()  + "    --    " +i.getName() + "    --    " + i.getDescription() + "\n" ;
   			 	ids[index] = i.getId();
   			 	a[index] = i.getCost()  + "    --    " +i.getName() + "    --    " + i.getDescription() + "\n";
   			 	index++;
   			 } else {
   			 }
   			
  		}
 
  	  		//checkbox
	    JCheckBox b_1 = new JCheckBox(a[0]);
	    JCheckBox b_2 = new JCheckBox(a[1]);
	    JCheckBox b_3 = new JCheckBox(a[2]);
	    JCheckBox b_4 = new JCheckBox(a[3]);
	    JCheckBox b_5 = new JCheckBox(a[4]);
	    	    
  		/* 
  		 
  		 //checkbox action
	    String tempId = ids[0];
 		if (b_1.isSelected()) {
 			tempId = ids[0] ;
 		}
 		else if (b_2.isSelected()) {
 			tempId = ids[1];
 		}
 		else if (b_3.isSelected()) {
 			tempId = ids[2];
 		}
 		else if (b_4.isSelected()) {
 			tempId = ids[3];
 		}
 		else if (b_5.isSelected()) {
 			tempId = ids[4];
 		}
	    */
	   
  		String[] order = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		JComboBox<Object> num = new JComboBox<Object>(order);
		
		num.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {

               String s = (String) num.getSelectedItem();    //.getSelectedItem();//get the selected item
               
               for (int i = 0; i < order.length; i++) {
               switch (s) {//check for a match
                   case "0":
                   	   //basket.RemoveFromBasketById(tempId);
                       break;
                       
                   case "1":
                      // basket.RemoveFromBasketById(tempId);
                   		//basket.AddToBasket(tempId,1);
                       break;
                   
                   case "2":
                   	//	basket.RemoveFromBasketById(tempId);
                      // basket.AddToBasket(tempId,2);
                       break;
                       
                   case "3":
                   	//	basket.RemoveFromBasketById(tempId);
                   		//basket.AddToBasket(tempId,3);
                       break;
                   
                   case "4":
                   	//	basket.RemoveFromBasketById(tempId);
                      // basket.AddToBasket(tempId,4);
                       break;
                       
                   case "5":
                   	//	basket.RemoveFromBasketById(tempId);
                   		//basket.AddToBasket(tempId,5);
                       break;
                   
                   case "6":
                   		//basket.RemoveFromBasketById(tempId);
                      // basket.AddToBasket(tempId,6);
                       break;
                       
                   case "7":
                   	//	basket.RemoveFromBasketById(tempId);
                   	//	basket.AddToBasket(tempId,7);
                       break;
                   
                   case "8":
                   	//	basket.RemoveFromBasketById(tempId);
                    //   basket.AddToBasket(tempId,8);
                       break;
                       
                   case "9":
                   //		basket.RemoveFromBasketById(tempId);
                   //		basket.AddToBasket(tempId,9);
                       break;
                       
                   case "10":
                	//   basket.RemoveFromBasketById(tempId);
                    //   basket.AddToBasket(tempId,10);
                       break;
               }
                   
               } 
			}
		});   
	    
	    
  		//System.out.println(menuList);
  		
  		text_up.setText(temp);
  		//center.add(text_up);
  		GridLayout grid = new GridLayout(6,1);
  		center.setLayout(grid);
  		center.add(b_1);
  		center.add(b_2);
  		center.add(b_3);
  		center.add(b_4);
  		center.add(b_5);
  		center.add(num);
  		//center.add(b_6);
  
  	
  		
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


public static void main (String[] arg) {
	new HotDrinksGUI(menuList);
}
}


