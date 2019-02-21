package Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domain.Basket;
import domain.MenuList;

public class TestBasket {

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
		basketTest2.AddToBasket("HD01", 2);
    	basketTest2.RemoveAllItemsOfId("HD01");
    	if (basketTest2.basket.size() == 0) {
    		isDeleted = true;
    		
    	}
    	
    	assertTrue(isDeleted);
    	assertFalse(isDeleted == false);
	}
}
    	

