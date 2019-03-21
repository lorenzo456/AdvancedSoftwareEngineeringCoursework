package cw2.managers;

import java.util.ArrayList;

import cw1.basket.Basket;
import cw1.gui.OrderGUI;
import cw1.menu.MenuList;
import cw2.customers.Customer;
import cw2.customers.CustomerOrderProcessor;
import cw2.mvc.OrderSystemController;
import cw2.mvc.OrderSystemModel;
import cw2.mvc.OrderSystemView;
import cw2.staff.Staff;
import cw2.utils.Logger;

public class ShopManager {

    private OrderSystemModel model;
    private OrderSystemView view;
    private OrderSystemController controller;
    private CustomerOrderProcessor processor;

    private MenuList menuList;
    private Basket basket;
    private ArrayList<Staff> staffMembers;

    private static Logger logger = Logger.getInstance();

    /**
     * This methods creates Threads that will be used in Staff and CustomerOrderProcessor classes
     */
    public void Start() {
        menuList = new MenuList(this);
        basket = new Basket(menuList);

        processor = new CustomerOrderProcessor(menuList);

        model = new OrderSystemModel(processor, this);
        controller = new OrderSystemController(model);
        view = new OrderSystemView(model, controller);

        controller.setView(view);

        Staff staff1 = new Staff(1, processor, view);
        Staff staff2 = new Staff(2, processor, view);
        staffMembers = new ArrayList<Staff>();
        staffMembers.add(staff1);
        staffMembers.add(staff2);

        model.SetStaffMembers(staffMembers);
        view.InitializeView();

        processor.Init(view);
        processor.start();
    }

    /**
     * This method adds costumers to the Queue
     * @param customer
     */
    public void AddToQueue(Customer customer) {
        logger.info(customer.getID() + " has ordered " + customer.GetItemsOrdered());
        processor.AddToQueue(customer);
    }

    /**
     * This methods starts the program for every staff members
     */
    public void StartProgram() {
        for (Staff staff : staffMembers) {
            staff.start();
        }
    }

    /**
     * This method makes Online orders
     */
    public void OrderOnline() {
        new OrderGUI(menuList, basket);
    }

    /**
     * This method creates a staff member and it send it to the model
     * @return the staff created
     */
    public Staff AddStaff() {
        Staff temp = new Staff(System.currentTimeMillis() , processor, view);
        staffMembers.add(temp);
        return temp;
    }
}