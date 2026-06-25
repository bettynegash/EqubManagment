import java.sql.*;
import java.util.ArrayList;

public class DBconnection {
    private static final String URL = "jdbc:mysql://localhost:3306/equb_db"; 
    private static final String USER = "root";
    private static final String PASSWORD = "rootai123"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static ArrayList<Member> getMembers() {
        ArrayList<Member> list = new ArrayList<>();
        String query = "SELECT * FROM members";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Member m = new Member(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getDouble("total_contribution"),
                    rs.getBoolean("winner"),
                    rs.getString("national_id"),  
                    rs.getString("nationality")   
                );
                m.setEqubType(rs.getString("equb_type"));
                m.setPrizeWon(rs.getDouble("prize_won"));
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println("❌ Database Error (getMembers): " + e.getMessage());
        }
        return list;
    }

    public static void addMember(Member member) {
        String query = "INSERT INTO members (id, name, phone, national_id, nationality, equb_type, total_contribution, winner, prize_won) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, member.getId());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getPhone());
            pstmt.setString(4, member.getNationalId());
            pstmt.setString(5, member.getNationality());
            pstmt.setString(6, member.getEqubType());
            pstmt.setDouble(7, member.getTotalContribution());
            pstmt.setBoolean(8, member.isWinner());
            pstmt.setDouble(9, member.getPrizeWon());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("❌ Database Error (addMember): " + e.getMessage());
        }
    }
}