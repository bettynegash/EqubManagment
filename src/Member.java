public class Member extends Person{
    private double totalContribution;
    private boolean winner;
    private double prizeWon;
    private String equbType;
    private String nationalId;
    private String nationality;
    public Member(){
        this.totalContribution=0;
        this.winner=false;
        this.prizeWon=0;
        this.equbType="Student";
        this.nationalId=" ";
        this.nationality="";

    }

    public Member(int id,String name,String phone,double totalContribution,boolean winner,
                  String nationalId,String nationality){
        super(id,name,phone);
        this.totalContribution=totalContribution;
        this.winner=winner;
        this.prizeWon=0;
        this.equbType="Student";
        this.nationalId="";
        this.nationality="";
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEqubType() {
        return equbType;
    }

    public void setEqubType(String equbType) {
        this.equbType = equbType;
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

    public double getPrizeWon() {
        return prizeWon;
    }

    public void setPrizeWon(double prizeWon) {
        this.prizeWon = prizeWon;
    }

    public String toString(){
        return"ID: "+getId()+"\nName: "+getName()
                +"\nPhone: "+getPhone()+
                "\nNational ID: "+nationalId+
                "\nNationality: "+nationality+
                "\nType: "+equbType+
                "\nContribution: "+totalContribution
                +"\nWinner Status: : "+(winner ?"Winner ":"Active Contributor")
                +"\nPrize Won: "+prizeWon+" Birr";
    }
    public void displayRole() {
        System.out.println("Equb Member");
    }
}
