package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Basket;
import domain.Item;

public class TestBasket {

	
	/// we can test the delete. adding. discounts.
	
	private Basket basketTest;
	
	/**@Before
	public void setUp() {
		basketTest = new BasketTest();
		addBasket.add(new Basket(31,12,2009));
		dateList.add(new MyDate(31,1,2009));
		dateList.add(new MyDate(30,12,2009));
		dateList.add(new MyDate(31,12,2004));
	}
	
	//not strictly necessary since setUp starts a new list
	@After
	public void tearDown() {
		basketTest = new Basket();
	}
	
	@Test
	public void testFind() {
		//this one should not be found
		assertEquals (null, null, basketTest.getItemByID("AB06"));
		
		//what was found is what was searched for
		MyDate foundDate = dateList.find("31/01/2009");
		assertTrue (foundDate.equals(new MyDate(31,1,2009)));
		
		//maybe also search limits - for first and last item
		
	} **/
}
