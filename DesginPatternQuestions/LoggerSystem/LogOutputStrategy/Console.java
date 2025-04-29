package LoggerSystem.LogOutputStrategy;

public class Console implements PrintInterface {
    @Override
    public void printMessage(String message) {
        System.out.println("[Console] " + message);
    }
}
