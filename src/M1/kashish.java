import java.sql.SQLException;
import java.sql.Statement;

public class kashish {
	public static void main (String [] args) {
		
		String url = " jdbc:mysql://localhost:3306/bulk_operation_tool";
		
		String username = " AdvancedJava";
		String password = " studyJava";
		
		String query = " SELECT * from Student";
		
		try (Connection c = DriverManager.getConnection(url, username, password);
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery(query);){
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			while(rs.next()) {
				System.out.println("values : "+ rs.getObject(2));
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
				
	}
}
