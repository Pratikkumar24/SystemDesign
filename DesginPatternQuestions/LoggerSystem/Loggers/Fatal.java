package LoggerSystem.Loggers;

import LoggerSystem.LEVEL;
import LoggerSystem.LogHandler;

public class Fatal extends LogHandler {
    public Fatal(LogHandler handler) {
        setHandler(handler);    
        logLevel = LEVEL.FATAL;
    }

    public String getMessage(String message) {
        return "[Fatal] : "+ message;
    }
}