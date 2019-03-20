package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import OrderSystemGUI.OrderSystemView;
import utils.Logger;

public class CustomerOrderProcessor extends Thread {


    // Implements the Logger class, as we will use methods of it. We also need the Random method for the random wait time in the end.
	
	private Queue<Customer> queue = new LinkedList<>();
	private Queue<Customer> priorityCustomers = new LinkedList<>();

    private Customer currentCustomer;
	
    private MenuList menu;
    private static Logger logger = Logger.getInstance();
    private OrderSystemView view;
    
    public CustomerOrderProcessor(MenuList menulist) 
    {
    	this.menu = menulist;
    	

    }

    public void Init(OrderSystemView view) 
    {
    	this.view = view;
    	ArrayList<Item> temp = new ArrayList<Item>();
    	temp.add(menu.getItemByID("HD01"));
    	temp.add(menu.getItemByID("DE03"));
    	temp.add(menu.getItemByID("FI02"));
    	Customer customer1 = new Customer("1",temp);
    	Customer customer2 = new Customer("2",temp);
    	Customer customer3 = new Customer("3",temp);
    	Customer customer4 = new Customer("4",temp);
    	Customer customer5 = new Customer("5",temp);
    	Customer customer6 = new Customer("6",temp);
    	Customer customer7 = new Customer("7",temp);
    	Customer customer8 = new Customer("8",temp);
		Customer customer9 = new Customer("9",temp, true);
		Customer customer10 = new Customer("10",temp, true);
		Customer customer11 = new Customer("11",temp, true);
		Customer customer12 = new Customer("12",temp, true);
    	SetCurrentCustomer(customer1);
    	SetCurrentCustomer(customer2);
    	SetCurrentCustomer(customer3);
    	SetCurrentCustomer(customer4);
    	SetCurrentCustomer(customer5);
    	SetCurrentCustomer(customer6);
    	SetCurrentCustomer(customer7);
    	SetCurrentCustomer(customer8);

		SetCurrentCustomer(customer9);
		SetCurrentCustomer(customer10);
		SetCurrentCustomer(customer11);
		SetCurrentCustomer(customer12);

    }
                 
    
    public Queue<Customer> GetQueue() 
    {
    	return normalCustomers;
    }
    
    private void AddToNormalQueue(Customer customer)
    {
    	normalCustomers.add(customer);
    }

    private void AddToPriorityQueue(Customer customer)
	{
		priorityCustomers.add(customer);
	}

    
    public int AmountOfOrders() 
    {
    	return normalCustomers.size();
    }
    
    public void RemoveFromQueue(Customer customer) 
    {
    	if(customer == normalCustomers.peek())
    	{
    		normalCustomers.poll();
    		return;
    	}
    	
    	for(Customer c : normalCustomers)
    	{
    		if(customer == c) 
    		{
    			normalCustomers.remove(c);
    			return;
    		}
    	}
    }
    
    public void SetCurrentCustomer(Customer customer) 
    {
    	currentCustomer = customer;
    	if(currentCustomer != null) 
    	{
        	run();
    	}
    	System.out.println("The normalCustomers holds: " + normalCustomers.size());
    	currentCustomer = null;
    }
    

    public synchronized Customer GetUnservedCustomer()
    {
		for(Customer c : queue)
		{
			if(c.priority == true && c.getIsBeingServed() == false)
			{
				logger.info("Getting priority customer id: " + c.getID());
				return c;
			}
		}
		
    	return null;
    }

    public void run() {
    	if(currentCustomer == null) 
    	{
    		return;
    	}
    	
        logger.info("Customer " + currentCustomer.getID() + " is ordering");

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        AddToQueue(currentCustomer);
        view.UpdateAllText();

        
        //Change message name
        logger.info("Customer " + currentCustomer.getID() + " order is added to the Queue");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
