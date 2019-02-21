package domain;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderList {
    private ArrayList<Order> orders = new ArrayList<Order>();

    public OrderList() {
    	fromFile("OrdersFile2.txt");
    }

    public String getListOfOrders() 
    {
    	String temp = "";
    	temp += String.format("%s %15s %20s %60s ", "/User ID", "Item", "Item description", "Timestamp \n");
    	for(Order i : orders) 
    	{
    		//temp += String.format(/*"%10 %10 %10 %10 \n"*/ i.getCustomerId()+ i.getItemName()+ i.getItemDescription()+ i.getTimestamp() +"\n");
        	temp += String.format("%s %15s %20s %60s ", i.getCustomerId()+",", i.getItemName()+",", i.getItemDescription()+",", i.getTimestamp()+","+"\n");
    	}
    	return temp;
    }
    public void printToFile(String fileName) 
    {
    	try {
    		System.out.println("PRINTED");
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			out.println(getListOfOrders());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    private void fromFile(String fileName) {
        String separator = ",";

        Path path = FileSystems.getDefault().getPath(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = "";

            while ((line = br.readLine()) != null) {
            	if(line.charAt(0) == '/') 
            	{
            		continue;
            	}
            	
                String[] parts = line.split(separator);
                String customerId = parts[0].trim();
                String itemName = parts[1].trim();
        		String description = parts[2].trim();
                String date = parts[3].trim();
                
                System.out.println(customerId + " " + itemName + " " +  description + " " + date);
                
                Order tempOrder = new Order(parts[0].trim(), parts[1].trim(), parts[2].trim(), date);
                orders.add(tempOrder); 
            }
        }catch (IOException e) {
            System.out.println("Unable to load menu list file " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unable to create menu item " + e.getMessage());
        }
    }
    
    public void addToOrderList(Order o) 
    {
    	orders.add(o);
    }

}