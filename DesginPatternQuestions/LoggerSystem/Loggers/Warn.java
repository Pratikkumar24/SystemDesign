package LoggerSystem.Loggers;
import LoggerSystem.LogHandler;
import LoggerSystem.LEVEL;

public class Warn extends LogHandler {
    public Warn(LogHandler handler) {
        setHandler(handler); 
        logLevel = LEVEL.WARN;
    }

    public String getMessage(String message) {
        return "[Warn] : "+ message;
    }
}
