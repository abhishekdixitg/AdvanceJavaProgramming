package M1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/bulk_operation_tool";

		String username = "root";
		String password = "aabbhhii";

		String query = "INSERT into student(id, name) values (1011, 'Abhishek')";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c = DriverManager.getConnection(url, username, password);

			Statement st = c.createStatement();

			int count = st.executeUpdate(query);

			st.close();
			c.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
