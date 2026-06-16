public class Member extends Person{
    private double totalContribution;
    private boolean winner;
    public Member(){

    }
    public Member(int id,String name,String phone,double totalContribution,boolean winner){
        super(id,name,phone);
        this.totalContribution=totalContribution;
        this.winner=winner;
    }

    public double getTotalContribution() {
        return totalContribution;
    }

    public void setTotalContribution(double totalContribution) {
        this.totalContribution = totalContribution;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
    public String toString(){
        return"ID: "+getId()+"\nName: "+getName()
                +"\nPhone: "+getPhone()+"\nContribution: "+totalContribution
                +"\nWinner: "+winner;
    }
}
