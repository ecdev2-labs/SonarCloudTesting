// InsecureSQL.java
import java.sql.*;

public class InsecureSQL {
    public static void main(String[] args) throws Exception {
        String userInput = "'; DROP TABLE users; --";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "password");
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM users WHERE username = '" + userInput + "'";  // SQL injection
        ResultSet rs = stmt.executeQuery(sql);
    }
}
