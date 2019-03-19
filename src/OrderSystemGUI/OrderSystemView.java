package OrderSystemGUI;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import domain.Customer;

public class OrderSystemView 
{
	private OrderSystemModel orderSystemModel;
	private OrderSystemController orderSystemController;

	private JFrame frame;
	private JLabel speedLabel;
	private JPanel customerUIPanel,staffUIPanel, speedControlPanel, customerControlPanel;
	private JTextArea customerQueueUI,staff0UI, staff1UI;
	private JButton tempAddButton, tempRemoveButton, increaseSpeedButton, descreseSpeedButton;
	
	public OrderSystemView(OrderSystemModel orderSystemModel, OrderSystemController orderSystemController)
	{
		this.orderSystemModel = orderSystemModel;
		this.orderSystemController = orderSystemController;
	}

	public void InitializeView()
	{
		DisplayGui();
		UpdateAllText();
	}
	
	private void DisplayGui() {
   		frame = new JFrame("OrderSystem");
   		frame.setVisible(true);
   		frame.setPreferredSize(new Dimension(800, 500));
   		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  		
   		GridLayout grid = new GridLayout(2,1);
   		
   		frame.setLayout(grid);

   		customerUIPanel = new JPanel();
   		customerUIPanel.setLayout(new BorderLayout());

   		customerControlPanel = new JPanel();
   		customerQueueUI = new JTextArea(25,10);
   		tempAddButton = new JButton("Add Customer");
   		tempRemoveButton = new JButton("Remove Customer");
		customerControlPanel.add(customerQueueUI);
		customerControlPanel.add(tempAddButton);
		customerControlPanel.add(tempRemoveButton);

		speedControlPanel = new JPanel();
		speedLabel = new JLabel("5");
   		increaseSpeedButton = new JButton("+");
   		increaseSpeedButton.addActionListener(orderSystemController);
		descreseSpeedButton = new JButton("-");
		descreseSpeedButton.addActionListener(orderSystemController);
		speedControlPanel.add(speedLabel);
		speedControlPanel.add(increaseSpeedButton);
		speedControlPanel.add(descreseSpeedButton);

		customerUIPanel.add(customerControlPanel, BorderLayout.WEST);
		customerUIPanel.add(speedControlPanel, BorderLayout.EAST);

   		staffUIPanel = new JPanel();
   		staff0UI = new JTextArea(25,20);
   		staff0UI.setBackground(Color.green);

   		staff1UI = new JTextArea(25,20);
   		staff1UI.setBackground(Color.WHITE);
   		
   		staffUIPanel.add(staff0UI);
   		staffUIPanel.add(staff1UI);
		
   		frame.add(customerUIPanel);
   		frame.add(staffUIPanel);
   		frame.pack();
   		frame.setVisible(true);
	}
	
	public void SetCustomerQueueUIText() 
	{
		String summaryText = "There are currently " + orderSystemModel.GetAmountOfCustomersLeftToServe() +" customers waiting on their order" +"\n";
		for(Customer customer : orderSystemModel.GetCustomers()) 
		{
			summaryText += customer.getID() + " \n";
		}
		
		customerQueueUI.setText(summaryText);		
				
	}

	public void SetSpeedText(int speed){
		speedLabel.setText(Integer.toString(speed));
	}

	
	public void SetStaffUI0() 
	{
		String summaryText = "";

		summaryText += orderSystemModel.GetStaffMembers()[0].GetCurrentCustomerID() + " " + orderSystemModel.GetStaffMembers()[0].GetCurrentCustomerItems();	
		
		staff0UI.setText(summaryText);
	}
	
	public void SetStaffUI1() 
	{
		String summaryText = "";

		summaryText += orderSystemModel.GetStaffMembers()[1].GetCurrentCustomerID() + " " + orderSystemModel.GetStaffMembers()[1].GetCurrentCustomerItems();	
		
		staff1UI.setText(summaryText);
	}
	
	public void UpdateAllText() 
	{
		SetCustomerQueueUIText();
		SetStaffUI0();
		SetStaffUI1();
	}
}
