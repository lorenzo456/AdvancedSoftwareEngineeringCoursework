package domain;

import java.util.Date;

public class Order {
	   
	private Date timestamp;
	private String itemId;
	private String customerId;

	public Order(String customerId,String itemId, Date timestamp) {
	this.timestamp = timestamp;
	this.itemId = itemId;
	this.customerId = customerId;
	}

	    public Date getTimestamp() {
	        return timestamp;
	    }

	    public String getItemId() {
	        return itemId;
	    }

	    public String getCustomerId() {
	        return customerId;
	    }
	
	
}
