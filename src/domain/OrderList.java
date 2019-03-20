package domain;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class OrderList {
    private ArrayList<Order> orders = new ArrayList<Order>();

    public OrderList() {
    	fromFile("Files/OrdersFile.txt");
    }

    public String getListOfOrders() 
    {
    	String temp = String.format("%s %15s %20s %60s ", "/User ID", "Item", "Item description", "Timestamp");
    	for(Order i : orders) 
    	{
        	temp += String.format("%s %15s %20s %60s","\n"+",", i.getItemName()+",", i.getItemDescription()+",", i.getTimestamp()+",");
    	}
    	return temp;
    }
    
    public void printToFile(String fileName) 
    {
    	try {
    		//System.out.println("PRINTED");
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			out.println(getListOfOrders());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
    
    private void fromFile(String fileName) {
        String separator = ",";

        Path path = FileSystems.getDefault().getPath(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = "";

            while ((line = br.readLine()) != null) {
            	if(line.charAt(0) == '/' || line.charAt(0) == ' ') 
            	{
            		continue;
            	}
            	
                String[] parts = line.split(separator);
                String customerId = parts[0].trim();
                String itemName = parts[1].trim();
        		String description = parts[2].trim();
                String date = parts[3].trim();
                
               // System.out.println(customerId + " " + itemName + " " +  description + " " + date);
                
                Order tempOrder = new Order(parts[1].trim(), parts[2].trim(), date);
                orders.add(tempOrder); 
            }
        }catch (IOException e) {
            System.out.println("Unable to load order list file " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unable to create order item " + e.getMessage());
        }
    }
    
    public void addToOrderList(Order o) 
    {
    	orders.add(o);
    }

}