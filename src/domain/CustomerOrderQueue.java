package domain;

import java.util.LinkedList;

public class CustomerOrderQueue {

    private LinkedList<CustomerOrder> queue = new LinkedList<CustomerOrder>();


    /**
     * Add customer order to queue
     * This might deadlock if there is consumer thread holding lock
     * This queue is unbounded in size.
     * @param order
     */


    public synchronized void add(CustomerOrder order){

        this.queue.add(order);
    }

    /**
     * Get and remove first customer order
     * To avoid deadlocks queue should not be consumed directly
     * Observer patter or producer/consumer patter should be used
     *
     * @return
     */

    public synchronized CustomerOrder poll() {
        return this.queue.poll();
    }
    
    // Are we implementing this? And if we do, where? 
}
