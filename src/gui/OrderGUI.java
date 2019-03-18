package gui;

import domain.*;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Font;

import gui.ItemsGUI;


public class OrderGUI extends JFrame implements ActionListener{

    private JPanel centerPanel, menuPanel;
    private Basket basket;
    private MenuList menuList;
    private Font labelFont = new Font("Serif", Font.BOLD, 30);
    private Border border = BorderFactory.createLineBorder(Color.BLACK);
    private OrderList orderList = new OrderList();
    
    public OrderGUI(MenuList menuList, Basket basket) {
        this.menuList = menuList;
        this.basket = basket;
        initGUI();
    }
     
    public void initGUI() {

        setupNorthPanel();
        setupCenterPanel();

        pack();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1024, 800);
        setVisible(true);
    }

    private void setupNorthPanel() {
        JPanel northPanel = new JPanel();

        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(1024, 120));
        northPanel.setBorder(border);
        northPanel.setBackground(Color.WHITE);

        JLabel label = new JLabel("Coffee Bar Menu");
        label.setFont(labelFont);
        northPanel.add(label, BorderLayout.WEST);

        this.add(northPanel, BorderLayout.NORTH);
    }

    JTextArea basketText;
    
    public JPanel createBasketPanel(){
        JPanel basketPanel = new JPanel();
        basketPanel.setLayout(new BorderLayout());
        basketPanel.setBackground(Color.WHITE);
        basketPanel.setBorder(border);

        JLabel label = new JLabel("Basket");
        label.setFont(labelFont);
        basketPanel.add(label, BorderLayout.NORTH);
  		basketText = new JTextArea(25,15);
  		basketText.setText(basket.DisplayBasket());
        basketPanel.add(basketText);

        JButton checkout = new JButton("Checkout");
        checkout.addActionListener(this);

        checkout.setPreferredSize(new Dimension(40, 120));
        basketPanel.add(checkout, BorderLayout.SOUTH);

        return basketPanel;
    }

    private JPanel createMenuPanel(){
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setBackground(Color.WHITE);

        JButton showHotDrinks = new JButton("Hot Drinks");
        showHotDrinks.addActionListener(this);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.BOTH;
        c1.gridwidth = 1;
        c1.weightx = 1;
        c1.weighty = 1;
        c1.gridx = 0;
        c1.gridy = 0;
        c1.insets = new Insets(70,70,70,70);
        menuPanel.add(showHotDrinks, c1);

        JButton showColdDrinks= new JButton("Cold Drinks");
        showColdDrinks.addActionListener(this);
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.BOTH;
        c2.gridwidth = 1;
        c2.weightx = 1;
        c2.weighty = 1;
        c2.gridx = 1;
        c2.gridy = 0;
        c2.insets = new Insets(70,70,70,70);
        menuPanel.add(showColdDrinks, c2);

        JButton showMeal= new JButton("Meals");
        showMeal.addActionListener(this);
        GridBagConstraints c3 = new GridBagConstraints();
        c3.fill = GridBagConstraints.BOTH;
        c3.gridwidth = 1;
        c3.weightx = 0.5;
        c3.weighty = 1;
        c3.gridx = 0;
        c3.gridy = 1;
        c3.insets = new Insets(70,70,70,70);
        menuPanel.add(showMeal, c3);

        JButton showDessert = new JButton("Desserts");
        showDessert.addActionListener(this);
        GridBagConstraints c4 = new GridBagConstraints();
        c4.fill = GridBagConstraints.BOTH;
        c4.gridwidth = 1;
        c4.weightx = 0.5;
        c4.weighty = 1;
        c4.gridx = 1;
        c4.gridy = 1;
        c4.insets = new Insets(70,70,70,70);
        menuPanel.add(showDessert, c4);

        JPanel offerPanel = new JPanel();
        offerPanel.setLayout(new GridBagLayout());
        //showDessert.addActionListener(this);
        GridBagConstraints o0 = new GridBagConstraints();
        o0.fill = GridBagConstraints.BOTH;
        o0.gridwidth = 2;
        o0.weightx = 2;
        o0.weighty = 1;
        o0.gridy = 2; 

        JButton showOffer1 = new JButton("StudentDiscount");
        showOffer1.addActionListener(this);
        GridBagConstraints o1 = new GridBagConstraints();
        o1.fill = GridBagConstraints.BOTH;
        o1.gridwidth = 1;
        o1.weightx =  0.25;
        o1.weighty = 1;
        o1.gridx = 0;
        o1.gridy = 0;

        offerPanel.add(showOffer1, o1);

        JButton showOffer2 = new JButton("FamilyDiscount");
        showOffer2.addActionListener(this);
        GridBagConstraints o2 = new GridBagConstraints();
        o2.fill = GridBagConstraints.BOTH;
        o2.gridwidth = 1;
        o2.weightx =  0.25;
        o2.weighty = 1;
        o2.gridx = 1;
        o2.gridy = 0;
        offerPanel.add(showOffer2, o2);

        JButton showOffer3 = new JButton("None");
        showOffer3.addActionListener(this);
        GridBagConstraints o3 = new GridBagConstraints();
        o3.fill = GridBagConstraints.BOTH;
        o3.gridwidth = 1;
        o3.weightx =  0.25;
        o3.weighty = 1;
        o3.gridx = 2;
        o3.gridy = 0;
        offerPanel.add(showOffer3, o3);


        menuPanel.add(offerPanel, o0);

        return menuPanel;
    }

    private void setupCenterPanel() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(Color.BLACK);

        JPanel menuPanel = this.createMenuPanel();
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.BOTH;
        c1.gridwidth = 1;
        c1.weightx = 4;
        c1.weighty = 1;
        c1.gridx = 0;
        c1.gridy = 0;
        centerPanel.add(menuPanel, c1);

        JPanel basketPanel = this.createBasketPanel();
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.BOTH;
        c2.gridwidth = 1;
        c2.gridheight = 1;
        c2.weightx = 6;
        c2.weighty = 1;
        c2.gridx = 1;
        c2.gridy = 0;
        centerPanel.add(basketPanel, c2);


        this.validate();
        this.add(centerPanel, BorderLayout.CENTER);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Hot Drinks")) {
            ItemsGUI gui = new ItemsGUI(menuList, basket, "HotDrinks", ItemCategory.HotDrink.name());
            this.dispose();
        }
        
        if(e.getActionCommand().equals("Checkout")) 
        {
        	CheckOutGUI gui = new CheckOutGUI(menuList, basket, "Checkout", this);
        	this.dispose();
        }
        
        if (e.getActionCommand().equals("Cold Drinks")) {
            ItemsGUI gui = new ItemsGUI(menuList, basket, "Cold Drinks", ItemCategory.ColdDrink.name());
            this.dispose();
        }

        if (e.getActionCommand().equals("Desserts")) {
            ItemsGUI gui = new ItemsGUI(menuList, basket, "Desserts", ItemCategory.Dessert.name());
            this.dispose();
        }

        if (e.getActionCommand().equals("Meals")) {
            ItemsGUI gui = new ItemsGUI(menuList, basket, "Meals", ItemCategory.Meal.name());
            this.dispose();
        }
        
        if(e.getActionCommand().equals("StudentDiscount")) 
        {
        	basket.SetDiscount(Discount.student);
      		basketText.setText(basket.DisplayBasket());
        }
        
        if(e.getActionCommand().equals("FamilyDiscount")) 
        {
        	basket.SetDiscount(Discount.family);
      		basketText.setText(basket.DisplayBasket());
        }
        
        if(e.getActionCommand().equals("None")) 
        {
        	basket.SetDiscount(Discount.none);
      		basketText.setText(basket.DisplayBasket());
        }
    }
    
    void printOrdersToFile() 
    {
    	addToOrderList();
    	orderList.printToFile("Files/OrdersFile.txt");
    }
    
    void addToOrderList() 
    {
    	for(Item i : basket.getBasket()) 
    	{	    	 
    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
    		LocalDateTime now = LocalDateTime.now();  
    		//Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
    		
            String date = dtf.format(now);
            
    		Order order = new Order( i.getName(), i.getDescription(), date);
    		orderList.addToOrderList(order);
    	} 
    }
    
}