package SystemDesign.DesginPatternQuestions.LoggerSystem.Loggers;

import SystemDesign.DesginPatternQuestions.LoggerSystem.LEVEL;
import SystemDesign.DesginPatternQuestions.LoggerSystem.LogHandler;

public class Info extends LogHandler {
    public Info(LogHandler handler) {
        setHandler(handler);   
        logLevel = LEVEL.INFO; 
    }

    public String getMessage(String message) {
        return "[Info] : "+ message;
    }
}
