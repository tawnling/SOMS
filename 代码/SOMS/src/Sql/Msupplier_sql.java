package Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Msupplier_sql {

	public static boolean checkid(String text) {
		// TODO Auto-generated method stub

		Connection con=DBUtil.getConnection();
		String sql="SELECT *\r\n" + 
				"FROM Msupplier\r\n" + 
				"WHERE S_ID= '"+ text +  "' ";
		
		Boolean t = false;
		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			if(rs.next()) t =  true;
			rs.close();
		 }catch(SQLException e)
			{
				e.printStackTrace();
			}
        return t;
	}

	public static String get(String id, String s) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		String sql="SELECT *\r\n" + 
				"FROM Msupplier\r\n" + 
				"WHERE S_ID= '"+ id +  "' ";
		String ans = null;
		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()){
				ans = rs.getString(s);
			}
			rs.close();
		 }catch(SQLException e)
			{
				e.printStackTrace();
			}
		return ans;
	}

	public static void Update(String text, String text2, String text3, String text4) {
		// TODO Auto-generated method stub
		if(checkid(text)) Delete(text);
        Insert(text2,text3,text4);		
	}

	public static void Insert( String text2, String text3, String text4) {
		// TODO Auto-generated method stub
		
		Connection con = DBUtil.getConnection();
		String sql = "Insert into Msupplier(S_Name,S_PN,S_Address) Values('" + text2 + "','" + text3 + "','" + text4 + "')";
		try{
            Statement st = con.createStatement();
			st.execute(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	public static void Delete(String text) {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		if(!checkid(text)) return ;
		String sql = "delete From Msupplier where S_ID = '" + text + "'";
		try{
            Statement st = con.createStatement();
			st.execute(sql);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}


}
