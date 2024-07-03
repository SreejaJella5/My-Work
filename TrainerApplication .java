import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrainerApplication {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		String url=null;
		String userName=null;
		String password=null;
		PreparedStatement pst=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		url="jdbc:mysql://localhost:3306/ajp";
		userName="root";
		password="Sreeja@252";
		//2. Creating the connection
		con=DriverManager.getConnection(url,userName,password );
		//3.creating PreparedStatement
		pst=con.prepareStatement("insert into Trainer values (?,?,?,?) ");
		pst.setInt(1, 354);
		pst.setString(2, "Sham");
		pst.setString(3,"MCA");
		pst.setInt(4, 20);
		
		int i=pst.executeUpdate();
		if(i!=0)
			System.out.println("1 Record inserted");
		else
			System.out.println(" Record not inserted");
		
		
		}catch(SQLException e) {
			System.out.println("Sql exception");
			
		}catch(ClassNotFoundException e) {
			System.out.println("Class not found exception");
		}
		finally {
			pst.close();
			con.close();
		}
		
	}

}
