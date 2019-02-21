package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

    

public class Basket {
	private Discount discount = Discount.none;
	private LinkedList<Item> basket = new LinkedList<Item>();
	private MenuList menuList;
	// In this class I should include the elements that I add (items), that I select with GUI. How?
	// We should have a List of all elements (list of all items will be inside BasketList).
	// We should compare then if the items in BasketList are included in DiscountList. 
	// Create a method that meets some specifications for the offers: if it is a hot drink and a dessert, etc. How?
	// Think first about simple discounts: two things from different subclasses. Like in the competitors.
	
	private boolean studentDiscount; 
	private boolean familyDiscount; 
	//two for one drinks
	//
	Basket(MenuList menuList)
	{
		this.menuList = menuList;
	}


	 // HashMap with Key: name of discount, and value: array of ItemCategories to be discounted
   private HashMap<String, String[]> discountList = new HashMap<String, String[]>();
   ArrayList<Discount> discountList0 = new ArrayList<Discount>();
   
   public LinkedList<Item> getBasket() {
	   return basket;
   }

    
    public void AddToBasket(String id, int quantity)
    { 
    	for(int j = 0; j < quantity; j++ ) 
    	{
    		Item temp = menuList.getItemByID(id);
    		basket.add(temp);
		}
	}
    
    public void SetDiscount(Discount newDiscount) 
    {
    	discount = newDiscount;
    }
    
    public void RemoveFromBasketById(String id) 
    {
    	for(int i = 0; i < basket.size(); i ++) 
    	{
    		if(basket.get(i).getId() == id) 
    		{
    			basket.remove();
    			return;
    		}
    	}   	
    	
    }
    
    public void RemoveAllItemsOfId(String id)
    {
    	int check = 1;
    	while(check != 0) 
    	{
    		check = 0;
        	for(int i = 0; i < basket.size(); i ++) 
        	{
        		System.out.println("LOOP ID " + basket.get(i).getId());
        		if(basket.get(i).getId() == id) 
        		{
        			System.out.println("REMOVING " + id);
        			check++;
        			basket.remove(i);
        		}
        	}
        	
    	}  	

    }
    
    public double getTotalCost() {
    	double i = 0;
    	for (Item a : basket) {
    		i = i + a.getCost();
    	}
    	return i;
    }
    
    public double getTotalDiscountedCost() {
    	double i = 0;
    	for (Item a : basket) {
    		i = i + a.getCost();
    	}
    	if(discount == Discount.student) 
    	{
    		i *= 0.8;
    	}else if(discount == Discount.family) 
    	{
    		i *= 0.9;
    	}
    	
    	return i;	
    }
    
    public String DisplayBasket() 
    {
    	String temp = String.format("%s %10s %10s", "Name", "Description", "Price" + "\n");
    	
    	for(Item i : basket) 
    	{
    		temp += String.format("%s %10s %10s %s",i.getName(), i.getDescription(), i.getCost(), " \n");
    	}
    	
    	temp += String.format("%s %10s  %s","Total Cost: ", getTotalCost() + "", " \n");  
    	temp += String.format("%s %10s  %s","Total Cost With Discount: ", getTotalDiscountedCost() + "", " \n"); 

    	return temp;
    }

    
    
    
}
    


