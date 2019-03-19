2package OrderSystemGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OrderSystemView 
{
	private OrderSystemModel orderSystemModel;
	private JFrame frame;
	private JPanel customerUIPanel,staffUIPanel;
	private JTextArea customerQueueUI,staff0UIPanel, staff1UIPanel;
	private JButton tempAddButton, tempRemoveButton;
	
	public OrderSystemView(OrderSystemModel orderSystemModel) 
	{
		this.orderSystemModel = orderSystemModel;
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
   		tempAddButton = new JButton("Add Customer");
   		tempRemoveButton = new JButton("Remove Customer");
   		customerUIPanel.add(customerQueueUI); 
   		customerUIPanel.add(tempAddButton);
   		customerUIPanel.add(tempRemoveButton);


   		staffUIPanel = new JPanel();
   		staff0UIPanel = new JTextArea(25,20);
   		staff0UIPanel.setBackground(Color.green);

   		staff1UIPanel = new JTextArea(25,20);
   		staff1UIPanel.setBackground(Color.blue);
   		staffUIPanel.add(staff0UIPanel);
   		staffUIPanel.add(staff1UIPanel);
		
   		frame.add(customerUIPanel);
   		frame.add(staffUIPanel);
   		frame.pack();
   		frame.setVisible(true);
	}
	
	public void AddCustomerButton(ActionListener actionListener) 
	{
		tempAddButton.addActionListener(actionListener);
	}
	
	public void RemoveCustomerButton(ActionListener actionListener) 
	{
		tempRemoveButton.addActionListener(actionListener);
	}
	
	public void SetCustomerQueueUIText() 
	{
		String summaryText = "There are currently " + orderSystemModel.GetAmountOfCustomersLeftToServe() +" customers waiting on their order";
		customerQueueUI.setText(summaryText);		
		
		//TODO get customer Class and display name + amount of Items  in Customer QueueUI
	}
	
	public void UpdateAllText() 
	{
		SetCustomerQueueUIText();
	}
}
