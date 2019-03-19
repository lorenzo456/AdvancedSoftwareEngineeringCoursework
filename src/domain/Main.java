package domain;

import OrderSystemGUI.*;

public class Main {
    public static void main(String[] args){
        /**
         * CustomerOrderQueue queue = new CustomerOrderQueue();
         * 
         * Thread orderProcessingThread = new Thread(new CustomerOrderProcessor(queue));
        orderProcessingThread.start();

    	ShopManager shopManager = new ShopManager();
    	shopManager.run();
    	
         */
    	
    	OrderSystemModel model = new OrderSystemModel();
    	OrderSystemView view = new OrderSystemView(model);
    	OrderSystemController controller = new OrderSystemController(model,view);
    	
    }
}

