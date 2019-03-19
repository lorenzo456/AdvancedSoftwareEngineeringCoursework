package OrderSystemGUI;

import java.util.LinkedList;
import java.util.Queue;

import domain.Customer;
import domain.CustomerOrderProcessor;
import domain.Staff;

public class OrderSystemModel 
{
	private int amountOfCustomersLeftToServe;
	private int simulationSpeed = 5;

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

	public void SetStaffSpeed(int speed){
		for (Staff staff: staffMembers){
			staff.setSpeed(speed);
		}
	}


	public int increaseSpeed() {
		if(this.simulationSpeed == 10){
			return this.simulationSpeed;
		}
		this.simulationSpeed += 1;
		return this.simulationSpeed;
	}

	public int descreaseSpeed() {
		if(this.simulationSpeed == 1){
			return this.simulationSpeed;
		}
		this.simulationSpeed -= 1;
		return this.simulationSpeed;
	}
}
