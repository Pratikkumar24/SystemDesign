package LoggerSystem.Loggers;
import LoggerSystem.LEVEL;
import LoggerSystem.LogHandler;

public class Debug extends LogHandler {
    public Debug(LogHandler handler) {
        setHandler(handler); 
        logLevel = LEVEL.DEBUG;
    }

    public String getMessage(String message) {
        return "[Debug] : "+ message;
    }
}
