package domain;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;



public class MenuList {

	public TreeSet<Item> menuList= new TreeSet<Item>();
    
	
  
    public MenuList() {
        ReadFromFile("Files/MenuFile.txt");
    }
    

  
    public String displayTree() 
    {
    	String temp = "";
    	for(Item i : menuList) 
    	{
    		temp += i.getName() + " " + i.getDescription() + " " + i.getCost() + "\n";
    	}
    	return temp;
    }
    
    
    
    public TreeSet<Item> getListOfItems(){
    	return menuList;
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
    
    public String getNameOfHotDrinks() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.HotDrink) {
    			temp += i.getName();
    		}
    	}
    	return temp;
    }
    
    public String getDescriptionOfHotDrinks() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.HotDrink) {
    			temp += i.getDescription();
    		}
    	}
    	return temp;
    }
    
    public String getCostOfHotDrinks() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.HotDrink) {
    			temp += i.getCost();
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
    
    public String getNameOfColdDrinks() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.ColdDrink) {
    			temp += i.getName();
    		}
    	}
    	return temp;
    }
    
    public String getDescriptionOfColdDrinks() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.ColdDrink) {
    			temp += i.getDescription();
    		}
    	}
    	return temp;
    }
    
    public String getCostOfColdDrinks() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.ColdDrink) {
    			temp += i.getCost();
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
    
    public String getNameOfMeals() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.Meal) {
    			temp += i.getName();
    		}
    	}
    	return temp;
    }
    
    public String getDescriptionOfMeals() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.Meal) {
    			temp += i.getDescription();
    		}
    	}
    	return temp;
    }
    
    public String getCostOfMeals() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.Meal) {
    			temp += i.getCost();
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
    
    public String getNameOfDesserts() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.Dessert) {
    			temp += i.getName();
    		}
    	}
    	return temp;
    }
    
    public String getDescriptionOfDessert() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.Dessert) {
    			temp += i.getDescription();
    		}
    	}
    	return temp;
    }
    
    public String getCostOfDessert() {
    	String temp = "";
    	for (Item i : menuList) {
    		if (i.getCategory() == ItemCategory.Dessert) {
    			temp += i.getCost();
    		}
    	}
    	return temp;
    }
  
    

    public Item getItemByID(String id) 
    {
    	try {
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
    	}catch(RuntimeException e ) 
    	{
    		System.out.println("Cant find ID: " + e.getMessage());
    	}
    	return null;
    }

    public void ReadFromFile(String fileName) {
    	System.out.println("READING");
    	String separator = ",";

        Path path = FileSystems.getDefault().getPath(fileName);
        try (BufferedReader br = Files.newBufferedReader(path)) {
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
    

}
