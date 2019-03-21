package cw1.orders;

public class Order {

    private String timestamp;
    private String itemName;
    private String description;


    public Order(String itemName, String description, String timestamp) {
        this.timestamp = timestamp;
        this.itemName = itemName;
        this.description = description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Order{" +
                "timestamp='" + timestamp + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
