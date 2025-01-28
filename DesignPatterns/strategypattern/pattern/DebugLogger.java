package strategypattern.pattern;

public class DebugLogger implements LoggerInterface {
    @Override
    public void printLog() {
        System.out.println("DebugLogger");
    }
}
