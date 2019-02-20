package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

    

public class Basket {
	

	private LinkedList<Item> basket = new LinkedList<Item>();
	
	// In this class I should include the elements that I add (items), that I select with GUI. How?
	// We should have a List of all elements (list of all items will be inside BasketList).
	// We should compare then if the items in BasketList are included in DiscountList. 
	// Create a method that meets some specifications for the offers: if it is a hot drink and a dessert, etc. How?
	// Think first about simple discounts: two things from different subclasses. Like in the competitors.
	


	 // HashMap with Key: name of discount, and value: array of ItemCategories to be discounted
   private HashMap<String, String[]> discountList = new HashMap<String, String[]>();
   
   public void fillDiscountList() {
   	String[] SDFValues = {"ColdDrink", "ColdDrink", "ColdDrink"};
   	Discount SuperDuperFriends = new Discount("Super duper friends", "choose six cold drinks for this discount",SDFValues );
   	
   	String[] BFValues = {"Meal", "Meal", "Meal", "Meal", "ColdDrink", "ColdDrink", "ColdDrink", "Dessert", "Dessert", "Dessert"};
   	Discount BigFamily = new Discount ("Big Family", "Choose 3 meals, 3 cold drinks and 3 desserts for this discount", BFValues);
   	
   	String[] LMValues = {"Meal", "ColdDrink", "Dessert"};
   	Discount LuckyMe = new Discount ("Lucky Me", "Choose a meal, a cold drink and a dessert for this discount", LMValues);
   	
   	String[] SBValues = {"HotDrink", "Dessert"};
   	Discount SweetBreak = new Discount ("SweetBreak", "Choose a Hot Drink and a Dessert to enojy this discount", SBValues);
   	
   	discountList.put(SuperDuperFriends.getName(), SDFValues);
   	discountList.put(BigFamily.getName(), BFValues);
   	discountList.put(LuckyMe.getName(), LMValues);
   	discountList.put(SweetBreak.getName(), SBValues);
   	
   }

	
	public Basket() 
    {
		
		fillDiscountList();
    	
    }
	
	
	TreeSet<Item> menulist;
	
	 public TreeSet<Item> getListOfItems(){
	    	return menulist;
    }
    
    public void AddToBasket(String id, int quantity)
    { 
    	for(int j = 0; j < quantity; j++ ) 
    	{
    		for (Item i : getListOfItems()) {
    			if (i.getId() == id) {
    		Item tempItem = new Item(i.getId(), i.getName(), i.getDescription(), i.getCost(), i.getCategory(), i.getType());
        	basket.add(tempItem);
    	}
    }}}
    
    
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
    		getSuperDuperFriends();
    		getSweetBreak();
    		getLuckyMe();
    		//getBigFamily();
    		i = i + a.getCost();
    	}
    	return i;	
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
    
    
    
    
    // For this discount I just put that the last added is gonna be disocunted. I did not implement the minimum cost... 
    // We will need to change this
    
    public void getSuperDuperFriends() {
    	for (Item a : basket) {
    		
    		if (!a.isDiscounted && a.getCategory() == ItemCategory.ColdDrink) {
    			for (Item b : basket) {
    				if (!b.isDiscounted && b.getCategory() == ItemCategory.ColdDrink) {
    					for (Item c : basket) {
    	    				if (!c.isDiscounted && c.getCategory() == ItemCategory.ColdDrink) {
    	    					for (Item d : basket) {
    	    	    				if (!d.isDiscounted && d.getCategory() == ItemCategory.ColdDrink) {
    	    	    					for (Item e : basket) {
    	    	    	    				if (!e.isDiscounted && e.getCategory() == ItemCategory.ColdDrink) {
    	    	    	    					for (Item f : basket) {
    	    	    	    	    				if (!f.isDiscounted && f.getCategory() == ItemCategory.ColdDrink) {
    	    	    	    	    						f.setCost(f.getCost()*0);
    	    	    	    	    						a.isDiscounted = true;
    	    	    	    	    						b.isDiscounted = true;
    	    	    	    	    						c.isDiscounted = true;
    	    	    	    	    						d.isDiscounted = true;
    	    	    	    	    						e.isDiscounted = true;
    	    	    	    	    						f.isDiscounted = true;
    	    	    	    	    				}
    	    	    	    					}
    	    	    	    				}
    	    	    					}
    	    	    				}
    	    					}
    	    				}
    					}
    				}
    			}
    		}
    	}
    }
    					
    	
	
    public void getSweetBreak() {
    	for (Item a : basket) {
    		if (!a.isDiscounted && a.getCategory() == ItemCategory.HotDrink) {
    			for (Item b : basket) {
    				if (!b.isDiscounted && b.getCategory() == ItemCategory.Dessert) {
    					a.setCost(a.getCost()*0.95);
    					b.setCost(b.getCost()*0.95);
    					a.isDiscounted = true;
    					b.isDiscounted = true;
    		}
    		}
    		}
    	}
    }
    
    public void getLuckyMe() {
    	for (Item a : basket) {
    		if (!a.isDiscounted && a.getCategory() == ItemCategory.Meal) {
    			for (Item b : basket) {
    				if (!b.isDiscounted && b.getCategory() == ItemCategory.ColdDrink) {
    					for (Item c : basket) {
    						if (!c.isDiscounted && c.getCategory() == ItemCategory.Dessert) {
    			    					a.setCost(a.getCost()*0.9);
    			    					b.setCost(b.getCost()*0.9);
    			    					c.setCost(c.getCost()*0.9);
    			    					a.isDiscounted = true;
    			    					b.isDiscounted = true;
    			    					c.isDiscounted = true;
    						}
    					}
    				}
    			}
    		}
    	}
    }
}
    
   /**
    
    public void getBigFamily() {
    	for (HashMap.Entry<String, String[]> discountName : discountList.entrySet()){
    		String key = discountName.getKey();
    	    String[] value = discountName.getValue();
    	    String[] temp = new String[value.length];
    	    boolean applyDiscount = false;
    	    for (String i : value) {
    	    	int counter = 0;
    	    	      	for (Item a : basket) {
      	     	    	if (a.getCategory().name()==i && !a.isDiscounted) {
      	    			temp [counter] = a.getCategory().name();
      	    			counter++;
      	    		}
      	    
      	    	}    	    	
    	    }
    	  for (int j = 0; j< temp.length; j++) {
    		  if (temp[j] == null) {
    			  applyDiscount = false;
    			  return;
    		  }
    		  applyDiscount = true;    	
    	  }
    	if (applyDiscount == true) {
    		
    	
    	}
    		  
    	}
    }
}
      	    		
      	    		
      	    		
      	  /**  		
      	    
    		if (!a.isDiscounted)
    		
    		if (!a.isDiscounted && a.getCategory() == ItemCategory.ColdDrink) {
    			for (Item b : basket) {
    				if (!b.isDiscounted && b.getCategory() == ItemCategory.ColdDrink) {
    					for (Item c : basket) {
    	    				if (!c.isDiscounted && c.getCategory() == ItemCategory.ColdDrink) {
    	    					for (Item d : basket) {
    	    	    				if (!d.isDiscounted && d.getCategory() == ItemCategory.Meal) {
    	    	    					for (Item e : basket) {
    	    	    	    				if (!e.isDiscounted && e.getCategory() == ItemCategory.Meal) {
    	    	    	    					for (Item f : basket) {
    	    	    	    	    				if (!f.isDiscounted && f.getCategory() == ItemCategory.Meal) {
    	    	    	    	    					for (Item g : basket) {
    	    	    	    	    	    				if (!f.isDiscounted && f.getCategory() == ItemCategory.Dessert) {
    	    	    	    	    	    					for (Item h : basket) {
    	    	    	    	    	    	    				if (!f.isDiscounted && f.getCategory() == ItemCategory.Dessert) {
    	    	    	    	    	    	    					for (Item i : basket) {
    	    	    	    	    	    	    	    				if (!f.isDiscounted && f.getCategory() == ItemCategory.Dessert) {
    	    	    	    	    	    	    	    					a.setCost(a.getCost()*0.85);
    	    	    	    	    	    			    					b.setCost(b.getCost()*0.85);
    	    	    	    	    	    			    					c.setCost(c.getCost()*0.85);
    	    	    	    	    	    			    					d.setCost(d.getCost()*0.85);
    	    	    	    	    	    			    					e.setCost(e.getCost()*0.85);
    	    	    	    	    	    	    	    					f.setCost(f.getCost()*0.85);
    	    	    	    	    	    	    	    					g.setCost(g.getCost()*0.85);
    	    	    	    	    	    	    	    					h.setCost(h.getCost()*0.85);
    	    	    	    	    	    	    	    					i.setCost(i.getCost()*0.85);
    	    	        	    	    	    	    						a.isDiscounted = true;
    	    	        	    	    	    	    						b.isDiscounted = true;
    	    	        	    	    	    	    						c.isDiscounted = true;
    	    	        	    	    	    	    						d.isDiscounted = true;
    	    	        	    	    	    	    						e.isDiscounted = true;
    	    	        	    	    	    	    						f.isDiscounted = true;
    	    	        	    	    	    	    						g.isDiscounted = true;
    	    	        	    	    	    	    						h.isDiscounted = true;
    	    	        	    	    	    	    						i.isDiscounted = true;
    	    	    	    	    	    	    	    				}
    	    	    	    	    	    	    					}
    	    	    	    	    	    	    				}
    	    	    	    	    	    					}
    	    	    	    	    	    				}
    	    	    	    	    					}
    	    	    	    	    				}
    	    	    	    					}
    	    	    	    				}
    	    	    					}
    	    	    				}
    	    					}
    	    				}
    					}
    				}
    			}
    		}
    	}
    }
}

	
	**/	
	
	
	
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



