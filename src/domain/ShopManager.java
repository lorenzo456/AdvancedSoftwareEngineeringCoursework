package domain;

import java.util.ArrayList;

import MVC.OrderSystemController;
import MVC.OrderSystemModel;
import MVC.OrderSystemView;
import gui.OrderGUI;
import utils.Logger;

public class ShopManager {

    private OrderSystemModel model;
    private OrderSystemView view;
    private OrderSystemController controller;
    private CustomerOrderProcessor processor;

    private MenuList menuList;
    private Basket basket;
    private ArrayList<Staff> staffMembers;

    private static Logger logger = Logger.getInstance();

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

    public void AddToQueue(Customer customer) {
        logger.info(customer.getID() + " has ordered " + customer.GetItemsOrdered());
        processor.AddToQueue(customer);
    }

    public void StartProgram() {
        for (Staff staff : staffMembers) {
            staff.start();
        }
    }

    public void OrderOnline() {
        new OrderGUI(menuList, basket);
    }

    public Staff AddStaff() {
        Staff temp = new Staff(System.currentTimeMillis() , processor, view);
        staffMembers.add(temp);
        return temp;
    }
}