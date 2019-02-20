package domain;

	import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

import domain.OrderList;
	import domain.ShopManager;
import gui.HotDrinksGUI;
import gui.OrderGUI;
import gui.PaidGUI;


public class Main {
    public static void main(String[] args){
	    	MenuList menuList = new MenuList();
	    	Basket basket = new Basket(menuList);
	    	//basket.AddToBasket("HD01", 2);
	    	//basket.AddToBasket("DE01", 3);
	    	//HotDrinksGUI hd = new HotDrinksGUI(menuList, basket);
	    	OrderGUI og = new OrderGUI(menuList, basket);
	    	System.out.println(basket.getTotalDiscountedCost());	
	    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
	    	   LocalDateTime now = LocalDateTime.now();  
	    	   System.out.println(dtf.format(now));  
	    }
	}

