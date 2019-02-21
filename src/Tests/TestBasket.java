package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Basket;
import domain.Item;
import domain.MenuList;

public class TestBasket {
	
	 /** public void AddToBasket(String id, int quantity)
	    { 
	    	for(int j = 0; j < quantity; j++ ) 
	    	{
	    		Item temp = menuList.getItemByID(id);
	    		basket.add(temp);
			}
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
	    	
	    	
	    }**/

	/// we can test the delete. adding. discounts.
	
	private Basket basketTest;
	
	@Before
	public void setUp() {
		MenuList menuList = new MenuList();
		basketTest = new Basket(menuList);
		basketTest.AddToBasket("HD01", 2);
    	basketTest.AddToBasket("DE01", 3);
    	
	}
	
	//not strictly necessary since setUp starts a new BasketList
	@After
	public void tearDown() {
		MenuList menuList = new MenuList();
		basketTest = new Basket(menuList);
	}
	
	//Count - if zero, assert true.
	
	
	@Test
	public void testAdding() {
		MenuList menuList = new MenuList();
		Basket basketTest1 = new Basket(menuList);
		basketTest1.AddToBasket("HD01", 1);
    	boolean isAdded = false;
    	
    	if (basketTest1.basket.size() != 0) {
    		isAdded = true;
    		
    	}
    	
    	assertTrue(isAdded);
    	assertFalse(isAdded == false);
	}
	
	
	@Test
	public void testDeleting() {
		MenuList menuList = new MenuList();
		Basket basketTest2 = new Basket(menuList);
		boolean isDeleted = false;
		basketTest2.AddToBasket("DE01", 2);
    	basketTest2.RemoveAllItemsOfId("DE01");
    	    	System.out.println(basketTest2.basket.size());
    	if (basketTest2.basket.size() == 0) {
    		isDeleted = true;
    		
    	}
    	
    	assertTrue(isDeleted);
    	assertFalse(isDeleted == false);
	}

	
	
	
}
    	
    	/**
  
		//what was found is what was searched for
		MyDate foundDate = dateList.find("31/01/2009");
		assertTrue (foundDate.equals(new MyDate(31,1,2009)));
		
		//maybe also search limits - for first and last item
		
	@Test
	public void testDeleting() {
		
		//this one should not be found
				assertEquals (null, null, dateList.find("31/04/2014"));
				
				//what was found is what was searched for
				MyDate foundDate = dateList.find("31/01/2009");
				assertTrue (foundDate.equals(new MyDate(31,1,2009)));
				
				//maybe also search limits - for first and last item
				
	}
	
		
	} **/

