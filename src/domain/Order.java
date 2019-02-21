package domain;

import java.util.Date;

public class Order {
	   
	private String timestamp;
	private String itemName;
	private String description;
	private String customerId;

	public Order(String customerId,String itemName, String description, String timestamp) {
	this.timestamp = timestamp;
	this.itemName = itemName;
	this.description = description;
	this.customerId = customerId;
	}

	    public String getTimestamp() {
	        return timestamp;
	    }

	    public String getItemName() {
	        return itemName;
	    }
	    
	    public String getItemDescription() 
	    {
	    	return description;
	    }

	    public String getCustomerId() {
	        return customerId;
	    }
	
	
}
