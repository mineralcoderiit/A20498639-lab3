import java.sql.*;

public class driver {
    public static void main(String ... args){
        String url= "jdbc:mysql://localhost:3306/sakila";
        String username = "itmd4515";
        String password = "itmd4515";
        String query = "select * from customer";
        try (Connection c = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = c.prepareStatement(query);) {

            ps.setString(1, "BOX");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("first_name"));
            }
        } catch (SQLException sqle) {
            System.out.println("SQL Exception: " + sqle);
        }
    }
}
