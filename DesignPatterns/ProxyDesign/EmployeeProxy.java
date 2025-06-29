package ProxyDesign;

import java.util.Set;
import java.util.TreeSet;

public class EmployeeProxy implements Employee{

    EmployeeImpl employee;
    Set<String> bannedUser;

    EmployeeProxy() {
        bannedUser = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        bannedUser.add("Pratik");
        bannedUser.add("Rahul");
    }

    @Override
    public void createUser(String name) {
        if (bannedUser.contains(name)) {
            System.out.println("This user is banned");
            return;
        }

        if (employee == null) { 
            employee = new EmployeeImpl();
        }
        employee.createUser(name);  
    }

    @Override
    public void seeTable(String userName) {
         if (bannedUser.contains(userName)) {
            System.out.println("This user is banned");
            return;
        }

        if (employee == null) { 
            employee = new EmployeeImpl();
        }
        employee.seeTable(userName); 
    }
    
}
