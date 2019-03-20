package domain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import OrderSystemGUI.OrderSystemView;
import utils.Logger;

public class Staff extends Thread {
	private int staffNumber;
	private int speed = 5;

	private boolean takingOrder;
	private Customer currentCustomer;
	private Queue<Customer> queueCustomers = new LinkedList<Customer>();
	private CustomerOrderProcessor processor;
	private OrderSystemView view;
	private static Logger logger = Logger.getInstance();

	public Staff(int staffNumber, CustomerOrderProcessor processor, OrderSystemView view) {
		this.staffNumber = staffNumber;
		this.queueCustomers = processor.GetQueue();
		this.processor = processor;
		this.view = view;
		Logger.getInstance().info("STAFF MEMBER " + staffNumber + " is ready to take an order");
	}

public void run() {

	while(queueCustomers.size() > 0) {
		Random r = new Random();
		int low = 3000 / speed;
		int high = 15000 / speed;
		int result = r.nextInt(high-low) + low;


		if(currentCustomer == null) {
			currentCustomer = processor.GetUnservedCustomer();
			if(currentCustomer == null)
			{
				logger.info("STAFF MEMBER " + staffNumber + " is ready to take an order");
				view.UpdateAllText();
				return;
			}

			if(currentCustomer.getIsBeingServed() == false && currentCustomer != null)
			{
				currentCustomer.setIsBeingServed(true);
				takingOrder = true;
				logger.info("Staff member " + staffNumber + " is processing order " + currentCustomer.getID());
				view.UpdateAllText();

				try {
					Thread.sleep(result);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                logger.info("Staff member " + staffNumber + " has ended order " + currentCustomer.getID());
				processor.RemoveFromQueue(currentCustomer);
				currentCustomer = null;
				takingOrder = false;
				view.UpdateAllText();

			}else {
				currentCustomer = null;
                logger.info("STAFF MEMBER " + staffNumber + " is ready to take an order");
				view.UpdateAllText();
			}

		}
		try {
			Thread.sleep(result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("THE SIZE IS " + queueCustomers.size());
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

	public boolean getTakingOrder() {
	return takingOrder;
}

	public void setSpeed(int speed) {
        logger.info("Changed staff: " + staffNumber + " speed: "  + speed);
	    this.speed = speed;
	}
}