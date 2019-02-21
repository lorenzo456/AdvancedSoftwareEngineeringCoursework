package Tests;

import domain.*;
import static org.junit.Assert.*;
import org.junit.*;


public class Testing {

	@Test
	public void testAnItem() {
		String expected1 = "HD01";
		String message1 = "Failed, no valid item. Should be HD (Hot Drink) instead of HA";
		//Item(String id, String name, String description, double cost, ItemCategory category, ItemType type)
		Item item1 = new Item ("HA01", null, null, 0, null, null);
		String actual1 = item1.getId();
		assertEquals(message1, expected1, actual1);
		
		String expected2 = "DE01";
		String message2 = "Failed, no valid item. Should be DE (Dessert) followed by two numbers (01, 02, 03, 04)";
		//Item(String id, String name, String description, double cost, ItemCategory category, ItemType type)
		Item item2 = new Item ("DE01", null, null, 0, null, null);
		String actual2 = item2.getId();
		assertEquals(message2, expected2, actual2);
		
		
		
		
	/**	public void testGetDDMMYYYY() {
			 String expected1 = "31/12/2007";
			 String message1 = "Failed for d = 31, m = 12\n";
			 MyDate date1 = new MyDate(31,12,2007);
		     String actual1 = date1.getDDMMYYYY();
			 assertEquals(message1, expected1, actual1);
			 

			 String expected2 = "01/01/2007";
			 String message2 =  "Failed for d = 1, m = 1\n";
			 MyDate date2 = new MyDate(1,1,2007);
		     String actual2 = date2.getDDMMYYYY();
			 assertEquals(message2, expected2, actual2);
		}
		**/
		
	}
}
