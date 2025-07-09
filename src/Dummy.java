// VulnerableExample.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VulnerableExample {

    public static void main(String[] args) {
        String username = "admin";
        String password = "admin123"; // Hardcoded credentials

        try {
            // Insecure SQL statement vulnerable to SQL Injection
            String userInput = "' OR '1'='1";
            String query = "SELECT * FROM users WHERE username = '" + userInput + "'";

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Unused method (Sonar will detect this)
    private void unusedMethod() {
        System.out.println("This method is never used.");
    }
}
