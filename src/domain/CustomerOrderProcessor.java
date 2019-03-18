package domain;

import utils.Logger;

public class CustomerOrderProcessor implements Runnable {
    private CustomerOrderQueue queue;
   // private CustomerOrder currentCustomer;

    private static Logger logger = Logger.getInstance();
   // private static Random rand = new Random();

    public CustomerOrderProcessor() {
        queue = new CustomerOrderQueue();
    }
    
    public CustomerOrderQueue GetQueue() 
    {
    	return queue;
    }
    

    @Override
    public void run() {
        logger.info("Start thread");

        logger.info("Finish thread");
    }
}
