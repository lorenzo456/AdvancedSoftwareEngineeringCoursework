package OrderSystemGUI;

import java.util.LinkedList;
import java.util.Queue;

public class OrderSystemModel 
{
	private int amountOfCustomersLeftToServe;
	private Queue<Integer> customerQueue = new LinkedList<>();
	
	public OrderSystemModel() 
	{
		amountOfCustomersLeftToServe = 0;
	}
	
	public int GetAmountOfCustomersLeftToServe() 
	{
		return amountOfCustomersLeftToServe;
	}

	public String SetCustomerQueueUIText(String NewUIText) 
	{
		return NewUIText;
	}
	
	public void AddCustomerToQueue(Integer customer) 
	{
		customerQueue.add(customer);
		amountOfCustomersLeftToServe++;
	}
	
	public void RemoveCustomerFromQueue() 
	{
		if(customerQueue.peek() != null && amountOfCustomersLeftToServe > 0) 
		{
			customerQueue.remove();
			amountOfCustomersLeftToServe--;
		}else
		{
			System.out.println("NO CUSTOMERS LEFT NOTIFY ORDERSYSTEM");
		}
	}
}
