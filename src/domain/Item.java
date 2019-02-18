package domain;

public class Item implements Comparable <Item> {
    private String Id;
    private String name;
    private String description;
    private double cost;
    public boolean isDiscounted;

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
    
    
    
    public boolean getIsDiscounted() 
    {
    	return isDiscounted;
    }
    
    public void setIsDiscounted(boolean value) 
    {
    	isDiscounted = value;
    }
    
    public int compareTo(Item i) 
    {
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

    // changed cost for prize 
    public double getCost() {
        return cost;
    }
    
    public void setCost(double newcost) {
    	cost = newcost;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public ItemType getType() {
        return type;
    }
}	