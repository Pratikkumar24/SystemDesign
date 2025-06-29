package ProxyDesign;

public class Main {
    public static void main(String[] args) {
        EmployeeProxy proxy = new EmployeeProxy();

        proxy.createUser("pratik");
        proxy.createUser("Rahul");
        proxy.createUser("pratikd");
        proxy.createUser("pratik");
        proxy.createUser("rahul");
        
        proxy.seeTable("pratik");
        proxy.seeTable("pratikd");
    }
}
