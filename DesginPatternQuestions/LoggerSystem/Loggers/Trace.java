package SystemDesign.DesginPatternQuestions.LoggerSystem.Loggers;
import SystemDesign.DesginPatternQuestions.LoggerSystem.LEVEL;
import SystemDesign.DesginPatternQuestions.LoggerSystem.LogHandler;

public class Trace extends LogHandler {
    public Trace(LogHandler handler) {
        setHandler(handler);    
        logLevel = LEVEL.TRACE;
    }

    public String getMessage(String message) {
        return "[Trace] : "+ message;
    }
}
