package BuilderDesign;

public class Main {
    public static void main(String[] args) {
        Employee emp = new EmployeeBuilder("pratik", 12).setSalary(1000000L).build();

        System.out.println("Data: "+emp.getData());
    }
}
