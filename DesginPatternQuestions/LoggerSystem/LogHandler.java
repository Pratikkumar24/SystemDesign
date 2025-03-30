package SystemDesign.DesginPatternQuestions.LoggerSystem;

import SystemDesign.DesginPatternQuestions.LoggerSystem.LogOutputStrategy.*;

public abstract class LogHandler implements IHandler{
    protected LogHandler handler;
    protected Display display = new Display();
    protected LEVEL logLevel;

    public void setHandler(LogHandler handler) {
        this.handler = handler;
    }
    
    public void setPrintingStrategy(PrintInterface printInterface) {
        display.setStrategy(printInterface);
    }

    public void log(LEVEL level, String message) {
        if(logLevel.ordinal()>=level.ordinal()) {
            display.displayMessage(getMessage(message));    
        }
        if(this.handler!=null) {
            this.handler.log(level, message);
        }
    }
}
