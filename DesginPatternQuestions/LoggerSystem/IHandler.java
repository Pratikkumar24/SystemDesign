package SystemDesign.DesginPatternQuestions.LoggerSystem;

import SystemDesign.DesginPatternQuestions.LoggerSystem.LogOutputStrategy.PrintInterface;

interface IHandler {
    void setHandler(LogHandler handler);
    void log(LEVEL level, String message);
    String getMessage(String message);
    void setPrintingStrategy(PrintInterface printInterface);
}
