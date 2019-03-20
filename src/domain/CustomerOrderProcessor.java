package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import OrderSystemGUI.OrderSystemView;
import utils.Logger;

public class CustomerOrderProcessor extends Thread {


    // Implements the Logger class, as we will use methods of it. We also need the Random method for the random wait time in the end.
	
	private Queue<Customer> queue = new LinkedList<>();

    private Customer currentCustomer;
	
    private MenuList menu;
    private static Logger logger = Logger.getInstance();
    private OrderSystemView view;
    private int speed;
    
    public CustomerOrderProcessor(MenuList menulist) 
    {
    	this.menu = menulist;
    	

    }

    public void Init(OrderSystemView view) 
    {
    	this.view = view;
    	speed = 500;
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
                 
    public void SetSpeed(int speed) 
    {
    	this.speed = speed;
    }
    
    public int GetSpeed() 
    {
    	return speed;
    }
    
    public Queue<Customer> GetQueue() 
    {
    	return queue;
    }
    

    private void AddToQueue(Customer customer)
	{
    	queue.add(customer);
	}

    
    public int AmountOfOrders() 
    {
    	return queue.size();
    }
    
    public void RemoveFromQueue(Customer customer) 
    {
    	if(customer == queue.peek())
    	{
    		queue.poll();
    		return;
    	}
    	
    	for(Customer c : queue)
    	{
    		if(customer == c) 
    		{
    			queue.remove(c);
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
    	System.out.println("The normalCustomers holds: " + queue.size());
    	currentCustomer = null;
    }
    

    public synchronized Customer GetUnservedCustomer()
    {
		for(Customer c : queue)
		{
			if(c.getIsPriorityCustomer() == true && c.getIsBeingServed() == false)
			{
				logger.info("Getting priority customer id: " + c.getID());
				return c;
			}
		}
		
		for(Customer c : queue)
		{
			if(c.getIsBeingServed() == false)
			{
				logger.info("Getting normal customer id: " + c.getID());
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
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        AddToQueue(currentCustomer);
        view.UpdateAllText();

        
        //Change message name
        logger.info("Customer " + currentCustomer.getID() + " order is added to the Queue");
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
