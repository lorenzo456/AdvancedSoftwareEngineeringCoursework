package domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import utils.Logger;

public class Staff extends Thread {
	private int staffNumber;
	private boolean takingOrder;
	private Customer currentCustomer;
	private Queue queueCustomers = new LinkedList<Customer>();
	private CustomerOrderProcessor processor;
	
	public Staff(int staffNumber, CustomerOrderProcessor processor) {
		this.staffNumber = staffNumber;
		this.queueCustomers = processor.GetQueue();
		this.processor = processor;
		System.out.println("Staff " +staffNumber + " is INIT");

		//run();
	}

public void run() {
	
	while(queueCustomers.size() != 0) {
		if(currentCustomer == null) {
			Logger.getInstance().info("STAFF MEMBER " + staffNumber + " is ready to take an order");

			Iterator<Customer> itr = queueCustomers.iterator();
			currentCustomer = itr.next();
			
			if(currentCustomer.getIsBeingServed() == false) 
			{
				currentCustomer.setIsBeingServed(true);
				takingOrder = true;
				Logger.getInstance().info("Staff member " + staffNumber + " is processing order " + currentCustomer.getID());
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Logger.getInstance().info("Staff member " + staffNumber + " has ended order " + currentCustomer.getID());
				processor.RemoveFromQueue(currentCustomer);		
				currentCustomer = null;
						
			}else {
				currentCustomer = null;
			}
			
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
}


public boolean getTakingOrder() {
	return takingOrder;
}

}