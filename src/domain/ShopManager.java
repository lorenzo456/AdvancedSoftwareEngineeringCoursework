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

    	menuList = new MenuList(this);
    	basket = new Basket(menuList);
    	orderGUI = new OrderGUI(menuList, basket);	

    	processor = new CustomerOrderProcessor(menuList);

    	
    	model = new OrderSystemModel(processor);
    	view = new OrderSystemView(model);
    	Staff staff1 = new Staff(1, processor, view);
    	Staff staff2 = new Staff(2, processor, view);
    	Staff[] staffMembers = {staff1, staff2};
    	model.SetStaffMembers(staffMembers);
    	view.InitializeView();
    	controller = new OrderSystemController(model, view);
    	
    	staff1.start();    	
    	staff2.start();
    	processor.start();
    	processor.Init(view);

    }
    
    public void AddToQueue(Customer customer)
    {
    	//get processor to add to queue
    	processor.SetCurrentCustomer(customer);
    }
    
}