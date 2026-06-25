import java.util.ArrayList;

public class PaymentService {
    private ArrayList<Payment> payments;
    public PaymentService(){
        this.payments=new ArrayList<>();
    }
    public void recordPayment(Payment payment,Member member){
        payments.add(payment);
        double currentContribution=member.getTotalContribution();
        member.setTotalContribution(currentContribution+payment.getAmount());


    }
    public void viewPayments(){
       if (payments.isEmpty()){
           System.out.println("No payments recorded yet.");
           return;
       }
        System.out.println("\n==========PAYMENT LOGS============");
       for (Payment p:payments){
           System.out.println("Paymrnt ID: "+p.getPaymentId()+
                   "|Member ID: "+p.getMemberId()
           +"|Amount: "+p.getAmount()+" Birr"+"|Date: "+p.getDate());
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

}
