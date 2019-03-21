package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class Logger {
    private static volatile Logger instance;
    private static Object mutex = new Object();
    private boolean printed;
    String logstring = "";

    /**
     * Sets printed to false;
     */
    private Logger() {
        printed = false;
    }

    
    /**
     * Constructor of the logger class. Creates a new singleton instance of logger only if there is no other active logger.
     * @return returns the logger singleton.
     */
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


    /**
     * Adds messages passed to it to a string in the logger.
     * @param message Is the message passed to the logger.
     */
    public void info(String message) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String a = timestamp + ": INFO: " + message + "\n";
        System.out.println(a);
        logstring += a;
    }
    

    /**
     * @return Returns if the logger has already printed the log. This method can only be accessed by one thread at at time.
     */
    public synchronized boolean print() {
        if (!printed) {
            printed = true;
            return true;
        }
        return false;
    }

    /**
     * Prints the messages stored in the log to the Log file.
     */
    public void printFile() {
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
