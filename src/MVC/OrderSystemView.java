package MVC;
import java.awt.*;
import java.util.HashMap;

import javax.swing.*;

import domain.Customer;
import domain.Staff;


public class OrderSystemView {
    private OrderSystemModel orderSystemModel;
    private OrderSystemController orderSystemController;

    private JFrame frame;
    private JLabel speedLabel;
    private JPanel customerUIPanel, staffUIPanel, speedControlPanel, customerControlPanel;
    private JTextArea customerQueueUI;

    private JButton increaseSpeedButton, descreseSpeedButton, startProgramButton, orderOnlineButton, addStaffButton, removeStaffButton;
    private boolean staffInitialized;
    private HashMap<Staff, JTextArea> staffUIList;

    /**
     * This is the constructor of the OrderSystemView class
     * @param orderSystemModel - it needs the Model (MVC pattern)
     * @param orderSystemController - it needs the Controller (MVC pattern)
     */
    public OrderSystemView(OrderSystemModel orderSystemModel, OrderSystemController orderSystemController) {
        this.orderSystemModel = orderSystemModel;
        this.orderSystemController = orderSystemController;

        this.staffUIList = new HashMap<>();
    }

    /**
     * This method initialises the View
     */
    public void InitializeView() {
        DisplayGui();
        UpdateAllText();
    }

    /**
     * This method is called to display the GUI
     */
    private void DisplayGui() {
        frame = new JFrame("OrderSystem");
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(600, 500));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        GridLayout grid = new GridLayout(2, 1);

        frame.setLayout(grid);


        customerUIPanel = new JPanel();
        customerUIPanel.setLayout(new BorderLayout());

        customerControlPanel = new JPanel();
        customerQueueUI = new JTextArea(30, 30);

        customerControlPanel.add(customerQueueUI);
        

        speedControlPanel = new JPanel();
        

        GridLayout grid2 = new GridLayout(7,0);
        
        speedControlPanel.setLayout(grid2);
        
        speedLabel = new JLabel("5");
        increaseSpeedButton = new JButton("+");
        increaseSpeedButton.addActionListener(orderSystemController);
        descreseSpeedButton = new JButton("-");
        descreseSpeedButton.addActionListener(orderSystemController);
        startProgramButton = new JButton("StartProcessing");
        startProgramButton.addActionListener(orderSystemController);
        orderOnlineButton = new JButton("OrderOnline");
        orderOnlineButton.addActionListener(orderSystemController);
        addStaffButton = new JButton("AddStaff");
        addStaffButton.addActionListener(orderSystemController);
        removeStaffButton = new JButton("RemoveStaff");
        
        removeStaffButton.addActionListener(orderSystemController);
        speedControlPanel.add(removeStaffButton);
        speedControlPanel.add(speedLabel);
        speedControlPanel.add(increaseSpeedButton);
        speedControlPanel.add(descreseSpeedButton);
        speedControlPanel.add(startProgramButton);
        speedControlPanel.add(orderOnlineButton);
        speedControlPanel.add(addStaffButton);
        speedControlPanel.add(removeStaffButton);
      
        

        customerUIPanel.add(customerControlPanel, BorderLayout.WEST);
        customerUIPanel.add(speedControlPanel, BorderLayout.CENTER);

        staffUIPanel = new JPanel();

        frame.add(customerUIPanel);
        frame.add(staffUIPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public void AddInitialStaffUI() {
        for (Staff s : orderSystemModel.GetStaffMembers()) {
            AddStaffUI(s);
        }
        staffInitialized = true;
    }

    public void AddStaffUI(Staff s) {
        JTextArea ui = new JTextArea(25, 20);
        int currentSize = frame.getSize().width;
	   	frame.setPreferredSize(new Dimension(currentSize + 150, 500));
        ui.setBackground(Color.green);
        staffUIList.put(s, ui);
        staffUIPanel.add(ui);
        frame.add(staffUIPanel);
        frame.pack();
        frame.setVisible(true);
        s.SetPanel(ui);
    }

    public void SetStaffUI() {
        for (Staff s : orderSystemModel.GetStaffMembers()) {
        	String label = "Staff" + s.getId() + "\n" ;
            s.GetPanel().setText(label + s.GetCurrentStaffTask());
        }
    }

    /**
     * This methods set the text that will be displayed in the GUI to see the costumers that are waiting to be served
     */
    public void SetCustomerQueueUIText() {
		String summaryText = "Customer queue\n\n";
        summaryText += "There are currently " + orderSystemModel.GetAmountOfCustomersLeftToServe() + " customers waiting on their order" + "\n";
        for (Customer customer : orderSystemModel.GetCustomers()) 
        {
        	String displayText = customer.getID();
        	if (customer.getIsPriorityCustomer() == true) {
        		displayText += " (PRIORITY)"; 
        	}
            summaryText += displayText + " \n";
        }

        customerQueueUI.setText(summaryText);

    }

    /**
     * This methods sets the speed of the text displayed
     * @param speed - it needs to know the new speed 
     */
    public void SetSpeedText(int speed) {
        speedLabel.setText(Integer.toString(speed));
    }


    /**
     * This methods update all the text 
     */
    public void UpdateAllText() {
        SetCustomerQueueUIText();

        if (staffInitialized) {
            SetStaffUI();
        }
    }

    /**
     * This method removes a staff member
     * @param s - it needs to know what staff member it has to remove
     */
    public void RemoveStaffUI(Staff s) {
        JTextArea ui = staffUIList.get(s);
        int currentSize = frame.getSize().width;
	   	frame.setPreferredSize(new Dimension(currentSize - 150, 500));
	   	frame.pack();
        staffUIPanel.remove(ui);
        staffUIPanel.revalidate();
        staffUIPanel.repaint();
    }
}
