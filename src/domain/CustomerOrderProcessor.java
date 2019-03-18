package domain;

import utils.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CustomerOrderProcessor implements Runnable {
    private CustomerOrderQueue queue;
    private CustomerOrder currentCustomer;

    // Implements the Logger class, as we will use methods of it. We also need the Random method for the random wait time in the end.
    private static Logger logger = Logger.getInstance();
    private static Random rand = new Random();

    public CustomerOrderProcessor(CustomerOrderQueue queue) {
        this.queue = queue;
    }

    private String getCurrentCustomerId(){
        if(this.currentCustomer != null){
            return this.currentCustomer.getCustomerId();
        }
        return null;
    }

    private void fromFile(String fileName) {
        String separator = ",";

        Path path = FileSystems.getDefault().getPath(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = "";

            while ((line = br.readLine()) != null) {
                    if (line.charAt(0) == '/' || line.charAt(0) == ' ') {
                        continue;
                    }

                    String[] parts = line.split(separator);
                    String customerId = parts[0].trim();
                    String itemName = parts[1].trim();
                    String description = parts[2].trim();
                    String date = parts[3].trim();

                    if (currentCustomer == null) {
                        this.currentCustomer = new CustomerOrder(customerId);
                        logger.info("Started new customer order for customerId : "+ currentCustomer.getCustomerId());
                    }

                    if(customerId.equals(this.getCurrentCustomerId())){
                        Order tempOrder = new Order(itemName, description, date);
                        currentCustomer.addOrder(tempOrder);
                    } else {
                        logger.info("Added customer order to queue CustomerId : "+ currentCustomer.getCustomerId()) ;
                        queue.add(currentCustomer);

                        this.currentCustomer = new CustomerOrder(customerId);
                        logger.info("Started new customer order for customerId : "+ currentCustomer.getCustomerId());
                        Order tempOrder = new Order(itemName, description, date);
                        currentCustomer.addOrder(tempOrder);
                    }

                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(1000));

            }
        } catch (IOException e) {
            logger.error("Unable to load order list file " + e.getMessage());
        } catch(InterruptedException e) {
            logger.warn("Interrupted loading" + e.getMessage());
        } catch (RuntimeException e) {
            logger.warn("Unable to create order item " + e.getMessage());
        }
    }

    @Override
    public void run() {
        logger.info("Start reading orders");
        fromFile("Files/OrdersFile.txt");
        logger.info("Finished reading orders");
    }
}
