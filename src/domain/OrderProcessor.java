package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class OrderProcessor implements Runnable {
    private OrderQueue queue;

    private Logger logger = Logger.getInstance();
    private static Random rand = new Random(47);

    public OrderProcessor(OrderQueue queue) {
        this.queue = queue;
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

                Order tempOrder = new Order(customerId, itemName, description, date);
                queue.add(tempOrder);
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(1000));
                logger.info("Added order to queue customerId: " + customerId + " item: " + itemName);
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
