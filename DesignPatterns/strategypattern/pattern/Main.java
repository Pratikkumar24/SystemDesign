package strategypattern.pattern;

public class Main {
    public static void main(String[] args) {
        ErrorLogger errorLogger = new ErrorLogger();
        InfoLogger infoLogger = new InfoLogger();
        DebugLogger debugLogger = new DebugLogger();

        LoggerPicker loggerPicker = new LoggerPicker(errorLogger);
        loggerPicker.printLog();

        loggerPicker = new LoggerPicker(debugLogger);
        loggerPicker.printLog();

        loggerPicker = new LoggerPicker(infoLogger);
        loggerPicker.printLog();
    }
}
