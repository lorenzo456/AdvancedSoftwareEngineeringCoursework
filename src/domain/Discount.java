package domain;

import java.util.ArrayList;

public class Discount 
{
    
    private String name;
    private String description;
    private ArrayList<String> items = new ArrayList<String>();
    
    
	public Discount(String name, String description, String[] items) 
	{
		this.name = name;
		this.description = description;
		
		for(int i = 0; i < items.length; i++) 
		{
			this.items.add(items[i]); 
		}
		
	}
	
	public String GetDescription() 
	{
		return description;
	}
	
	public String GetName() 
	{
		return name;
	}
	/*
	public String[] GetValues() 
	{
		//String[] temp		
	}
	*/
	
	
	
}
