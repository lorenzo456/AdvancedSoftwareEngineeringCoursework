package domain;

import java.util.ArrayList;

public class Customer {
	private boolean isBeingServed;
	private boolean isPriorityCustomer;

	private ArrayList<Item> OrderedItems;
	
	private String ID;
	private String Name;
	

	/**
	 * This is the constructor of the Customer class
	 * @param ID This is the customer ID 
	 * @param orderedItems These are the items the customer has ordered through the GUI
	 */
	public Customer(String ID, ArrayList<Item> orderedItems) 
	{
		this.ID = ID;
		this.OrderedItems = orderedItems;
		this.isBeingServed = false;
		this.isPriorityCustomer = false;
	}

	/**
	 * This is the constructor of the Customer class
	 * @param ID This is the customer ID
	 * @param orderedItems These are the items the customer has ordered
	 * @param isPriorityCustomer This boolean determines if the customer is a priority or not
	 */
	public Customer(String ID, ArrayList<Item> orderedItems, boolean isPriorityCustomer)
	{
		this.ID = ID;
		this.OrderedItems = orderedItems;
		this.isPriorityCustomer = isPriorityCustomer;
		this.isBeingServed = false;
	}

	/**
	 * @return returns a if the customer is a priority or not
	 */
	public boolean getIsPriorityCustomer(){
		return isPriorityCustomer;
	}

	/**
	 * @return returns if the customer is currently being served or not
	 */
	public boolean getIsBeingServed() {
		return isBeingServed;	
	}
	
	/**
	 * sets if the customer is currently being served or not.
	 * @param value value of customer being served.
	 */
	public void setIsBeingServed(boolean value) {
		isBeingServed = value;
	}

	/**
	 * @return returns the ID of the customer.
	 */
	public String getID() 
	{
		return ID;
	}
	
	/**
	 * @return returns the name of the customer.
	 */
	public String getName() {
		return Name;
	}
	
	/**
	 * @return returns the orders the customer has placed in a string, each order is separated by a line break
	 */
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
