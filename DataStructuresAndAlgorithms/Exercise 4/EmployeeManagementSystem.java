class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId +
               ", Name: " + name +
               ", Position: " + position +
               ", Salary: " + salary;
    }
}

public class EmployeeManagementSystem {

    static Employee[] employees = new Employee[10];
    static int count = 0;

    // Add Employee
    public static void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
            System.out.println("Employee Added Successfully.");
        } else {
            System.out.println("Employee Array is Full.");
        }
    }

    // Search Employee
    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee Found:");
                System.out.println(employees[i]);
                return;
            }
        }
        System.out.println("Employee Not Found.");
    }

    // Traverse Employees
    public static void traverseEmployees() {
        System.out.println("\nEmployee Records:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee
    public static void deleteEmployee(int id) {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee Not Found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee Deleted Successfully.");
    }

    public static void main(String[] args) {

        addEmployee(new Employee(101, "Alice", "Manager", 60000));
        addEmployee(new Employee(102, "Bob", "Developer", 50000));
        addEmployee(new Employee(103, "Charlie", "Tester", 45000));

        traverseEmployees();

        System.out.println("\nSearching Employee:");
        searchEmployee(102);

        System.out.println("\nDeleting Employee:");
        deleteEmployee(102);

        traverseEmployees();
    }
}
