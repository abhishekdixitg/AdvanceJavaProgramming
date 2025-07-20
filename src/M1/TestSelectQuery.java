package M1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelectQuery {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/bulk_operation_tool";

		String username = "root";
		String password = "aabbhhii";

		String query = "Select * from student";

		try (Connection c = DriverManager.getConnection(url, username, password);
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery(query);) {
			Class.forName("com.mysql.cj.jdbc.Driver");

			while (rs.next()) {
				System.out.println("values::" + rs.getObject(2));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
