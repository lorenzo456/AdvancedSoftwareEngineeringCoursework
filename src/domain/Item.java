package domain;

public class Item {
    private String Id;
    private String name;
    private String description;
    private double cost;

    private ItemCategory category;
    private ItemType type;

    public Item(String id, String name, String description, double cost, ItemCategory category, ItemType type) {
        Id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.category = category;
        this.type = type;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public ItemType getType() {
        return type;
    }
}
