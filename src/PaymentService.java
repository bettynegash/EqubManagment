import java.util.ArrayList;

public class PaymentService {
    private ArrayList<Payment> payments;
    public PaymentService(){
        payments=new ArrayList<>();
    }
    public void recordPayment(Payment payment){
        if (validatePayment(payment.getAmount())){
            payments.add(payment);
            System.out.println("Payment recorded successfully.");
        }
        else {
            System.out.println("Invalid payment amount.");
        }
    }
    public void viewPayments(){
        for (Payment p:payments){
            System.out.println(p);
        }
    }
    public double calculateContribution(int memberId){
        double total=0;
        for (Payment p:payments){
            if (p.getMemberId()==memberId){
                total+=p.getAmount();
            }
        }
        return total;
    }
    public boolean validatePayment(double amount){
        if (amount>0){
            return true;
        }
        return false;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }
}
