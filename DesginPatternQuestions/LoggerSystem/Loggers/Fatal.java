package SystemDesign.DesginPatternQuestions.LoggerSystem.Loggers;

import SystemDesign.DesginPatternQuestions.LoggerSystem.LEVEL;
import SystemDesign.DesginPatternQuestions.LoggerSystem.LogHandler;

public class Fatal extends LogHandler {
    public Fatal(LogHandler handler) {
        setHandler(handler);    
        logLevel = LEVEL.FATAL;
    }

    public String getMessage(String message) {
        return "[Fatal] : "+ message;
    }
}