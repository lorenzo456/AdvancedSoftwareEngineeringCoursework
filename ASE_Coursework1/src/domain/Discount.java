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
	
	

	
	public String[] luckyMeDiscount = {"meal", "colddrink", "snack"};
	
	
	public Discount("LuckyMe", "1 meal + 1 cold drink + 1 snack", luckyDiscount);
	
	public String GetDescription() 
	{
		return description;
	}
	
	public String GetName() 
	{
		return name;
	}
	
	/*public void SuperDuperFriends() {
		if 
		double discount = 0.1;
		double newprize = prize*0.1;
		*/
	
 
    
    Item a = new Item ();
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
    			c.getCategory() == ItemCategory.Snack ) {
    		a.setPrize(a.getPrize()*0.1);
    		b.setPrize(b.getPrize()*0.1);
    	}
    }
  
	
	public void BigFamily() {
		if (a.getCategory() == ItemCategory.Meal && b.getCategory() == ItemCategory.ColdDrink && 
    			c.getCategory() == ItemCategory.Snack && d.getCategory() == ItemCategory.Meal && e.getCategory() == ItemCategory.ColdDrink && 
    			f.getCategory() == ItemCategory.Snack && g.getCategory() == ItemCategory.Meal && h.getCategory() == ItemCategory.ColdDrink && 
    			i.getCategory() == ItemCategory.Snack) {
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