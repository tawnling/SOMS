package Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Doctor_sql {
	
	public static Boolean Check_ID(String ID)
	{
		Connection con=DBUtil.getConnection();
		String sql="SELECT *\r\n" + 
				"FROM Doctor\r\n" + 
				"WHERE D_ID= '"+ ID + "'";
			
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
	
	public static String getID(String username)
	{
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		String sql="SELECT D_ID\r\n" + 
				"FROM Doctor\r\n" + 
				"WHERE D_Name= '"+ username + "' ";
		Statement st;
		String ID = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())  ID = rs.getString("D_ID");
			rs.close();
     		st.close();
					
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		 return ID;
	}

	public static boolean Check_account(String username) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		String sql="SELECT *\r\n" + 
				"FROM Doctor\r\n" + 
				"WHERE D_Name= '"+ username + "'";
			
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

	public static String getdepartment(String username) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		String sql="SELECT D_ID\r\n" + 
				"FROM Doctor\r\n" + 
				"WHERE D_Name= '"+ username + "' ";
		Statement st;
		String department = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())  department = rs.getString("D_Department");
			rs.close();
     		st.close();
					
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		 return department;
	}

	public static String gettitle(String username) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		String sql="SELECT D_ID\r\n" + 
				"FROM Doctor\r\n" + 
				"WHERE D_Name= '"+ username + "' ";
		Statement st;
		String title = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())  title = rs.getString("D_Title");
			rs.close();
     		st.close();
					
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		 return title;
	}


}
	