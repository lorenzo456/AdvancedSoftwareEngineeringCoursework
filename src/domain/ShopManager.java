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
    
    public void Start() 
    {
    	model = new OrderSystemModel();
    	view = new OrderSystemView(model);
    	controller = new OrderSystemController(model, view);
    
    	
    	menuList = new MenuList(this);
    	basket = new Basket(menuList);
    	orderGUI = new OrderGUI(menuList, basket);	

    	processor = new CustomerOrderProcessor(menuList);
    	Staff staff1 = new Staff(1, processor);
    	staff1.start();
    	
    	Staff staff2 = new Staff(2, processor);
    	staff2.start();

    }
    
    public void AddToQueue(Customer customer)
    {
    	//get processor to add to queue
    	processor.SetCurrentCustomer(customer);
    }
    
}