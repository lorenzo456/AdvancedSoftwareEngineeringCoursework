package OrderSystemGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderSystemController 
{
	private OrderSystemModel orderSystemModel;
	private OrderSystemView orderSystemView;
	
	public OrderSystemController(OrderSystemModel orderSystemModel, OrderSystemView orderSystemView) 
	{
		this.orderSystemModel = orderSystemModel;
		this.orderSystemView = orderSystemView;
		
		orderSystemView.AddCustomerButton(new SetListener("AddCustomer"));
		orderSystemView.RemoveCustomerButton(new SetListener("RemoveCustomer"));
	}

	public class SetListener implements ActionListener {
			String button;
			public SetListener(String button) 
			{
				this.button = button;
			}
			public void actionPerformed(ActionEvent e) 
			{
				if(button == "AddCustomer") 
				{
					orderSystemModel.AddCustomerToQueue(1);
				}else if(button == "RemoveCustomer") 
				{
					orderSystemModel.RemoveCustomerFromQueue();
				}
				orderSystemView.UpdateAllText();

			}
		} 
}
