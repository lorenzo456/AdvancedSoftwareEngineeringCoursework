package domain;
import java.util.ArrayList;

public class Discount 
{
    
    private String name;
    private String description;
    private ArrayList<String> items = new ArrayList<String>();
    
	public Discount(String name, String description, String[] items) 
	{
		this.name = name;
		this.description = description;
		
		for(int i = 0; i < items.length; i++) 
		{
			this.items.add(items[i]); 
		}
		
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	
		
	/*public void SuperDuperFriends() {
		if 
		double discount = 0.1;
		double newprize = prize*0.1;
		*/
	
 
		// Some kind of possible discounts?
    
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
    	if (a.getCategory() == ItemCategory.HotDrink && b.getCategory() == ItemCategory.Dessert) {
    		a.setCost(a.getCost()*0.05);
    		b.setCost(b.getCost()*0.05);
    	}
    }
    
    public void LuckyMe() {
    	if (a.getCategory() == ItemCategory.Meal && b.getCategory() == ItemCategory.ColdDrink && 
    			c.getCategory() == ItemCategory.Dessert ) {
    		a.setCost(a.getCost()*0.1);
    		b.setCost(b.getCost()*0.1);
    	}
    }
  
	
	public void BigFamily() {
		if (a.getCategory() == ItemCategory.Meal && b.getCategory() == ItemCategory.ColdDrink && 
    			c.getCategory() == ItemCategory.Dessert && d.getCategory() == ItemCategory.Meal && e.getCategory() == ItemCategory.ColdDrink && 
    			f.getCategory() == ItemCategory.Dessert && g.getCategory() == ItemCategory.Meal && h.getCategory() == ItemCategory.ColdDrink && 
    			i.getCategory() == ItemCategory.Dessert) {
    		a.setCost(a.getCost()*0.15);
    		b.setCost(b.getCost()*0.15);
    		c.setCost(c.getCost()*0.15);
    		d.setCost(d.getCost()*0.15);
    		f.setCost(f.getCost()*0.15);
    		g.setCost(g.getCost()*0.15);
    		h.setCost(h.getCost()*0.15);
    		i.setCost(i.getCost()*0.15);
    	}		
	}
		
	
	
	
}