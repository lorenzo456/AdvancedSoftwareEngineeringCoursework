package OrderSystemGUI;

import java.util.LinkedList;
import java.util.Queue;

import domain.Customer;
import domain.CustomerOrderProcessor;
import domain.Staff;

public class OrderSystemModel 
{
	private int amountOfCustomersLeftToServe;
	private Queue<Integer> customerQueue = new LinkedList<>();
	private CustomerOrderProcessor processor;
	private Staff[] staffMembers;
	
	public OrderSystemModel(CustomerOrderProcessor processor) 
	{
		this.processor = processor;
		//this.staffMembers = staffMembers;
	}
	
	public void SetStaffMembers(Staff[] staffMembers) 
	{
		this.staffMembers = staffMembers;
	}
	
	public Staff[] GetStaffMembers()
	{
		return staffMembers;
	}
	public int GetAmountOfCustomersLeftToServe() 
	{
		return processor.AmountOfOrders();
	}
	
	public Queue<Customer> GetCustomers() 
	{
		return processor.GetQueue();
	}

	public String SetCustomerQueueUIText(String NewUIText) 
	{
		return NewUIText;
	}
}
