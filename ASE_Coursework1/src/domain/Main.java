package domain;

	import domain.OrderList;
	import domain.ShopManager;


public class Main {
    public static void main(String[] args){
	    	MenuList menuList = new MenuList();
	    	Basket basket = new Basket();
	    	basket.AddToBasket(menuList.getItemByID("HD01"), 2);
	    	basket.AddToBasket(menuList.getItemByID("DE01"), 3);
	    	
	    	System.out.println(basket.getTotalDiscountedCost());
	    	
	  
	    	
	    	
	    	/**Basket basket = new Basket();
	    	basket.AddToBasket(menuList.GetItemByID("HD01"), 1);
	    	basket.AddToBasket(menuList.GetItemByID("HD02"), 1);
	    	basket.AddToBasket(menuList.GetItemByID("HD01"), 1);
	    	basket.AddToBasket(menuList.GetItemByID("HD01"), 1);
	    	System.out.println(basket.DisplayBasket());**/
	    	
	    }
	}

