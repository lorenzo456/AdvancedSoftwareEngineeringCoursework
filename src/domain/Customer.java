package domain;

import java.util.ArrayList;

public class Customer {
	private boolean isBeingServed;
	private ArrayList OrderedItems;
	
	private String ID;
	
	public Customer(String ID, ArrayList orderedItems) 
	{
		this.ID = ID;
		this.OrderedItems = orderedItems;
	}

	public boolean getIsBeingServed() {
		return isBeingServed;	
	}
	
	public void setIsBeingServed(boolean value) {
		isBeingServed = value;
	}

	public void addOrderedItems(ArrayList orderedItems) 
	{
		this.OrderedItems = orderedItems;
	}

}
