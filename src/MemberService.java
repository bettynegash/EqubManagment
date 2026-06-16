import java.util.ArrayList;

public class MemberService {
    private ArrayList<Member> membersList;
    public MemberService(){
        membersList=new ArrayList<>();
    }
    public void addMember(Member member){
        membersList.add(member);
    }
    public void deleteMember(int id){
        Member member=findMemberById(id);
        if (member!=null){
            membersList.remove(member);
        }
    }
    public Member findMemberById(int id){
        for (Member m:membersList){
            if (m.getId()==id){
                return m;
            }
        }
        return null;
    }
    public void updateMember(int id,String newPhone){
        Member member=findMemberById(id);
        if (member!=null){
            member.setPhone(newPhone);
        }
    }
    public void searchMember(int id){
        Member member=findMemberById(id);
        if (member!=null){
            System.out.println(member);
        }
        else {
            System.out.println("Member not found.");
        }
    }
    public void viewMembers(){
        for (Member m:membersList){
            System.out.println(m);
        }
    }

    public ArrayList<Member> getMembersList() {
        return membersList;
    }
}
