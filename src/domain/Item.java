package domain;

public class Item implements Comparable<Item> {
    private String Id;
    private String name;
    private String description;
    private double cost;
    public boolean isDiscounted;

    private ItemCategory category;

    public Item(String id, String name, String description, double cost, ItemCategory category) {
        Id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.category = category;
        isDiscounted = false;
    }

    public int compareTo(Item i) {
        return name.compareTo(i.getName());
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

}	