package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "root";
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to MySQL");
            //createStudents(conn);
            //insertStudents(conn);
            deleteStudent(conn, 4);
            getAllStudents(conn);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unused")
    private static void insertStudents(Connection conn) throws SQLException {
        String sql = "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, 1);
            stmt.setString(2, "lia");
            stmt.setInt(3, 19);
            stmt.executeUpdate();

            stmt.setInt(1, 2);
            stmt.setString(2, "jacob");
            stmt.setInt(3, 19);
            stmt.executeUpdate();

            stmt.setInt(1, 3);
            stmt.setString(2, "isabell");
            stmt.setInt(3, 19);
            stmt.executeUpdate();

            stmt.setInt(1, 4);
            stmt.setString(2, "samule");
            stmt.setInt(3, 20);
            stmt.executeUpdate();

            System.out.println("Inserted students");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void getAllStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet answer = stmt.executeQuery()) {

            System.out.printf("%-5s %-30s %-12s", "ID", "Name", "Age");
            System.out.println();
            System.out.println("=".repeat(80));

            while (answer.next()) {
                int id = answer.getInt("id");
                String name = answer.getString("name");
                String age = answer.getString("age");

                System.out.printf("%-5d %-30s %-12s", id, name, age);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unused")
    private static void createStudents(Connection conn) throws SQLException {
        String sql = """
            CREATE TABLE students(
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(100),
                age INT
            );
        """;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
            System.out.println("Created Student Table");
        }
    }

    private static void deleteStudent(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println("Deleted " + rows + " row(s).");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
