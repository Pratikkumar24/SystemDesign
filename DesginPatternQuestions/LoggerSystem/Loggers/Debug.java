package SystemDesign.DesginPatternQuestions.LoggerSystem.Loggers;
import SystemDesign.DesginPatternQuestions.LoggerSystem.LEVEL;
import SystemDesign.DesginPatternQuestions.LoggerSystem.LogHandler;

public class Debug extends LogHandler {
    public Debug(LogHandler handler) {
        setHandler(handler); 
        logLevel = LEVEL.DEBUG;
    }

    public String getMessage(String message) {
        return "[Debug] : "+ message;
    }
}
