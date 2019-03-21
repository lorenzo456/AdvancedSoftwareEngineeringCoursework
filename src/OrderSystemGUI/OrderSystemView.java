package OrderSystemGUI;

import java.awt.*;
import java.awt.event.ActionListener;
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

    public OrderSystemView(OrderSystemModel orderSystemModel, OrderSystemController orderSystemController) {
        this.orderSystemModel = orderSystemModel;
        this.orderSystemController = orderSystemController;

        this.staffUIList = new HashMap<>();
    }

    public void InitializeView() {
        DisplayGui();
        UpdateAllText();
    }

    private void DisplayGui() {
        frame = new JFrame("OrderSystem");
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(800, 500));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        GridLayout grid = new GridLayout(2, 1);

        frame.setLayout(grid);

        customerUIPanel = new JPanel();
        customerUIPanel.setLayout(new BorderLayout());

        customerControlPanel = new JPanel();
        customerQueueUI = new JTextArea(25, 10);

        customerControlPanel.add(customerQueueUI);


        speedControlPanel = new JPanel();
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
        customerUIPanel.add(customerQueueUI);


        customerUIPanel.add(customerControlPanel, BorderLayout.WEST);
        customerUIPanel.add(speedControlPanel, BorderLayout.EAST);

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
            s.GetPanel().setText(s.GetCurrentCustomerTask());
        }
    }

    public void SetCustomerQueueUIText() {
        String summaryText = "There are currently " + orderSystemModel.GetAmountOfCustomersLeftToServe() + " customers waiting on their order" + "\n";
        for (Customer customer : orderSystemModel.GetCustomers()) {
            summaryText += customer.getID() + " \n";
        }

        customerQueueUI.setText(summaryText);

    }

    public void SetSpeedText(int speed) {
        speedLabel.setText(Integer.toString(speed));
    }


    public void UpdateAllText() {
        SetCustomerQueueUIText();

        if (staffInitialized) {
            SetStaffUI();
        }
    }

    public void RemoveStaffUI(Staff s) {
        JTextArea ui = staffUIList.get(s);
        staffUIPanel.remove(ui);
        staffUIPanel.revalidate();
        staffUIPanel.repaint();
    }
}
