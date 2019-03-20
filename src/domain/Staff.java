package domain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import OrderSystemGUI.OrderSystemView;
import utils.Logger;

public class Staff extends Thread {
	private int staffNumber;
	private boolean takingOrder;
	private Customer currentCustomer;
	private Queue<Customer> queueCustomers = new LinkedList<Customer>();
	private CustomerOrderProcessor processor;
	private OrderSystemView view;
	private String currentTask;
	
	public Staff(int staffNumber, CustomerOrderProcessor processor, OrderSystemView view) {
		this.staffNumber = staffNumber;
		this.queueCustomers = processor.GetQueue();
		this.processor = processor;
		this.view = view; 
		Logger.getInstance().info("STAFF MEMBER " + staffNumber + " is waiting for orders");
	}

public void run() {
	while(queueCustomers.size() == 0) 
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	while(queueCustomers.size() > 0) {
		Random r = new Random();
		int low = 1000;
		int high = 5000;
		int result = r.nextInt(high-low) + low;
		
		if(currentCustomer == null) {
			
			currentCustomer = processor.GetUnservedCustomer();
			if(currentCustomer == null) 
			{	
				currentTask = staffNumber + " is ready to take an order";
				Logger.getInstance().info("STAFF MEMBER " + staffNumber + " is ready to take an order");
				view.UpdateAllText();
				continue;
			}
			
			if(currentCustomer.getIsBeingServed() == false && currentCustomer != null) 
			{
				currentCustomer.setIsBeingServed(true);
				takingOrder = true;
				currentTask = staffNumber + " is currently processing customer " + currentCustomer.getID() + "'s order of: \n" + currentCustomer.GetItemsOrdered();
				Logger.getInstance().info("Staff member " + staffNumber + " is processing order " + currentCustomer.getID());
				view.UpdateAllText();
				
				try {
					Thread.sleep(result);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentTask = staffNumber + " has completed processing customer " + currentCustomer.getID() + "'s order of: \n" + currentCustomer.GetItemsOrdered();
				Logger.getInstance().info("Staff member " + staffNumber + " has ended order " + currentCustomer.getID());
				processor.RemoveFromQueue(currentCustomer);
				currentCustomer = null;
				takingOrder = false;
				view.UpdateAllText();
						
			}else {
				currentCustomer = null;
			}
			
		}
		try {
			Thread.sleep(result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	if(!Logger.getInstance().GetIsPrinted()) 
	{
	currentTask = staffNumber + " is closing the shop";
	Logger.getInstance().info("STAFF MEMBER " + staffNumber + " closes the shop");
	Logger.getInstance().printFile();
	}else
	{
	currentTask = staffNumber + " is cleaning up";
	}
}

public String GetCurrentCustomerID() 
{
	if(currentCustomer != null) 
	{
		return currentCustomer.getID();
	}else
	{
		return "";
	}
}

public String GetCurrentCustomerItems() 
{
	if(currentCustomer != null) 
	{
		return currentCustomer.GetItemsOrdered();
	}else
	{
		return "";
	}
}
public String GetCurrentCustomerTask() 
{
	return currentTask;
}
public boolean getTakingOrder() {
	return takingOrder;
}

}