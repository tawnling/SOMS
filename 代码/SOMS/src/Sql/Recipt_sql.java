package Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Recipt_sql {

	public static String getid()
	{
		Connection con=DBUtil.getConnection();
		String sql="SELECT Max(R_ID) as max_id\r\n" + 
				"FROM Recipt\r\n";
				
				
		Statement st;
		String ID = "1";
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())  ID = rs.getString("max_id");
			rs.close();
     		st.close();
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		 return ID;
	}
	
	public static void Insert(String R_ID, String M_ID ,String R_Quantity)
	{
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		
		if(R_ID == null) R_ID = "1";
		String sql = "INSERT INTO Recipt(R_ID,M_ID,R_Quantity) Values ('"+R_ID +"','"+ M_ID +"','" + R_Quantity + "')";

		try {
			Statement st = con.createStatement();
			st.execute(sql);
		 }catch(SQLException e)
			{
				e.printStackTrace();
			}
	}
	
}
