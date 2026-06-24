public class Payment {
    private int paymentId;
    private int memberId;
    private double amount;
    private String date;

    public Payment() {}

    public Payment(int memberId, double amount, String date) {
        this.memberId = memberId;
        this.amount = amount;
        this.date = date;
    }

    public Payment(int paymentId, int memberId, double amount, String date) {
        this.paymentId = paymentId;
        this.memberId = memberId;
        this.amount = amount;
        this.date = date;
    }

    public int getPaymentId() { return paymentId; }
    public int getMemberId() { return memberId; }
    public double getAmount() { return amount; }
    public String getDate() { return date; } // This completely clears the error in your screenshot!

    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }
    public void setMemberId(int memberId) { this.memberId = memberId; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setDate(String date) { this.date = date; }
}