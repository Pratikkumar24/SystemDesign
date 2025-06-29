package BuilderDesign;

public class Employee {
    private String name;
    private int empId;
    private String address;
    private Long salary;

    public Employee(EmployeeBuilder builder) {
        this.name = builder.getName();
        this.empId = builder.getEmpId();
        this.address = builder.getAddress();
        this.salary = builder.getSalary();
    }

    public String getData() {
        return name + ", "+empId+", "+((address==null)?"N/A":address)+", "+((salary==null)?"N/A":salary);
    }
}
