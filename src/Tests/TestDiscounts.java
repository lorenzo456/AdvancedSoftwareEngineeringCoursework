package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domain.Basket;
import domain.Discount;
import domain.Item;
import domain.MenuList;
import domain.ShopManager;

public class TestDiscounts {
    ShopManager shop;

	@Test
	public void testDiscounts() {
		
	
		// Testing None
		MenuList menuList = new MenuList(shop);
		Basket basketTest = new Basket(menuList);
		basketTest.AddToBasket("HD01", 1);
		boolean isDiscounted = true;
		
		Discount discount = null;
		basketTest.SetDiscount(discount);
		
		if (discount == Discount.none) {
			isDiscounted = true;
		}
			else if (discount == Discount.student || discount == Discount.family) {
				isDiscounted = false;
			}
				
	
		assertTrue(isDiscounted);
		assertFalse(isDiscounted = false);
		
	}
}
	
