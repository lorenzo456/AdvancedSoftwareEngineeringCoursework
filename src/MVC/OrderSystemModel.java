package MVC;

import java.util.ArrayList;
import java.util.Queue;

import domain.Customer;
import domain.CustomerOrderProcessor;
import domain.ShopManager;
import domain.Staff;

public class OrderSystemModel {

    private int simulationSpeed = 5;
    private boolean isInitialized = false;

    private CustomerOrderProcessor processor;
    private ArrayList<Staff> staffMembers;
    private ShopManager shop;

    public OrderSystemModel(CustomerOrderProcessor processor, ShopManager shop) {
        this.processor = processor;
        this.shop = shop;
    }

    public void StartProgram() {
        shop.StartProgram();
    }

    public void OrderOnline() {
        shop.OrderOnline();
    }

    public void SetStaffMembers(ArrayList<Staff> staffMembers) {
        this.staffMembers = staffMembers;
    }

    public Staff AddStaff() {
        return shop.AddStaff();
    }

    public Staff RemoveStaff() {
		Staff temp = staffMembers.remove(staffMembers.size() -1);
		if(temp.GetCurrentCustomer() != null)
		{
			temp.GetCurrentCustomer().setIsBeingServed(false);
		}
        return temp;
    }

    public ArrayList<Staff> GetStaffMembers() {
        return staffMembers;
    }

    public int GetAmountOfCustomersLeftToServe() {
        return processor.AmountOfOrders();
    }


    public Queue<Customer> GetCustomers() {
        return processor.GetQueue();
    }

    public void SetStaffSpeed(int speed) {
        for (Staff staff : staffMembers) {
            staff.setSpeed(speed);
        }
    }

    public int increaseSpeed() {
        if (this.simulationSpeed == 10) {
            return this.simulationSpeed;
        }
        this.simulationSpeed += 1;
        return this.simulationSpeed;
    }

    public int decreaseSpeed() {
        if (this.simulationSpeed == 1) {
            return this.simulationSpeed;
        }
        this.simulationSpeed -= 1;
        return this.simulationSpeed;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized(boolean isInitialized) {
        this.isInitialized = isInitialized;
    }

    public boolean hasStaff() {
        return staffMembers.isEmpty() == false;
    }
}
