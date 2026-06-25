public class Payment {
    private int paymentId;
    private int memberId;
    private double amount;
    private String date;

    public Payment() {
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String paymentDate) {
        this.date = date;
    }
}

