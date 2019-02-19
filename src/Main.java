import domain.Basket;
import domain.MenuList;
import gui.OrderGUI;

public class Main {
    public static void main(String[] args){
    	MenuList menuList = new MenuList();
    	System.out.println(menuList.displayTree());
    	
    	Basket basket = new Basket();
    	basket.AddToBasket(menuList.GetItemByID("HD01"), 1);
    	basket.AddToBasket(menuList.GetItemByID("HD02"), 1);
    	basket.AddToBasket(menuList.GetItemByID("HD01"), 1);
    	basket.AddToBasket(menuList.GetItemByID("HD01"), 1);
    	System.out.println(basket.DisplayBasket());

		OrderGUI orderGui = new OrderGUI(menuList);
    }
}
