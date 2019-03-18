package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class Logger {
    //private static volatile Logger instance;
    //private static Object mutex = new Object();

	// Singleton pattern, the "instance" of type Logger must be provate and static.
	private static Logger instance; 
	
    private Logger() {
    	
    }

    // why does she creates a mutex object and then syncronizes it?
    /**
     * 
    public static Logger getInstance() {
        Logger result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new Logger();
            }
        }
        return result;
    }
    */
    
    // Singleton pattern 
    
    public static Logger getInstance() {
    	if (instance == null) {
    		instance = new Logger();
    	}
    	return instance;
    }
    
    String logstring = "";
    
    // this methods are used in the CustomerOrderProcessor:  ----- only here?
    
    public void info(String message){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String  a = timestamp + ": INFO: " + message;
        System.out.println(a);
        logstring += a;
    }

    public void warn(String message){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String b = timestamp + ": WARN: " + message;
        System.out.println(b);
        logstring += b;

    }

    public void error(String message){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + ": ERROR: " + message);
    }
    
    public void print(String message){
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	System.out.println(timestamp + "PRINTING: ");
    }
    
    // Methods about: Order 1 is being processes by Staff 1 ??? maybe put them in order processor :) 
    
       
    
    
    public void printFile(String fileName) 
    {
    	try {
    		System.out.println("PRINTED");
			PrintWriter out = new PrintWriter(new FileWriter(fileName));
			out.println(logstring);
			
			/** What do we want to print? 
			 		List of orders?
			 		Queue?
			 		Customer order is being processed by Staff 1?
			 		All of this¿ - Yes  
			 */
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
}
