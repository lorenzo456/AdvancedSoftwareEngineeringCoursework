package domain;

import java.util.concurrent.ConcurrentLinkedQueue;

public class OrderQueue {
    private ConcurrentLinkedQueue<Order> queue = new ConcurrentLinkedQueue<Order>();

    public void add(Order order){
        this.queue.add(order);
    }

    public Order remove(){
        return this.queue.remove();
    }
}
