package Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Medicineprice_sql {

public static String gettotlprice(String R_ID)
{
	Connection con=DBUtil.getConnection();
	String sql=" Select Sum(M_Price*R_Quantity) As 'Total Medicine Price'\r\n"+
    "From  Recipt,Medicine\r\n"+
    "Where Recipt.M_ID = Medicine.M_ID AND R_ID = '"+ R_ID + "' ";
	Statement st;
	String price = null;
	try {
		st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())  price = rs.getString(1);
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