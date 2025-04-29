package LoggerSystem.Loggers;
import LoggerSystem.LEVEL;
import LoggerSystem.LogHandler;

public class Trace extends LogHandler {
    public Trace(LogHandler handler) {
        setHandler(handler);    
        logLevel = LEVEL.TRACE;
    }

    public String getMessage(String message) {
        return "[Trace] : "+ message;
    }
}
