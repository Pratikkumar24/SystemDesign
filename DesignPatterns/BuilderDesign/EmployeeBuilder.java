package BuilderDesign;

public class EmployeeBuilder {
    private String name;
    private int empId;
    private String address;
    private Long salary;

    public String getName() {
        return name;
    }

    public int getEmpId() {
        return empId;
    }

    public String getAddress() {
        return address;
    }

    public Long getSalary() {
        return salary;
    }

    public EmployeeBuilder(String name, int id) {
        this.name = name;
        this.empId = id;
    }

    public EmployeeBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public EmployeeBuilder setSalary(Long salary) {
        this.salary = salary;
        return this;
    }

    public Employee build() {
        return new Employee(this);
    }
}
