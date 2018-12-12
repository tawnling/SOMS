package Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Purchase_sql {

	public static void Insert(String text, String text2, String curTime, String text3, String text4,String getusername) {
			// TODO Auto-generated method stub
			Connection con=DBUtil.getConnection();
			String sql0 = "Select *\r\n "+
		         		  "From Purchase\r\n"+
					      "Where M_ID = '" + text + "' AND  S_ID =  '" + text2 + "' AND P_Date = '" + curTime + "'";
			String sql = "INSERT INTO Purchase(M_ID,S_ID,P_Date,P_Qulity,P_Price,P_Buyer) Values ('"+text +"','"+ text2 +"','" + curTime +"','" + text3 + "', '" + text4 + "' , '" + getusername + "')";
	     
			try {
				Statement st = con.createStatement();
				ResultSet sr = st.executeQuery(sql0);
				if(sr.next())  return ;
				   st.execute(sql);
	
			 }catch(SQLException e)
				{
					e.printStackTrace();
				}
		
	}

}
