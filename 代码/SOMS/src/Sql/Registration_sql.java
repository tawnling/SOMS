package Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Registration_sql {

	public static void Insert_registration(String P_ID, String D_ID ,String R_Price, String R_Time)
	{
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
			
		String sql = "INSERT INTO Registration(P_ID,D_ID,R_price,R_Time) Values ('"+P_ID +"','"+ D_ID +"','" + R_Price +"','" + R_Time + "')";

		try {
			Statement st = con.createStatement();
			st.execute(sql);
		 }catch(SQLException e)
			{
				e.printStackTrace();
			}
	}
	
	public static String getprice(String P_ID)
	{
		Connection con=DBUtil.getConnection();
		String sql="SELECT R_Price\r\n" + 
				"FROM Registration\r\n" + 
				"WHERE P_ID= '"+ P_ID + "' ";
		Statement st;
		String price = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())  price = rs.getString("R_price");
			rs.close();
     		st.close();
					
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		 return price;
	}
	
	
	
}
