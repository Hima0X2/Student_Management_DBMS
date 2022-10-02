package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection_creator {
	
	public static Connection create() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");// local host er maddhome connect krtese kortese
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sam", "root", "");
		//System.out.println(con);
		return con;
	}
}
