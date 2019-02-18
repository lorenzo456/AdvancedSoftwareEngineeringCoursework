package domain;

public class ShopManager {
    private MenuList items;
    private OrderList orders;


    public ShopManager(MenuList items, OrderList orders) {
        this.items = items;
        this.orders = orders;
    }

    public void generateReport(){}
}