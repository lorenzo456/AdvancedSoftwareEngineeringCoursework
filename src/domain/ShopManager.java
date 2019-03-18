package domain;

import gui.OrderGUI;

public class ShopManager {
    public ShopManager() {
       
    }
    
    public void run() 
    {
    	MenuList menuList = new MenuList();
    	Basket basket = new Basket(menuList);
    	OrderGUI orderGUI = new OrderGUI(menuList, basket);	
    }   
}