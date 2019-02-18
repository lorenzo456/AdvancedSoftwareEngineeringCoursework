package domain;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ShopManager {
    private MenuList items;
    private OrderList orders;


    public ShopManager(MenuList items, OrderList orders) {
        this.items = items;
        this.orders = orders;
    }

    
    	public void writeToFile(String filename, String report) { FileWriter fw;
    		try {
    			fw = new FileWriter(filename); 
    			fw.write("The report\n"); 
    			fw.write(report);
    			fw.close();
    		}
              //message and stop if file not found
    		catch (FileNotFoundException fnf){ 
    			System.out.println(filename + " not found "); System.exit(0);
    		}
    			//stack trace here because we don't expect to come here
    		catch (IOException ioe){ 
    			ioe.printStackTrace(); 
    			System.exit(1);
    		} 
    	}
    	
    	/**
    public void generateReport(){
    	MenuList rep = new MenuList(); 
    	String report = report.getAllItems(); 
    	rep.writeToFile("Report.txt", report);
    	
    }
    **/
}