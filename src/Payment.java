public class Payment {
    private int paymentId;
    private int memberId;
    private double amount;
    private String paymentDate;
    public Payment(){}
    public Payment(int paymentId,int memberId,double amount,String paymentDate){
        this.paymentId=paymentId;
        this.memberId=memberId;
        this.amount=amount;
        this.paymentDate=paymentDate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
    public String toString(){
        return "Payment ID: "+paymentId+
                "\nMember ID: "+memberId+
                "\nAmount: "+amount+
                "\nDate: "+paymentDate;
    }
}
