package ChainOfResponsibility;

abstract class Handler {
    Handler handler;
    
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    void handleRequest(String message) {
        print(message);
        if (handler != null) {
            handler.handleRequest(message);
        }
    }
    abstract void print(String message);
}
