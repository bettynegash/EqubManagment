import java.util.ArrayList;
import java.util.Random;

public class Equb {
    private String equbName;
    private ArrayList<Member> members;
    public Equb(String equbName){
        this.equbName=equbName;
        members=new ArrayList<>();
    }
    public void addMember(Member member){
        members.add(member);
    }
    public void removeMember(int id){
        for (Member m:members){
            if (m.getId()==id){
                members.remove(m);
                break;
            }
        }
    }
    public void showMembers(){
        for (Member m:members){
            System.out.println(m);
        }
    }
    public Member selectWinner(){
        if (members.isEmpty()){
            return null;
        }
        Random random=new Random();
        int index= random.nextInt(members.size());
        Member winner=members.get(index);
        winner.setWinner(true);
        return winner;
    }
    public double calculateTotal(){
        double total=0;
        for (Member m:members){
            total+=m.getTotalContribution();
        }
        return total;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}
