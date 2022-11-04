package student_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentManagement {
	private Connection con;

	public StudentManagement() {
		this.con = jdbc_connection.JDBC.getJDBCConnection();
	}

	public String sqlDateFormatToString(Date date) {
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String str = dateFormat.format(date);
		return str;
	}

	public String stringFormatToSQLDate(String date) {
		String[] arrayString = date.split("/");

		String rs = "";
		for (int i = 2; i >= 0; i--) {
			rs += arrayString[i];
			rs += "-";
		}
		rs = rs.substring(0, rs.length() - 1);
		return rs;
	}

	public void display() {
		System.out.printf("|%-10s | %-30s | %-15s | %-5s | %-30s | %-6s |%n", "ID", "Full Name", "Day on birth",
				"Gender", "Email", "Score");
	}

	public void showList() throws SQLException {

		Statement s = con.createStatement();
		String sql = "select * from student";

		ResultSet rs = s.executeQuery(sql);
		display();
		
		while (rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);

			Date birthday = rs.getDate(3);
			String strDate = sqlDateFormatToString(birthday);

			String gender = rs.getString(4);
			String email = rs.getString(5);
			Double score = rs.getDouble(6);

			System.out.printf("|%-10s | %-30s | %-15s | %-6s | %-30s | %-6.2f |%n", id, name, strDate, gender, email,
					score);
		}
	}

	public void addStudent(Student sv) throws SQLException {
		Statement s = con.createStatement();
		String date = stringFormatToSQLDate(sv.getBirthDay());
		String sql = "insert into student values ('" + sv.getId() + "','" + sv.getFullName() + "','" + date + "','"
				+ sv.getGender() + "','" + sv.getEmail() + "'," + sv.getScore() + ")";

		int rs = s.executeUpdate(sql);
		if (rs == 1) {
			System.out.println("ADD SUCCESS!");
		} else {
			System.out.println("ADD FAILURE!");
		}

	}

	public void editStudent(Student sv) throws SQLException {
		Statement s = con.createStatement();
		String date = stringFormatToSQLDate(sv.getBirthDay());
		String sql = "Update student\n" + "Set fullname = '" + sv.getFullName() + "' , birthday = '" + date
				+ "', gender = '" + sv.getGender() + "', email = '" + sv.getEmail() + "', score = '" + sv.getScore()
				+ "'\n" + "where id = '" + sv.getId() + "'";

		int rs = s.executeUpdate(sql);
		if (rs == 1) {
			System.out.println("EDIT SUCCESS!");
		} else {
			System.out.println("EDIT FAILURE!");
		}
	}

	public void removeStudent(Student sv) throws SQLException {
		Statement s = con.createStatement();

		String sql = "Delete from student\n" + "where id = '" + sv.getId() + "'";

		int rs = s.executeUpdate(sql);
		if (rs == 1) {
			System.out.println("REMOVE SUCCESS!");
		} else {
			System.out.println("REMOVE FAILURE!");
		}
	}

	public void searchByID(Student sv) throws SQLException {
		Statement s = con.createStatement();
		String sql = "select * from student\n" + "where id = '" + sv.getId() + "'";
		ResultSet rs = s.executeQuery(sql);
		display();
		while (rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);

			Date birthday = rs.getDate(3);
			String strDate = sqlDateFormatToString(birthday);

			String gender = rs.getString(4);
			String email = rs.getString(5);
			Double score = rs.getDouble(6);

			System.out.printf("|%-10s | %-30s | %-15s | %-6s | %-30s | %-6.2f |%n", id, name, strDate, gender, email,
					score);
		}
	}

	public void SortByScore() throws SQLException {
		Statement s = con.createStatement();
		String sql = "SELECT * FROM jdbc.student\r\n" + "order by score ";

		ResultSet rs = s.executeQuery(sql);
		display();
		while (rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);

			Date birthday = rs.getDate(3);
			String strDate = sqlDateFormatToString(birthday);

			String gender = rs.getString(4);
			String email = rs.getString(5);
			Double score = rs.getDouble(6);

			System.out.printf("|%-10s | %-30s | %-15s | %-6s | %-30s | %-6.2f |%n", id, name, strDate, gender, email,
					score);
		}
	}
}
