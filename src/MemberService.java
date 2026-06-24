import java.util.ArrayList;

public class MemberService {
    private ArrayList<Member> members;

    public MemberService() {
        // Automatically fetch records from DB on startup
        this.members = DBconnection.getMembers();
        if (this.members == null) {
            this.members = new ArrayList<>();
        }
    }

    public Member findMemberById(int id) {
        for (Member m : members) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered yet.");
            return;
        }
        System.out.println("\n========== ALL MEMBERS ==========");
        for (Member m : members) {
            System.out.println(m);
            System.out.println("---------------------------------");
        }
    }

    public void searchMember(int id) {
        Member m = findMemberById(id);
        if (m != null) {
            System.out.println("\n========== MEMBER FOUND ==========");
            System.out.println(m);
        } else {
            System.out.println("❌ Member with ID " + id + " not found.");
        }
    }

    public void updateMember(int id, String newPhone) {
        Member m = findMemberById(id);
        if (m != null) {
            m.setPhone(newPhone);
        } else {
            System.out.println("❌ Member not found.");
        }
    }

    public void deleteMember(int id) {
        Member m = findMemberById(id);
        if (m != null) {
            members.remove(m);
        }
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}