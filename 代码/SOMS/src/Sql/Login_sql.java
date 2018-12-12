package Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login_sql {

	public static Boolean Login(String username,String password,String authority)
	{
		Connection con=DBUtil.getConnection();
		String sql="SELECT A_Password\r\n" + 
				"FROM Admin\r\n" + 
				"WHERE A_Name= '"+ username + "'  AND A_Authority = '" + authority + "' ";
		Statement st;
		String Passwords = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())  Passwords = rs.getString("A_password");
			else return false;
			rs.close();
     		st.close();
					
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		if(Passwords.equals(password)) return true;
		else return false;
	}
}
