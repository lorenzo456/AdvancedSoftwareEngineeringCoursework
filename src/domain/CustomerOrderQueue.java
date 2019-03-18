package domain;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CustomerOrderQueue {
    private ConcurrentLinkedQueue<CustomerOrder> queue = new ConcurrentLinkedQueue<CustomerOrder>();

    /**
     * Add customer order to queue
     * @param order
     */
    public void add(CustomerOrder order){
        this.queue.add(order);
    }

    /**
     * Get and remove first customer order
     * @return
     */
    public CustomerOrder remove(){
        return this.queue.remove();
    }
    
    // shall we add a (0), how are we sure it is the first on the queue?
    
}
