package ChainOfResponsibility;

public class B extends Handler {
    public B(Handler handler) {
        setHandler(handler);
    }
    @Override
    void print(String message) {
        System.out.println("B: " + message);
    }
    
}
