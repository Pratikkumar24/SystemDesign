package SystemDesign.DesginPatternQuestions.LoggerSystem.Loggers;
import SystemDesign.DesginPatternQuestions.LoggerSystem.LogHandler;
import SystemDesign.DesginPatternQuestions.LoggerSystem.LEVEL;

public class Warn extends LogHandler {
    public Warn(LogHandler handler) {
        setHandler(handler); 
        logLevel = LEVEL.WARN;
    }

    public String getMessage(String message) {
        return "[Warn] : "+ message;
    }
}
