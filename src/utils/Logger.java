package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class Logger {
    private static volatile Logger instance;
    private static Object mutex = new Object();
    private boolean printed;
	// Singleton pattern, the "instance" of type Logger must be provate and static.
	
	
    private Logger() {
    	printed = false;
    }
    
    public boolean GetIsPrinted() 
    {
    	return printed;
    }
    // Protecting the Logger method by using syncronization as we are implementing this method in threads.
   
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
   
    
    // Singleton pattern 
    /**
     * 
     * 
     
    public static Logger getInstance() {
    	if (instance == null) {
    		instance = new Logger();
    	}
    	return instance;
    }
    */
    
    String logstring = "";
    
    // this methods are used in the CustomerOrderProcessor:  ----- only here?
    
    public void info(String message){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String  a = timestamp + ": INFO: " + message + "\n";
        System.out.println(a);
        logstring += a;
    }

    public void warn(String message){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String b = timestamp + ": WARN: " + message;
        System.out.println(b);
        //logstring += b; we do not need this mesage, only info.

    }

    public void error(String message){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + ": ERROR: " + message);
    }
    
    public synchronized void print(String message){
    if(!printed) 
    {
    	printed = true;
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	System.out.println(timestamp + "PRINTING: ");
    }
    }
    
    // Methods about: Order 1 is being processes by Staff 1 ??? maybe put them in order processor :) 
    
       
    
    
    public void printFile() 
    {
    	try {
    		System.out.println("PRINTED");
			PrintWriter out = new PrintWriter(new FileWriter("Files/LoggerFile.txt"));
			out.println(logstring);			
			out.close();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
}
