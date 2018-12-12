package Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Medicine_sql {

	public static Boolean Check_account(String username)
	{
		Connection con=DBUtil.getConnection();
		String sql="SELECT *\r\n" + 
				"FROM Medicine\r\n" + 
				"WHERE M_Name= '"+ username +  "' ";
		
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
	
	
	
	
public static String getlStock(String M_Name)
{
	Connection con=DBUtil.getConnection();
	String sql=" Select *\r\n"+
    "From  Medicine\r\n"+
    "Where M_Name = '"+ M_Name + "' ";
	Statement st;
	String price = null;
	try {
		st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())  price = rs.getString("M_Stock");
		rs.close();
 		st.close();
				
	 }
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	 return price;
}

public static String getID(String M_Name)
{
	Connection con=DBUtil.getConnection();
	String sql=" Select *\r\n"+
    "From  Medicine\r\n"+
    "Where M_Name = '"+ M_Name + "' ";
	Statement st;
	String ID = null;
	try {
		st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())  ID = rs.getString("M_ID");
		rs.close();
 		st.close();
				
	 }
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	 return ID;
}




public static boolean checkid(String text) {
	// TODO Auto-generated method stub

	Connection con=DBUtil.getConnection();
	String sql="SELECT *\r\n" + 
			"FROM Medicine\r\n" + 
			"WHERE M_ID= '"+ text +  "' ";
	
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




public static void UpdateStock(String text, String text2, boolean b) {
	// TODO Auto-generated method stub
		
	    Connection con=DBUtil.getConnection();
	    String sql;
		if(b) sql=" Update Medicine\r\n"+  "Set M_Stock = M_Stock + '" + text2 +"'\r\n"+ "Where M_ID = '"+text + "' ";
		else  sql = " Update Medicine\r\n"+  "Set M_Stock = M_Stock - '" + text2 +"'\r\n"+ "Where M_ID = '"+text + "' ";
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




public static String getAfterdate(String date) {
	// TODO Auto-generated method stub
	Connection con=DBUtil.getConnection();
	String sql=" Select *\r\n"+
    "From  Medicine\r\n";
	Statement st;
	String ans = "¹ýÆÚÒ©Æ·±àºÅ   Ãû³Æ\n";
	try {
		st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())  {
			  if(date.compareTo(rs.getString("M_Expirydate")) < 0)
				  ans += rs.getString("M_ID") + "  " + rs.getString("M_Name") + "\n";
		}
		rs.close();
 		st.close();
				
	 }
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	return ans;
}




public static String getAfternum(String text) {
	// TODO Auto-generated method stub
	Connection con=DBUtil.getConnection();
	String sql=" Select *\r\n"+
    "From  Medicine\r\n";
	Statement st;
	String ans = "¿â´æ²»×ãÒ©Æ·±àºÅ   Ãû³Æ\n";
	try {
		st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())  {
			  if(text.compareTo(rs.getString("M_Stock")) > 0)
				  ans += rs.getString("M_ID") + "  " + rs.getString("M_Name") + "\n";
		}
		rs.close();
 		st.close();
				
	 }
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	return ans;
}



}