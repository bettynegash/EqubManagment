import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBconnection {

    // 1. Database Credentials (Your Connection Keys)
    private static final String URL = "jdbc:mysql://localhost:3306/equb_db";
    private static final String USER = "root";
    private static final String PASSWORD = "rootai123";

    // 2. The Connection Tunnel Gateway
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 3. ACTION: Add a New Member to the Database
    public static void addMember(Member member) {
        String sql = "INSERT INTO member (id, name, phone, totalContribution, winner) VALUES (?, ?, ?, ?, ?)";

        try (
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            // Pulling data safely out of the Member object blueprint
            ps.setInt(1, member.getId());
            ps.setString(2, member.getName());
            ps.setString(3, member.getPhone());
            ps.setDouble(4, member.getTotalContribution());
            ps.setBoolean(5, member.isWinner());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("\n>>> Member added successfully to MySQL! <<<");
            }
        } catch (Exception e) {
            System.out.println("Error while inserting member:");
            e.printStackTrace();
        }
    }

    // 4. ACTION: View All Members Saved in MySQL
    public static void viewAllMembers() {
        String sql = "SELECT * FROM member";

        try (
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            // ResultSet is a special virtual table that holds the rows sent back by MySQL
            ResultSet rs = ps.executeQuery()
        ) {
            System.out.println("\n=================== ALL EQUB MEMBERS ===================");
            
            // loop through every single row returned from the database
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                double contribution = rs.getDouble("totalContribution");
                boolean winner = rs.getBoolean("winner");

                // Re-creating a temporary Member object to print it beautifully using its toString()
                Member temp = new Member(id, name, phone, contribution, winner);
                System.out.println(temp);
                System.out.println("--------------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error while retrieving members:");
            e.printStackTrace();
        }
    }

    // 5. ACTION: Record a New Payment Transaction
    public static void savePayment(Payment payment) {
        String sql = "INSERT INTO payment (memberId, amount, paymentDate) VALUES (?, ?, ?)";
        
        // This second query updates the member's total balance inside the member table at the same time!
        String updateMemberSql = "UPDATE member SET totalContribution = totalContribution + ? WHERE id = ?";

        try (
            Connection con = getConnection();
            PreparedStatement psPayment = con.prepareStatement(sql);
            PreparedStatement psUpdate = con.prepareStatement(updateMemberSql)
        ) {
            // Insert into payment table
            psPayment.setInt(1, payment.getMemberId());
            psPayment.setDouble(2, payment.getAmount());
            psPayment.setString(3, payment.getPaymentDate());
            psPayment.executeUpdate();

            // Update member's balance accumulation
            psUpdate.setDouble(1, payment.getAmount());
            psUpdate.setInt(2, payment.getMemberId());
            psUpdate.executeUpdate();

            System.out.println("\n>>> Payment recorded and Member Contribution updated! <<<");

        } catch (Exception e) {
            System.out.println("Error while processing payment transaction:");
            e.printStackTrace();
        }
    }

    // 6. ACTION: Update a Member's Status to 'Winner' when they win the Equb draw
    public static void updateWinnerStatus(int memberId) {
        String sql = "UPDATE member SET winner = true WHERE id = ?";

        try (
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, memberId);
            
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("\n>>> Status updated! Member ID " + memberId + " is officially a winner! <<<");
            } else {
                System.out.println("\n[!] Member ID not found.");
            }
        } catch (Exception e) {
            System.out.println("Error while updating winner status:");
            e.printStackTrace();
        }
    }
}