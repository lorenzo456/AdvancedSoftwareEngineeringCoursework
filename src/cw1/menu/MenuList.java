package cw1.menu;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.TreeSet;

import cw1.items.Item;
import cw1.items.ItemCategory;
import cw2.managers.ShopManager;



public class MenuList {
	ShopManager shop;
	public TreeSet<Item> menuList= new TreeSet<Item>();
	
  
    public MenuList(ShopManager shop) {
    	this.shop = shop;
        ReadFromFile("Files/MenuFile.txt");
    } 
    
    public ShopManager GetShop() 
    {
    	return shop;
    }
    
    
    public TreeSet<Item> getListOfItems(){
    	return menuList;
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

            	Item tempItem = new Item(id,name,description,cost,category);
            	menuList.add(tempItem);
            }
        } catch (IOException e) {
            System.out.println("Unable to load file: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unable to create menu item " + e.getMessage());
        }
    }
    

}
