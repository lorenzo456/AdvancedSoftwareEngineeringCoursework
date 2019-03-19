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
	}
	
	public void UpdatedSystem() 
	{
		orderSystemView.UpdateAllText();
	}
	
}
