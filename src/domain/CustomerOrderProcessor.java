package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import OrderSystemGUI.OrderSystemView;
import utils.Logger;

public class CustomerOrderProcessor extends Thread {
    private Queue<Customer> queue = new LinkedList<>();
    private Customer currentCustomer;
    private MenuList menu;
    private OrderSystemView view;

    private int speed = 500;
    private static Logger logger = Logger.getInstance();

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

        Customer customer1 = new Customer("1", temp1);
        Customer customer2 = new Customer("2", temp2);
        Customer customer3 = new Customer("3", temp3);
        Customer customer4 = new Customer("4", temp2);
        Customer customer5 = new Customer("5", temp2);
        Customer customer6 = new Customer("6", temp1);
        Customer customer7 = new Customer("7", temp3);
        Customer customer8 = new Customer("8", temp2);

        Customer customer9 = new Customer("9", temp1, true);
        Customer customer10 = new Customer("10", temp2, true);
        Customer customer11 = new Customer("11", temp3, true);
        Customer customer12 = new Customer("12", temp1, true);

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

    public void SetSpeed(int speed) {
        this.speed = speed;
    }

    public Queue<Customer> GetQueue() {
        return queue;
    }

    private void AddToQueue(Customer customer) {
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

    public void SetCurrentCustomer(Customer customer) {
        currentCustomer = customer;
        if (currentCustomer != null) {
            run();
        }
        currentCustomer = null;
    }


    public synchronized Customer GetWaitingCustomer() {
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

        return null;
    }

    public void run() {
        try {
            if (currentCustomer == null) {
                logger.warn("No more customers to process");
                return;
            }

            logger.info("Customer " + currentCustomer.getID() + " is ordering");
            Thread.sleep(speed);

            AddToQueue(currentCustomer);
            view.UpdateAllText();

            logger.info("Customer " + currentCustomer.getID() + " order is added to the Queue");
            Thread.sleep(speed);

        } catch (InterruptedException e) {
            logger.error("CustomerProcessor thread interrupted " + e.getMessage());

        }
    }
}
