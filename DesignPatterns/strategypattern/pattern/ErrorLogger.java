package strategypattern.pattern;

public class ErrorLogger implements LoggerInterface {

    @Override
    public void printLog() {
        System.out.println("Error Logger");
    }
    
}
