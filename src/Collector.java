public class Collector extends Person {
    private String employeeId;

    // 1. Default Constructor
    public Collector() {
    }

    // 2. 🆕 OVERLOADED CONSTRUCTOR (Fixes the short initialization from your login/test files)
    public Collector(int id, String name) {
        super(id, name, ""); // Passes id and name to Person, leaves phone empty
        this.employeeId = ""; // Leaves employeeId empty
    }

    // 3. Your Original 4-Parameter Constructor (Keeps your database records working)
    public Collector(int id, String name, String phone, String employeeId) {
        super(id, name, phone);
        this.employeeId = employeeId;
    }

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void collectPayment() {
        System.out.println("Payment collected successfully");
    }

    public void displayRole() {
        System.out.println("Collector");
    }
}