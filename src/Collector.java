public class Collector extends Person{
    private String employeeId;
    public Collector(){

    }
    public Collector(int id,String name,String phone,String employeeId){
        super(id,name,phone);
        this.employeeId=employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public void collectPayment(){
        System.out.println("Payment collected successfully");
    }
    public void displayRole() {
        System.out.println("Collector");
    }
}
