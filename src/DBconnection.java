import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBconnection {

    private static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/equb_db",
            "root",
            "rootai123"
        );
    }

    public static void addMember(int id, String name, String phone) {

        try {
            Connection con = getConnection();

            String sql = "INSERT INTO member (id, name, phone, totalContribution, winner) VALUES (?, ?, ?, 0, false)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, phone);

            ps.executeUpdate();

            System.out.println("Member added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}