package domain;

import java.util.LinkedList;

public class Basket {
    private LinkedList<Item> basket = new LinkedList<Item>();
    
    public Basket() 
    {
    	
    }
    
    public void AddToBasket(Item item, int quantity) 
    {
    	for(int i = 0; i < quantity; i++ ) 
    	{
    		Item tempItem = new Item(item.getId(), item.getName(), item.getDescription(), item.getCost(), item.getCategory(), item.getType());
        	basket.add(tempItem);
    	}
    }
    
    public void RemoveFromBasketById(String id) 
    {
    	for(Item i : basket) 
    	{
    		if(i.getId() == id) 
    		{
    			basket.remove();
    			return;
    		}
    	}
    }
    
    public String DisplayBasket() 
    {
    	String temp = "Items inside Basket: ";
    	for(Item i : basket) 
    	{
    		temp += "Name- " + i.getName() + " Description- " + i.getDescription() + "\n";
    	}
    	return temp;
    }
}
