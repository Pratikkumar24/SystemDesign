package ProxyDesign;

public class EmployeeImpl implements Employee{

    @Override
    public void createUser(String name) {
        System.out.println("User name is created");
    }

    @Override
    public void seeTable(String userName) {
        System.out.println("This is your table");
    }
    
}
