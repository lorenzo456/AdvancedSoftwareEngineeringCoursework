package domain;

import java.util.ArrayList;

public class Customer {
	private boolean isBeingServed;
	private ArrayList<Item> OrderedItems;
	
	private String ID;
	
	public Customer(String ID, ArrayList<Item> orderedItems) 
	{
		this.ID = ID;
		this.OrderedItems = orderedItems;
		isBeingServed = false;
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
	
	public String getID() 
	{
		return ID;
	}
	
	public String GetItemsOrdered() 
	{
		String temp = "";
		for(Item item : OrderedItems) 
		{
			temp += item.getName() + " \n";
		}
		
		return temp;
	}

}
