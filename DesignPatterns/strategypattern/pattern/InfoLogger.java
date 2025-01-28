package strategypattern.pattern;

public class InfoLogger implements LoggerInterface {
    @Override
    public void printLog() {
        System.out.println("Info Logger");
    }
}
