abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}

class FullTimeEmployee extends Employee {
    private double bonus;

    FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }
}

interface Department {
    void assignDepartment(String department);
    void getDepartmentDetails();
}

class FullTimeEmployeeWithDept extends FullTimeEmployee implements Department {
    private String department;

    FullTimeEmployeeWithDept(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary, bonus);
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public void getDepartmentDetails() {
        System.out.println("Assigned Department: " + department);
    }
}

class PartTimeEmployeeWithDept extends PartTimeEmployee implements Department {
    private String department;

    PartTimeEmployeeWithDept(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary, hoursWorked, hourlyRate);
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public void getDepartmentDetails() {
        System.out.println("Assigned Department: " + department);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        FullTimeEmployeeWithDept fullTimeEmp = new FullTimeEmployeeWithDept(101, "Alice", 50000, 5000);
        PartTimeEmployeeWithDept partTimeEmp = new PartTimeEmployeeWithDept(102, "Bob", 20000, 120, 15);

        fullTimeEmp.assignDepartment("HR");
        partTimeEmp.assignDepartment("Marketing");

        Employee[] employees = new Employee[2];
        employees[0] = fullTimeEmp;
        employees[1] = partTimeEmp;

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Calculated Salary: $" + emp.calculateSalary());
            if (emp instanceof Department) {
                Department dept = (Department) emp;
                dept.getDepartmentDetails();
            }
            System.out.println();
        }
    }
}
