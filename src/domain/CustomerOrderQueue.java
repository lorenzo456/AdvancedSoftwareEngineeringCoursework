package domain;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CustomerOrderQueue {
    private ConcurrentLinkedQueue<Customer> queue = new ConcurrentLinkedQueue<Customer>();

    /**
     * Add customer order to queue
     * @param order
     */
    public void add(Customer order){
        this.queue.add(order);
    }

    /**
     * Get and remove first customer order
     * @return
     */
    public void remove(Customer customer)
    {
        //Todo if Customer == element in queue remove()
    }
    
}
