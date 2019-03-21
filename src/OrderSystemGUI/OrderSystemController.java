package OrderSystemGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Staff;

public class OrderSystemController implements ActionListener
{
	private OrderSystemModel orderSystemModel;
	private OrderSystemView orderSystemView;
	
	public OrderSystemController(OrderSystemModel orderSystemModel)
	{
		this.orderSystemModel = orderSystemModel;
	}
	
	public void UpdatedSystem() 
	{
		orderSystemView.UpdateAllText();
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(actionEvent.getActionCommand().equals("+"))
		{
			int speed = this.orderSystemModel.increaseSpeed();
			this.orderSystemModel.SetStaffSpeed(speed);
			orderSystemView.SetSpeedText(speed);
		}

		if (actionEvent.getActionCommand().equals("-"))
		{
			int speed = this.orderSystemModel.descreaseSpeed();
			this.orderSystemModel.SetStaffSpeed(speed);
			orderSystemView.SetSpeedText(speed);
		}
		
		if(actionEvent.getActionCommand().equals("StartProgram")) 
		{
			orderSystemModel.StartProgram();
			orderSystemView.AddInitialStaffUI();
		}
		
		if(actionEvent.getActionCommand().equals("OrderOnline")) 
		{
			orderSystemModel.OrderOnline();
		}
		
		if(actionEvent.getActionCommand().equals("AddStaff")) 
		{
			Staff temp = orderSystemModel.AddStaff();			
			orderSystemView.AddStaffUI(temp);
			temp.start();
		}
	}

	public void setView(OrderSystemView orderSystemView) {
		this.orderSystemView = orderSystemView;
	}
}
