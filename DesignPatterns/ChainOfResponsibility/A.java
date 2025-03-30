package ChainOfResponsibility;

public class A extends Handler {
    public A(Handler handler) {
        setHandler(handler);
    }
    @Override
    void print(String message) {
        System.out.println("A: " + message);
    }
}
