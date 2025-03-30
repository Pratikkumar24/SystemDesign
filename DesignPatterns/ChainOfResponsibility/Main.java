package ChainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        Handler a = new A(null);
        Handler b = new B(a);

        // Here the chain of resposibility logic is to print the message in the order of A and B
        b.handleRequest("Test Mesage");

    }
}
