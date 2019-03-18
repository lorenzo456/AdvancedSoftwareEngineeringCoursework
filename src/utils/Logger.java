package utils;

import java.sql.Timestamp;

public class Logger {
    private static volatile Logger instance;
    private static Object mutex = new Object();

    private Logger() {}

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

    public void info(String message){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + ": INFO: " + message);
    }

    public void warn(String message){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + ": WARN: " + message);

    }

    public void error(String message){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp + ": ERROR: " + message);
    }
}
