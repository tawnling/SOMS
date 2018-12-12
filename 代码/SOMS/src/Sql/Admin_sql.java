package Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin_sql {

	public static String getpassword(String username) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		String sql="SELECT *\r\n" + 
				"FROM Admin\r\n" + 
				"WHERE A_Name= '"+ username + "' ";
		Statement st;
		String Passwords = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())  Passwords = rs.getString("A_password");
			rs.close();
     		st.close();
					
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		return Passwords;
	}

	public static void setpassword(String text, String text2) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		String sql="Update Admin\r\n" + 
				"Set A_Password = '" + text2 + "'\r\n" + 
				"WHERE A_Name= '"+ text + "' ";
		Statement st;
		try {
			st = con.createStatement();
			st.execute(sql);
     		st.close();
					
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}
	}

	public static void delete(String text) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		String sql="delete \r\n" + 
				"From Admin \r\n" + 
				"WHERE A_Name= '"+ text + "' ";
		Statement st;
		try {
			st = con.createStatement();
			st.execute(sql);
     		st.close();
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}
	}
  
}
