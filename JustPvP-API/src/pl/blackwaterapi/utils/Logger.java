package pl.blackwaterapi.utils;

import java.util.logging.Level;

import pl.blackwaterapi.API;

public class Logger
{
    public static void info(String... logs) {
        for (String s : logs) {
            log(Level.INFO, s);
        }
    }
    
    public static void warning(String... logs) {
        for (String s : logs) {
            log(Level.WARNING, s);
        }
    }
    
    public static void severe(String... logs) {
        for (String s : logs) {
            log(Level.SEVERE, s);
        }
    }
    
    public static void log(Level level, String log) {
        API.getPlugin().getLogger().log(level, log);
    }
    
    public static void exception(Throwable cause) {
        cause.printStackTrace();
    }
}
