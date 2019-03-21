package domain;

import java.util.ArrayList;

public class Customer {
	private boolean isBeingServed;
	private boolean isPriorityCustomer;

	private ArrayList<Item> OrderedItems;
	
	private String ID;
	private String Name;
	
	public Customer(String ID, ArrayList<Item> orderedItems) 
	{
		this.ID = ID;
		this.OrderedItems = orderedItems;
		this.isBeingServed = false;
		this.isPriorityCustomer = false;
	}

	public Customer(String ID, ArrayList<Item> orderedItems, boolean isPriorityCustomer)
	{
		this.ID = ID;
		this.OrderedItems = orderedItems;
		this.isPriorityCustomer = isPriorityCustomer;
		this.isBeingServed = false;
	}

	public boolean getIsPriorityCustomer(){
		return isPriorityCustomer;
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
	
	public String getName() {
		return Name;
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
