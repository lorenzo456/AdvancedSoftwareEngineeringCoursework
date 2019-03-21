package domain;

import java.util.ArrayList;
import java.util.LinkedList;

public class Basket {
	private Discount discount = Discount.none;

	public LinkedList<Item> basket = new LinkedList<Item>();
	public MenuList menuList;
	
	
	public Basket(MenuList menuList) 
	{
		this.menuList = menuList;
	}

   
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
        		if(basket.get(i).getId().equals(id)) 
        		{
        			check++;
        			basket.remove(i);
        		}
        	}
        	
    	}  	

    }
    
    public void RemoveAllItemsFromBasket() 
    {
    	basket.clear();
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
    	
    	return Math.round(i * 100D) / 100D;	
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

    public ArrayList getBasketAsList() 
    {
    	ArrayList<Item> temp = new ArrayList<Item>(basket);

    	return temp;
    }
    
    
}
    


