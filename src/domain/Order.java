package domain;

import java.util.Date;

public class Order {
	   
	private Date timestamp;
	private String itemName;
	
	private String customerId;

	public Order(String customerId,String itemName, Date timestamp) {
	this.timestamp = timestamp;
	this.itemName = itemName;
	this.customerId = customerId;
	}

	    public Date getTimestamp() {
	        return timestamp;
	    }

	    public String getItemId() {
	        return itemName;
	    }

	    public String getCustomerId() {
	        return customerId;
	    }
	
	
}
