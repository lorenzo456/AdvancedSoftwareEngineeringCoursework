package domain;


import gui.OrderGUI;


public class Main {
    public static void main(String[] args){
	    	MenuList menuList = new MenuList();
	    	Basket basket = new Basket(menuList);
	    	//basket.AddToBasket("HD01", 2);
	    	//basket.AddToBasket("DE01", 3);
	    	//HotDrinksGUI hd = new HotDrinksGUI(menuList, basket, "NAme", "NAMe");
	    	OrderGUI og = new OrderGUI(menuList, basket);

	    }
	}

