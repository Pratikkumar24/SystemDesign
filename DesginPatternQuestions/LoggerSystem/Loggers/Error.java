package LoggerSystem.Loggers;

import LoggerSystem.LEVEL;
import LoggerSystem.LogHandler;

public class Error extends LogHandler {
    public Error(LogHandler handler) {
        setHandler(handler);    
        logLevel = LEVEL.ERROR;
    }

    public String getMessage(String message) {
        return "[Error] : "+ message;
    }
}
