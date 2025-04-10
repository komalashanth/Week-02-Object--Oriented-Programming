class Employee {
    private final int id;
    private String name;
    private String designation;

    static String companyName = "Tech Solutions";
    static int totalEmployees = 0;

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Alice", "Software Engineer");
        Employee e2 = new Employee(102, "Bob", "Data Analyst");

        e1.displayEmployeeDetails();
        System.out.println();
        e2.displayEmployeeDetails();
        System.out.println();

        Employee.displayTotalEmployees();
    }
}

