package M1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestPreparedStatement {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/bulk_operation_tool";

		String username = "root";
		String password = "aabbhhii";

		String query = "INSERT into student(id, name) values (?, ?)";

		try (Connection c = DriverManager.getConnection(url, username, password);
				PreparedStatement st = c.prepareStatement(query);) {

			System.out.println(c.getSchema());
			Class.forName("com.mysql.cj.jdbc.Driver");
			st.setInt(1, 11101);
			st.setString(2, "AABBHHIIII");
			st.executeUpdate();
			// ResultSet rs = st.executeQuery(query);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
