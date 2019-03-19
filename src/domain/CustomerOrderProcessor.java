package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import utils.Logger;

public class CustomerOrderProcessor implements Runnable {
	
	private Queue<Customer> queue = new LinkedList<>();
    private Customer currentCustomer;
	
    private MenuList menu;
    private static Logger logger = Logger.getInstance();

    public CustomerOrderProcessor(MenuList menulist) 
    {
    	this.menu = menulist;
    	
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
    	SetCurrentCustomer(customer1);
    	SetCurrentCustomer(customer2);
    	SetCurrentCustomer(customer3);
    	SetCurrentCustomer(customer4);
    	SetCurrentCustomer(customer5);
    	SetCurrentCustomer(customer6);
    	SetCurrentCustomer(customer7);
    	SetCurrentCustomer(customer8);


    }
    
    public Queue GetQueue() 
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
    	System.out.println("The queue holds: " + queue.size());
    	currentCustomer = null;
    }
    
    public Customer GetUnservedCustomer() 
    {    	
    	for(Customer c : queue) 
    	{
    		if(c.getIsBeingServed() == false) 
    		{
    			return c;
    		}
    	}
		
    	return null;
    }

    @Override
    public void run() {
    	//Change message name
        logger.info("Customer " + currentCustomer.getID() + " is ordering");

        AddToQueue(currentCustomer);
        
        //Change message name
        logger.info("Customer " + currentCustomer.getID() + " order is added to the Queue");
    }
}
