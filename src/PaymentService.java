import java.util.ArrayList;

public class PaymentService {
    private ArrayList<Payment> payments;
    public PaymentService(){
        payments=new ArrayList<>();
    }
    public void recordPayment(Payment payment,Member member){
        try{
            validatePayment(payment.getAmount());
            payments.add(payment);
            member.setTotalContribution(member.getTotalContribution()+payment.getAmount());
            System.out.println("Payment recorded successfully.");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
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
    public void validatePayment(double amount){
        if (amount<=0){
            throw new IllegalArgumentException("Payment amount must be greater than zero.");
        }
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }
}
