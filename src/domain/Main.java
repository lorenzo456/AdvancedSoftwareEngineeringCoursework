package domain;

public class Main {
    public static void main(String[] args){
        CustomerOrderQueue queue = new CustomerOrderQueue();

        Thread orderProcessingThread = new Thread(new CustomerOrderProcessor(queue));
        orderProcessingThread.start();

    	ShopManager shopManager = new ShopManager();
    	shopManager.run();
    }
}

