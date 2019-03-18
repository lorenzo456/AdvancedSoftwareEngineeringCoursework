package domain;

import utils.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerOrder {
    private String customerId;
    private static Logger logger = Logger.getInstance();
    private List<Order> orders =  Collections.synchronizedList(new ArrayList<Order>());

    public CustomerOrder (String customerId){
        this.customerId = customerId;
    }

    /**
     * Get customer Id
     * @return
     */
    public String getCustomerId (){
        return  this.customerId;
    }

    /**
     * Set customer Id
     * @param customerId
     */
    public void setCustomerId (String customerId) {
        this.customerId = customerId;
    }

    /**
     * Add orders
     * @param order
     */
    public void addOrder(Order order) {
        logger.info("Added order customerId: " + customerId + " item: " + order);
        this.orders.add(order);
    }

    /**
     * Removed first order
     * @return
     */
    public Order removeOrder() {
        logger.info("Remove customer order customerId: " + customerId);
        return orders.remove(0);
        // why does she put a zero - this removes the top element of the queue
    }
}
