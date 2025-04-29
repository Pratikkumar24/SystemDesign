package LoggerSystem.Loggers;

import LoggerSystem.LEVEL;
import LoggerSystem.LogHandler;

public class Info extends LogHandler {
    public Info(LogHandler handler) {
        setHandler(handler);   
        logLevel = LEVEL.INFO; 
    }

    public String getMessage(String message) {
        return "[Info] : "+ message;
    }
}
