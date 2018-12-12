package Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Register_sql {
	
	public static Boolean Check_account(String username,String authority)
	{
		Connection con=DBUtil.getConnection();
		String sql="SELECT *\r\n" + 
				"FROM Admin\r\n" + 
				"WHERE A_Name= '"+ username + "'  AND A_Authority = '" + authority + "' ";
		//String sql1 = "INSERT INTO Admin(A_Name,A_Password,A_Authority) Values ('"+username+"','"+password+"','"+authority+"')";
		
		Boolean t = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) t =  true;
			rs.close();
		 }catch(SQLException e)
			{
				e.printStackTrace();
			}
        return t;
	}
	
	

	
	public static void Register(String username,String password, String authority)
	{
		Connection con=DBUtil.getConnection();
		
		String sql = "INSERT INTO Admin(A_Name,A_Password,A_Authority) Values ('"+username+"','"+password+"','"+authority+"')";

		try {
			Statement st = con.createStatement();
			st.execute(sql);
		 }catch(SQLException e)
			{
				e.printStackTrace();
			}
	}
	
	
}

