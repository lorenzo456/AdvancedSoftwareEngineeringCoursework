package domain;

	import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import domain.OrderList;
	import domain.ShopManager;


public class Main {
    public static void main(String[] args){
	    	MenuList menuList = new MenuList();
	    	Basket basket = new Basket();
	    	basket.AddToBasket(menuList.getItemByID("HD01"), 2);
	    	basket.AddToBasket(menuList.getItemByID("DE01"), 3);
	    	
	    	System.out.println(basket.getTotalDiscountedCost());	
	    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
	    	   LocalDateTime now = LocalDateTime.now();  
	    	   System.out.println(dtf.format(now));  
	    }
	}

