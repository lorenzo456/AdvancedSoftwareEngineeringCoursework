package OrderSystemGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	}

	public void setView(OrderSystemView orderSystemView) {
		this.orderSystemView = orderSystemView;
	}
}
