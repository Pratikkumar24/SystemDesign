package SystemDesign.DesginPatternQuestions.LoggerSystem.Loggers;

import SystemDesign.DesginPatternQuestions.LoggerSystem.LEVEL;
import SystemDesign.DesginPatternQuestions.LoggerSystem.LogHandler;

public class Error extends LogHandler {
    public Error(LogHandler handler) {
        setHandler(handler);    
        logLevel = LEVEL.ERROR;
    }

    public String getMessage(String message) {
        return "[Error] : "+ message;
    }
}
