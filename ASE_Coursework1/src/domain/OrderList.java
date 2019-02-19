package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderList {
    private ArrayList<Order> orders;

    public OrderList() {
        this.orders = new ArrayList<Order>();

    }

    public ArrayList<Order> getOrders() {
        return orders;
    }


    public static OrderList fromFile(String fileName) {
        String separator = ",";
        OrderList list = new OrderList();

        Path path = FileSystems.getDefault().getPath(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(separator);

                SimpleDateFormat parser = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
                Date date = parser.parse(parts[2].trim());

                list.getOrders().add(
                        new Order(parts[0].trim(), parts[1].trim(), date)
                );
            }
        } catch (ParseException e){
            System.out.println("Unable to parse a time stamp" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Unable to load menu list file " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unable to create menu item " + e.getMessage());
        }
        return list;

    }

    @Override
    public String toString() {
        return "domain.OrderList{" +
                "orders=" + orders +
                '}';
    }
}