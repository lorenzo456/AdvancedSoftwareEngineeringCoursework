package domain;

public class Main {
    public static void main(String[] args){
        OrderQueue queue = new OrderQueue();

        Thread orderProcessingThread = new Thread(new OrderProcessor(queue));
        orderProcessingThread.start();

    	ShopManager shopManager = new ShopManager();
    	shopManager.run();
    }
}

