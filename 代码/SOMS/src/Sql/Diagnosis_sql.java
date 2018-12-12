package Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Diagnosis_sql {

	public static void Insert(String P_ID, String D_ID ,String R_ID, String D_Date, String D_Condition, String D_Price)
	{
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
	    String sql0 = "Select *\r\n"+
		              "From Diagnosis\r\n"+
	    		      "where P_ID = '" + P_ID +"' AND D_ID = '" + D_ID + "' AND D_Date = '" + D_Date + "'";
		
		String sql = "INSERT INTO Diagnosis(P_ID,D_ID,R_ID,D_Date,D_Condition,D_Price) Values ('"+P_ID +"','"+ D_ID +"','" + R_ID +"','" + D_Date +"','" + D_Condition +"','" + D_Price + "')";
		String sqlnull = "INSERT INTO Diagnosis(P_ID,D_ID,D_Date,D_Condition,D_Price) Values ('"+P_ID +"','"+ D_ID +"','" + D_Date +"','" + D_Condition +"','" + D_Price+"')";
		
		
		try {
			
			Statement st = con.createStatement();
			ResultSet sr = st.executeQuery(sql0);
			if(sr.next())  return;
			if(R_ID == null)
			st.execute(sqlnull);
			else st.execute(sql);
		 }catch(SQLException e)
			{
				e.printStackTrace();
			}
	}
	
	public static String getX(String P_ID,String X)
	{
		Connection con=DBUtil.getConnection();
		String sql="SELECT *\r\n" + 
				"FROM Diagnosis\r\n" + 
				"WHERE P_ID= '"+ P_ID + "' ";
		Statement st;
		String price = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())  price = rs.getString(X);
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
