package domain;

import OrderSystemGUI.*;

public class Main {
 

	public static void main(String[] args){
		  ShopManager shopManager = new ShopManager();
		  shopManager.Start();
    	/*
    	 * 
    	 
    	MenuList menuList = new MenuList(ShopManager);
    	CustomerOrderProcessor processor = new CustomerOrderProcessor(menuList);
    	OrderSystemModel model = new OrderSystemModel(processor);
    	OrderSystemView view = new OrderSystemView(model);
    	OrderSystemController controller = new OrderSystemController(model, view);
    	*/
    } 
}

