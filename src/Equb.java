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
    public void showMembers(){
        for (Member m:members){
            System.out.println(m);
        }
    }
    public void removeMember(int id){
        Member memberToRemove=null;
        for (Member m:members){
            if (m.getId()==id){
                memberToRemove=m;
                break;
            }
        }
        if (memberToRemove!=null){
            members.remove(memberToRemove);
        }
    }

    public Member selectWinner(){
        ArrayList<Member> availableMembers=new ArrayList<>();
        for (Member m:members){
            if (!m.isWinner()){
                availableMembers.add(m);
            }
        }
        if (availableMembers.isEmpty()){
            return null;
        }
        Random random=new Random();
        int index= random.nextInt(availableMembers.size());
        Member winner=availableMembers.get(index);
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
    public void startNewRound(){
        for (Member m:members){
            m.setTotalContribution(0);
            m.setWinner(false);
        }
        System.out.println("New Equb round started.");
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}
