package domain;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Random;

import javax.swing.JTextArea;

import MVC.OrderSystemView;
import utils.Logger;

public class Staff extends Thread {
    private long staffNumber;
    private int speed = 5;
    private boolean isFinished = false;
    private boolean closingShop = false;

    private Customer currentCustomer;
    private Queue<Customer> queueCustomers = new LinkedList<Customer>();
    private CustomerOrderProcessor processor;
    private OrderSystemView view;
    private JTextArea panel;
    private String currentTask;

    private static Logger logger = Logger.getInstance();


    public Staff(long staffNumber, CustomerOrderProcessor processor, OrderSystemView view) {
        this.staffNumber = staffNumber;
        this.queueCustomers = processor.GetQueue();
        this.processor = processor;

        this.view = view;
        currentTask = staffNumber + " is waiting for orders in the queue";
        logger.info("STAFF MEMBER " + currentTask);
    }

    public Customer GetCurrentCustomer()
	{
    	return currentCustomer;
	}

    public JTextArea GetPanel() {
        return panel;
    }

    public void SetPanel(JTextArea panel) {
        this.panel = panel;
    }

    public void run() {
        while (queueCustomers.size() == 0 && isFinished == false) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (queueCustomers.size() > 0) {
            Random r = new Random();
            int low = 3000 / speed;
            int high = 15000 / speed;
            int result = r.nextInt(high - low) + low;

            try {
				currentCustomer = processor.GetWaitingCustomer();
				if (currentCustomer.getIsBeingServed() == false) {
					currentCustomer.setIsBeingServed(true);

					currentTask = staffNumber + " is currently processing customer " + currentCustomer.getID() + "'s order of: \n" + currentCustomer.GetItemsOrdered();
					logger.info("Staff member " + currentTask);


					view.UpdateAllText();

					try {
						Thread.sleep(result);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					currentTask = staffNumber + " has completed processing customer " + currentCustomer.getID() + "'s order of: \n" + currentCustomer.GetItemsOrdered();
					logger.info("Staff member " + currentTask);


					processor.RemoveFromQueue(currentCustomer);
					currentCustomer = null;
					view.UpdateAllText();

				}else
				{
					currentCustomer = null;
				}

			} catch (NullPointerException e) {
				continue;
			}



            try {
                result = r.nextInt(high - low) + low;
                Thread.sleep(result);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            currentTask = staffNumber + " is ready to take an order";
            logger.info("STAFF MEMBER " + staffNumber + " is ready to take an order");

            view.UpdateAllText();
        }

        if (isFinished == false) {
            currentTask = staffNumber + " is closing the shop";
            logger.info("STAFF MEMBER " + currentTask);
            closingShop = Logger.getInstance().print();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (closingShop) {
                Logger.getInstance().printFile();
            } else {
                currentTask = staffNumber + " is cleaning up";
                logger.info("STAFF MEMBER " + currentTask);
            }
        }
    }


    public String GetCurrentCustomerTask() {
        return currentTask;
    }


    public void setSpeed(int speed) {
        logger.info("Changed staff: " + staffNumber + " speed: " + speed);
        this.speed = speed;
    }

    public void finish() {
        logger.info("Staff finished: " + staffNumber);
        this.isFinished = true;
    }

    @Override
    public boolean equals(Object o) {
        Staff staff = (Staff) o;
        return staffNumber == staff.staffNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffNumber);
    }
}