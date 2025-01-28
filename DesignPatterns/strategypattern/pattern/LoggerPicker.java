package strategypattern.pattern;

public class LoggerPicker {
    LoggerInterface loggerInterface;
    LoggerPicker(LoggerInterface obj) {
        this.loggerInterface = obj;
    }

    public void changeLogger(LoggerInterface obj) {
        this.loggerInterface = obj;
    }
    public void printLog() {
        loggerInterface.printLog();
    }
}
