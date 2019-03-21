package domain;

import java.util.ArrayList;

import OrderSystemGUI.OrderSystemController;
import OrderSystemGUI.OrderSystemModel;
import OrderSystemGUI.OrderSystemView;
import gui.OrderGUI;
import utils.Logger;

public class ShopManager {
	
	OrderSystemModel model;
	OrderSystemView view;
	OrderSystemController controller;
	CustomerOrderProcessor processor;
    
	MenuList menuList;
	Basket basket;
	OrderGUI orderGUI;	
	ArrayList<Staff> staffMembers;
	public ShopManager() {
       
    }
    
    public void Start() 
    {

    	menuList = new MenuList(this);
    	basket = new Basket(menuList);

    	processor = new CustomerOrderProcessor(menuList);

    	model = new OrderSystemModel(processor, this);
		controller = new OrderSystemController(model);
    	view = new OrderSystemView(model, controller);

    	controller.setView(view);
    	
    	Staff staff1 = new Staff(1, processor, view);
    	Staff staff2 = new Staff(2, processor, view);
    	staffMembers = new ArrayList<Staff>();
    	staffMembers.add(staff1);
    	staffMembers.add(staff2);
    	//Staff[] staffMembers = {staff1, staff2};

    	model.SetStaffMembers(staffMembers);
    	view.InitializeView();

    	//staff1.start();    	
    	//staff2.start();
    	processor.start();
    	processor.Init(view);

    }    
    
    public void AddToQueue(Customer customer)
    {
    	//get processor to add to queue
    	processor.SetCurrentCustomer(customer);
    	Logger.getInstance().info(customer.getID() + " has ordered " + customer.GetItemsOrdered() + " online" );
    }
    
    public void StartProgram() 
    {
    	for(Staff staff : staffMembers) 
    	{
    		staff.start();
    	}
    }
    
    public void OrderOnline() 
    {
    	orderGUI = new OrderGUI(menuList, basket);	
    }
    
    public Staff AddStaff() 
    {
    	Staff temp = new Staff(3, processor, view);
    	staffMembers.add(temp);
    	return temp;
    }
    
}