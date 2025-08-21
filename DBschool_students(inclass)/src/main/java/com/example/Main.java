package com.example;
import java.sql.*;

public class Main{
	public static void main(String [] args){
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "root";
		try(Connection conn = DriverManager.getConnection(url,user,password)){
			System.out.println("Connected to MySQL");
			//createStudents(conn);
			//insertStudents(conn);
			deleteStudent(conn, 0004);
			getAllStudents(conn);
            
        
			
          
            
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	@SuppressWarnings("unused")
	private static void insertStudents(Connection conn) throws SQLException{
		try (Statement stmt = conn.createStatement()) {
			String insertStudents = """
				insert into students(id,name,age)
				values  (0001,'lia',19),
						(0002,'jacob',19),
						(0003,'isabell',19),
						(0004,'samule',20)
			""";
			stmt.executeUpdate(insertStudents);
			System.out.println("inserted students");
		}catch(SQLException e){
			System.err.println(e);
		}
	}
	private static void getAllStudents(Connection conn) throws SQLException{
		try (Statement stmt = conn.createStatement()) {
			String getAllStudents = """
				select *
				from students
				;
			""";
			try (ResultSet answer = stmt.executeQuery(getAllStudents)) {
				System.out.printf("%-5s %-30s %-12s", "ID", "Name", "Age");
				System.out.println();
				System.out.println("=" .repeat(80));
				while (answer.next()) {
					int id = answer.getInt("id");
					String name = answer.getString("name");
					String age = answer.getString("age");
					
					System.out.printf("%-5d %-30s %-12s",id, name, age);
					System.out.println();
				}
			}
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	@SuppressWarnings("unused")
	private static void createStudents(Connection conn) throws SQLException{
		try (Statement stmt = conn.createStatement()) {
			String createStudentsTable = """
				create table students(
					id INT AUTO_INCREMENT PRIMARY KEY,
					name VARCHAR(100),
					age INT
				);
			""";
			stmt.executeUpdate(createStudentsTable);
			System.out.println("Created Student Tabel");
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