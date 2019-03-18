package domain;

import OrderSystemGUI.OrderSystemController;
import OrderSystemGUI.OrderSystemModel;
import OrderSystemGUI.OrderSystemView;
import gui.OrderGUI;

public class ShopManager {
	
	OrderSystemModel model;
	OrderSystemView view;
	OrderSystemController controller;
	CustomerOrderProcessor processor;
    
	MenuList menuList;
	Basket basket;
	OrderGUI orderGUI;	
	
    public ShopManager() {
       
    }
    
    public void run() 
    {
    	model = new OrderSystemModel();
    	view = new OrderSystemView(model);
    	controller = new OrderSystemController(model, view);
    
    	processor = new CustomerOrderProcessor();
    	
    	menuList = new MenuList(this);
    	basket = new Basket(menuList);
    	orderGUI = new OrderGUI(menuList, basket);	
    }
    
    public void AddToQueue(Customer customer)
    {
    	processor.GetQueue().add(customer);
    }
    
}