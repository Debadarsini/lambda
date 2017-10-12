package javalambada;

public class Employee {
 

    private int no;
    
    private String name;

    private float salary;
    
    private String department;
    
    
    

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee [no=" + no + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
    }

    public Employee(int no, String name, float salary, String department) {
        super();
        this.no = no;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }
    
    public float getSalary() {
        return salary;
    }

}
