package domain;

import java.util.LinkedList;

    

public class Basket {
	

	private LinkedList<Item> basket = new LinkedList<Item>();
	
	// In this class I should include the elements that I add (items), that I select with GUI. How?
	// We should have a List of all elements (list of all items will be inside BasketList).
	// We should compare then if the items in BasketList are included in DiscountList. 
	// Create a method that meets some specifications for the offers: if it is a hot drink and a dessert, etc. How?
	// Think first about simple discounts: two things from different subclasses. Like in the competitors.
	
	
	
	public void getDiscount() {
		for (Item a : basket)
			if (a.getIsDiscounted() == 1) {
				
			}
	}
	
	public maybeDiscount() {
		for (int i = 0; i<4;) {
			if (item a.getCategory() == )
		}
	}
	
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
    
  
    
    
    Item a;
	Item b;
	Item c;
	Item d;
	Item e;
	Item f;
	Item g;
	Item h;
	Item i;
	
    public void SweetBreak() {
    	if (a.getCategory() == ItemCategory.HotDrink && b.getCategory() == ItemCategory.Pastry) {
    		a.setPrize(a.getPrize()*0.05);
    		b.setPrize(b.getPrize()*0.05);
    	}
    }
    
    public void LuckyMe() {
    	if (a.getCategory() == ItemCategory.Meal && b.getCategory() == ItemCategory.ColdDrink && 
    			c.getCategory() == ItemCategory.Dessert ) {
    		a.setPrize(a.getPrize()*0.1);
    		b.setPrize(b.getPrize()*0.1);
    	}
    }
  
	
	public void BigFamily() {
		if (a.getCategory() == ItemCategory.Meal && b.getCategory() == ItemCategory.ColdDrink && 
    			c.getCategory() == ItemCategory.Dessert && d.getCategory() == ItemCategory.Meal && e.getCategory() == ItemCategory.ColdDrink && 
    			f.getCategory() == ItemCategory.Dessert && g.getCategory() == ItemCategory.Meal && h.getCategory() == ItemCategory.ColdDrink && 
    			i.getCategory() == ItemCategory.Dessert) {
    		a.setPrize(a.getPrize()*0.15);
    		b.setPrize(b.getPrize()*0.15);
    		c.setPrize(c.getPrize()*0.15);
    		d.setPrize(d.getPrize()*0.15);
    		f.setPrize(f.getPrize()*0.15);
    		g.setPrize(g.getPrize()*0.15);
    		h.setPrize(h.getPrize()*0.15);
    		i.setPrize(i.getPrize()*0.15);
    	}		
	}
			
	
	
}
	
	/*public Basket (String name, int number) {
		this.name = name;
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getTotalPrize() {
		//return total value of all items in basket
		return prize;
	}
	
	public int getDiscountedPrize() {
		return discountedPrize;
		// return the total discounted prize. Write a method for this
	}
	
	
	
	
	/**
	 *  Question. Do we want a separate class for comparing? Like in the competitors in last semester?
	 *  
	 *  We could compare Items. If items from this list comparable items from this other list - set prize to prize in DiscountList 
	 *  and print it out???? 
	 *  About printing, it depends on the method we want to see. Bothe have to be. Both values to use.
	 *  
	 *  import java.util.Comparator;
//defines an ordering on Staff objects on the name

public class CompetitorComparator implements Comparator<Competitor> {


	public int compare(Item i1, item i2) {
			return i1.getName().compareTo(i2.getName());
		}

}
	 */
	
	/**
	 *  Another question is, the method for printing the checkout goes here?º
	 */



