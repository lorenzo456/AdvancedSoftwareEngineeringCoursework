package OrderSystemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import domain.Customer;

public class OrderSystemView 
{
	private OrderSystemModel orderSystemModel;
	private JFrame frame;
	private JPanel customerUIPanel,staffUIPanel;
	private JTextArea customerQueueUI,staff0UI, staff1UI;
	//private JButton tempAddButton, tempRemoveButton;
	
	public OrderSystemView(OrderSystemModel orderSystemModel) 
	{
		this.orderSystemModel = orderSystemModel;

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
   		
   		customerQueueUI = new JTextArea(25,10);
   	

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
