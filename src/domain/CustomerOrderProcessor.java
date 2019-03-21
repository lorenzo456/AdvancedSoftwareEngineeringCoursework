package domain;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import OrderSystemGUI.OrderSystemView;
import utils.Logger;

public class CustomerOrderProcessor extends Thread
{
    private Queue<Customer> queue = new LinkedBlockingDeque<>();
    private MenuList menu;
    private OrderSystemView view;
	private static Object mutex = new Object();


	private int speed = 500;
    private static Logger logger = Logger.getInstance();
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public CustomerOrderProcessor(MenuList menulist) {
        this.menu = menulist;
    }

    public void Init(OrderSystemView view) {
        this.view = view;

        ArrayList<Item> temp1 = new ArrayList<Item>();
        temp1.add(menu.getItemByID("HD01"));
        temp1.add(menu.getItemByID("DE03"));
        temp1.add(menu.getItemByID("FI02"));

        ArrayList<Item> temp2 = new ArrayList<Item>();
        temp2.add(menu.getItemByID("CD03"));
        temp2.add(menu.getItemByID("HD02"));
        temp2.add(menu.getItemByID("FI02"));

        ArrayList<Item> temp3 = new ArrayList<Item>();
        temp3.add(menu.getItemByID("CD01"));
        temp3.add(menu.getItemByID("DE03"));
        temp3.add(menu.getItemByID("DE04"));

        Customer customer1 = new Customer("Sabrina", temp1);
        Customer customer2 = new Customer("Lorenzo", temp2);
        Customer customer3 = new Customer("Jowita", temp3);
        Customer customer4 = new Customer("Lucia", temp2);
        Customer customer5 = new Customer("Odhran", temp2);
        Customer customer6 = new Customer("Karan", temp1);
        Customer customer7 = new Customer("Emanuele", temp3);
        Customer customer8 = new Customer("Maria", temp2);

        Customer customer9 = new Customer("Mike", temp1, true);
        Customer customer10 = new Customer("Louise", temp2, true);
        Customer customer11 = new Customer("Sara", temp3, true);
        Customer customer12 = new Customer("Horacio", temp1, true);

        customers.add(customer1);
        customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);
		customers.add(customer5);
		customers.add(customer6);
		customers.add(customer7);
		customers.add(customer8);
		customers.add(customer9);
		customers.add(customer10);
		customers.add(customer11);
		customers.add(customer12); 

    }

    public Queue<Customer> GetQueue() {
        return queue;
    }

    public void AddToQueue(Customer customer) {
        queue.add(customer);
    }

    public int AmountOfOrders() {
        return queue.size();
    }

    public void RemoveFromQueue(Customer customer) {
        if (customer == queue.peek()) {
            queue.poll();
            return;
        }

        for (Customer c : queue) {
            if (customer == c) {
                queue.remove(c);
                return;
            }
        }
    }

    public synchronized Customer GetWaitingCustomer() {
		synchronized (mutex) {

			for (Customer c : queue) {
				if (c.getIsPriorityCustomer() == true && c.getIsBeingServed() == false) {
					logger.info("Getting priority customer id: " + c.getID());
					return c;
				}
			}

			for (Customer c : queue) {
				if (c.getIsBeingServed() == false && c.getIsBeingServed() == false) {
					logger.info("Getting normal customer id: " + c.getID());
					return c;
				}
			}
		}
        return null;
    }

    public void run() {
		for (Customer c : customers)
		{
			logger.info("Customer " + c.getID() + " is ordering");
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			AddToQueue(c);
			view.UpdateAllText();

			logger.info("Customer " + c.getID() + " order is added to the Queue");
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

    }
}
