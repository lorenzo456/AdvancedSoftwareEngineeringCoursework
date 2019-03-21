package cw2.mvc;

import java.util.ArrayList;
import java.util.Queue;

import cw2.customers.Customer;
import cw2.customers.CustomerOrderProcessor;
import cw2.managers.ShopManager;
import cw2.staff.Staff;

public class OrderSystemModel {

    private int simulationSpeed = 5;
    private boolean isInitialized = false;

    private CustomerOrderProcessor processor;
    private ArrayList<Staff> staffMembers;
    private ShopManager shop;

    /**
     * The constructor of the OrderSystemModel.
     * @param processor needs a CustomerOrderProcessor.
     * @param shop Needs a ShopManager.
     */
    public OrderSystemModel(CustomerOrderProcessor processor, ShopManager shop) {
        this.processor = processor;
        this.shop = shop;
    }

    /**
     * This Method starts the shop simulation.
     */
    public void StartProgram() {
        shop.StartProgram();
    }

    /**
     * This starts the OrderOnline functionality of the shop.
     */
    public void OrderOnline() {
        shop.OrderOnline();
    }
    
    
    /**
     * This sets takes the current staffmembers and holds a reference of them.
     * @param staffMembers Needs a list of staffmembers to keep a reference of.
     */
    public void SetStaffMembers(ArrayList<Staff> staffMembers) {
        this.staffMembers = staffMembers;
    }

    /**
     * @return Returns a staffMember to add to a list.
     */
    public Staff AddStaff() {
        return shop.AddStaff();
    }

    /**
     * Removes a staffmember from the list of staff and 
     * @return returns a reference of the staffmember that needs to be removed
     */
    public Staff RemoveStaff() {
		Staff temp = staffMembers.remove(staffMembers.size() -1);
		if(temp.GetCurrentCustomer() != null)
		{
			temp.GetCurrentCustomer().setIsBeingServed(false);
		}
        return temp;
    }

    /**
     * @return Returns a list of current staffmembers.
     */
    public ArrayList<Staff> GetStaffMembers() {
        return staffMembers;
    }

    /**
     * @return Returns the amount of orders that are left to complete.
     */
    public int GetAmountOfCustomersLeftToServe() {
        return processor.AmountOfOrders();
    }


    /**
     * @return Returns the queue of current customers.
     */
    public Queue<Customer> GetCustomers() {
        return processor.GetQueue();
    }

    /**
     * Sets the speed the staff members will process orders from.
     * @param speed Sets the speed to this value
     */
    public void SetStaffSpeed(int speed) {
        for (Staff staff : staffMembers) {
            staff.setSpeed(speed);
        }
    }

    /**    
     * Increases the speed of the simulation.
     * @return Returns the speed that the simulation should play.
     */
    public int increaseSpeed() {
        if (this.simulationSpeed == 10) {
            return this.simulationSpeed;
        }
        this.simulationSpeed += 1;
        return this.simulationSpeed;
    }

    /**
     * Decreases the speed of the simulation.
     * @return Returns the speed that the simulation shoul play.
     */
    public int decreaseSpeed() {
        if (this.simulationSpeed == 1) {
            return this.simulationSpeed;
        }
        this.simulationSpeed -= 1;
        return this.simulationSpeed;
    }

    /**
     * @return Returns if the OrderSystemModel has been initialised.
     */
    public boolean isInitialized() {
        return isInitialized;
    }

    /**
     * Sets the isInitialized value of the OrderSystemModel.
     * @param isInitialized sets the isInitialized value to this.
     */
    public void setInitialized(boolean isInitialized) {
        this.isInitialized = isInitialized;
    }

    /**
     * @return Returns if the staffMembers list hold any staff members.
     */
    public boolean hasStaff() {
        return staffMembers.isEmpty() == false;
    }
}
