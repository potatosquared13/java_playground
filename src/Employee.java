public class Employee {
    private int empID;
    private String empName;
    private String department;

    public Employee(int empID, String empName, String department) {
        this.empID = empID;
        this.empName = empName;
        this.department = department;
    }

    public int getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public String getDepartment() {
        return department;
    }
}
