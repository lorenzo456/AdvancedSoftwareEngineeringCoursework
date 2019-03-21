package OrderSystemGUI;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import domain.Customer;
import domain.Staff;

public class OrderSystemView 
{
	private OrderSystemModel orderSystemModel;
	private OrderSystemController orderSystemController;

	private JFrame frame;
	private JLabel speedLabel;
	private JPanel customerUIPanel,staffUIPanel, speedControlPanel, customerControlPanel;
	private JTextArea customerQueueUI,staff0UI, staff1UI;

	private JButton increaseSpeedButton, descreseSpeedButton, startProgramButton, orderOnlineButton, addStaffButton;
	private boolean staffInitialized;
	
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
   		frame.setPreferredSize(new Dimension(550, 500));
   		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  		
   		GridLayout grid = new GridLayout(2,1);
   		
   		frame.setLayout(grid);

   		customerUIPanel = new JPanel();
   		customerUIPanel.setLayout(new BorderLayout());

   		customerControlPanel = new JPanel();
   		customerQueueUI = new JTextArea(25,10);
   		
		customerControlPanel.add(customerQueueUI);


		speedControlPanel = new JPanel();
		speedLabel = new JLabel("5");
   		increaseSpeedButton = new JButton("+");
   		increaseSpeedButton.addActionListener(orderSystemController);
		descreseSpeedButton = new JButton("-");
		descreseSpeedButton.addActionListener(orderSystemController);
		startProgramButton = new JButton("StartProgram");
		startProgramButton.addActionListener(orderSystemController);
		orderOnlineButton = new JButton("OrderOnline");
		orderOnlineButton.addActionListener(orderSystemController);
		addStaffButton = new JButton("AddStaff");
		addStaffButton.addActionListener(orderSystemController);
		speedControlPanel.add(speedLabel);
		speedControlPanel.add(increaseSpeedButton);
		speedControlPanel.add(descreseSpeedButton);
		speedControlPanel.add(startProgramButton);
   		speedControlPanel.add(orderOnlineButton);
   		speedControlPanel.add(addStaffButton);
   		customerUIPanel.add(customerQueueUI); 
   		

		customerUIPanel.add(customerControlPanel, BorderLayout.WEST);
		customerUIPanel.add(speedControlPanel, BorderLayout.EAST);

   		staffUIPanel = new JPanel();
   		/*
   		staff0UI = new JTextArea(25,20);
   		staff0UI.setBackground(Color.green);

   		staff1UI = new JTextArea(25,20);
   		staff1UI.setBackground(Color.WHITE);
   		
   		staffUIPanel.add(staff0UI);
   		staffUIPanel.add(staff1UI);
		*/
   		frame.add(customerUIPanel);
   		frame.add(staffUIPanel);
   		frame.pack();
   		frame.setVisible(true);
	}
	
	public void AddInitialStaffUI() 
	{
		for(Staff s : orderSystemModel.GetStaffMembers()) 
		{
			AddStaffUI(s);
		}
		staffInitialized = true;
	} 
	public void AddStaffUI(Staff s) 
	{
	   		JTextArea ui = new JTextArea(25,20);
	   		ui.setBackground(Color.green);
	   		staffUIPanel.add(ui);
	   		frame.add(staffUIPanel);
	   		frame.pack();
	   		frame.setVisible(true);
	   		s.SetPanel(ui);
	}
	
	public void SetStaffUI() 
	{

		for(Staff s : orderSystemModel.GetStaffMembers()) 
		{
			s.GetPanel().setText(s.GetCurrentCustomerTask());
		}		
	}
	
	public void SetCustomerQueueUIText() 
	{
		String summaryText = "Customer queue\n\n";
			summaryText += "There are currently " + orderSystemModel.GetAmountOfCustomersLeftToServe() +" customers waiting on their order" +"\n";
		for(Customer customer : orderSystemModel.GetCustomers()) 
		{
			summaryText += customer.getID() + " " + " \n";
		}
		
		customerQueueUI.setText(summaryText);		
				
	}

	public void SetSpeedText(int speed){
		speedLabel.setText(Integer.toString(speed));
	}

	
	public void UpdateAllText() 
	{
		SetCustomerQueueUIText();
		if(staffInitialized) 
		{
			SetStaffUI();
		}

		//SetStaffUI0();
		//SetStaffUI1();
	}
}
