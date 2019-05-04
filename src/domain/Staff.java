package domain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JTextArea;

import OrderSystemGUI.OrderSystemView;
import utils.Logger;

public class Staff extends Thread {
	private int staffNumber;
	private int speed = 5;

	private boolean closingShop;
	private Customer currentCustomer;
	private Queue<Customer> queueCustomers = new LinkedList<Customer>();
	private CustomerOrderProcessor processor;
	private OrderSystemView view;
	private static Logger logger = Logger.getInstance();
	private JTextArea panel;
	private String currentTask;
	

	public Staff(int staffNumber, CustomerOrderProcessor processor, OrderSystemView view) {
		this.staffNumber = staffNumber;
		this.queueCustomers = processor.GetQueue();
		this.processor = processor;

		this.view = view;
		currentTask = staffNumber + " is waiting for orders in the queue";
		Logger.getInstance().info("STAFF MEMBER " + staffNumber + " is waiting for orders in the queue");
	}

	public JTextArea GetPanel() 
	{
		return panel;
	}

	public void SetPanel(JTextArea panel) 
	{
		this.panel = panel;
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
		int low = 3000 / speed;
		int high = 15000 / speed;
		int result = r.nextInt(high-low) + low;


		if(currentCustomer == null) {

			try
			{
				currentCustomer = processor.GetUnservedCustomer();

			}catch(NullPointerException e ) 
			{
				continue;
			}


			if(currentCustomer != null &&currentCustomer.getIsBeingServed() == false)
			{
				currentCustomer.setIsBeingServed(true);

				currentTask = staffNumber + " is currently processing customer " + currentCustomer.getID() + "'s order of: \n" + currentCustomer.GetItemsOrdered();
				Logger.getInstance().info("Staff member " + staffNumber + " is processing order " + currentCustomer.getID());

				view.UpdateAllText();

				try {
					Thread.sleep(result);
					result = r.nextInt(high-low) + low;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				currentTask = staffNumber + " has completed processing customer " + currentCustomer.getID() + "'s order of: \n" + currentCustomer.GetItemsOrdered();
				Logger.getInstance().info("Staff member " + staffNumber + " has ended order " + currentCustomer.getID());

				processor.RemoveFromQueue(currentCustomer);
				currentCustomer = null;
				view.UpdateAllText();

			}else {
				currentCustomer = null;

			}

		}
		try {
			Thread.sleep(result);
			result = r.nextInt(high-low) + low;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		currentTask = staffNumber + " is ready to take an order";
		Logger.getInstance().info("STAFF MEMBER " + staffNumber + " is ready to take an order");

		view.UpdateAllText();
		System.out.println("THE SIZE IS " + queueCustomers.size());
	}

	

	currentTask = staffNumber + " is closing the shop";
	Logger.getInstance().info("STAFF MEMBER " + staffNumber + " closes the shop");
	closingShop = Logger.getInstance().print();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	if(closingShop) {
		Logger.getInstance().printFile();
	}else {
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


public void setSpeed(int speed) {
    logger.info("Changed staff: " + staffNumber + " speed: "  + speed);
    this.speed = speed;
}

}