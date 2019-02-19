package domain;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;



public class MenuList {

	private TreeSet<Item> menuList= new TreeSet<Item>();
    private HashMap<String, String[]> discountList = new HashMap<String, String[]>();

    //TODO 
    public MenuList() {
        ReadFromFile("test.txt");
    }

    public void fillDiscountList() 
    {
    	String[] SDFValues = {"ColdDrink", "ColdDrink","ColdDrink"};
    	Discount discount = new Discount("Super duper friends", "choose six cold drinks for this discount",SDFValues );
    	//discountList.put(discount0.GetName(), )
    }
    

    //used to debug what's in the Tree
    public String displayTree() 
    {
    	String temp = "";
    	for(Item i : menuList) 
    	{
    		temp += i.getName() + " " + i.getDescription() + " " + i.getCost() + "\n";
    	}
    	return temp;
    }
    
    public int getNumberOfDesserts() {
    	int i = 0;
    	for (Item a : menuList) {
    		if (a.getCategory() == ItemCategory.Dessert) {	
    			i++;
    		}
    	}
    	return i;
    }
    
    public int getNumberOfMeals() {
    	int i = 0;
    	for (Item a : menuList) {
    		if (a.getCategory() == ItemCategory.Meal) {	
    			i++;
    		}
    	}
    	return i;
    }
    
    public int getNumberOfColdDrinks() {
    	int i = 0;
    	for (Item a : menuList) {
    		if (a.getCategory() == ItemCategory.ColdDrink) {	
    			i++;
    		}
    	}
    	return i;
    }
    
    public int getNumberOfHotDrinks() {
    	int i = 0;
    	for (Item a : menuList) {
    		if (a.getCategory() == ItemCategory.HotDrink) {	
    			i++;
    		}
    	}
    	return i;
    }
    
     
    
    
    public String getHotDrinks() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.HotDrink) {
    			temp += i.getName() + " " + i.getDescription() + " " + i.getCost() + "\n";
    		}
    	}
    	return temp;
    }
    
    public String getColdDrinks() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.ColdDrink) {
    			temp += i.getName() + " " + i.getDescription() + " " + i.getCost() + "\n";
    		}
    	}
    	return temp;
    }
    
    public String getMeals() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.Meal) {
    			temp += i.getName() + " " + i.getDescription() + " " + i.getCost() + "\n";
    		}
    	}
    	return temp;
    }
    
    public String getDessert() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.Dessert) {
    			temp += i.getName() + " " + i.getDescription() + " " + i.getCost() + "\n";
    		}
    	}
    	return temp;
    }
    
    
    
  
    
    

    //TODO add TRY CATCH
    public Item GetItemByID(String id) 
    {
    	//need to add try - check if list not empty else throw error
    	if(!menuList.isEmpty()) 
    	{
	    	for(Item i : menuList) 
	    	{
	    		if(i.getId().equals(id)) 
	    		{
	    			return i;
	    		}
	    	}
    	}
    	//need to catch - comparing id that don't exist in list
    	return null;
    }

    public void ReadFromFile(String fileName) {
    	String separator = ",";

        Path path = FileSystems.getDefault().getPath(fileName);
        System.out.println("The path is: " + path);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            System.out.println("READING FILE");
        	String line = "";

            while ((line = br.readLine()) != null) {
            	if(line.charAt(0) == '/') 
            	{
            	//	skip these lines
            		continue;
            	}            	
            	
                String[] parts = line.split(separator);                
                String id = parts[4].trim();
                String name = parts[0].trim();
                String description = parts[2].trim();
                double cost = Double.parseDouble(parts[1]);
                ItemCategory category = ItemCategory.valueOf(parts[3].trim());
                ItemType type = ItemType.valueOf(parts[5].trim());
                
            	Item tempItem = new Item(id,name,description,cost,category,type);
            	menuList.add(tempItem);
            }
        } catch (IOException e) {
            System.out.println("Unable to load file: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unable to create menu item " + e.getMessage());
        }
    }
    
    //TODO 
    @Override
    public String toString() {
        return "";
    }
	
}
