
package Sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Patient_sql {
	
	public static Boolean Check_account(String username)
	{
		Connection con=DBUtil.getConnection();
		String sql="SELECT *\r\n" + 
				"FROM Patient\r\n" + 
				"WHERE P_Name= '"+ username + "'";
		//String sql1 = "INSERT INTO Admin(A_Name,A_Password,A_Authority) Values ('"+username+"','"+password+"','"+authority+"')";
		Statement st;
		Boolean t = false;
		try {
			st  = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) t =  true;
			st.close();
			rs.close();
		 }catch(SQLException e)
			{
				e.printStackTrace();
			}
        return t;
	}
	
	
	public static String getID(String username)
	{
		Connection con=DBUtil.getConnection();
		String sql="SELECT P_ID\r\n" + 
				"FROM Patient\r\n" + 
				"WHERE P_Name= '"+ username + "' ";
		Statement st;
		String ID = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())  ID = rs.getString("P_ID");
			rs.close();
     		st.close();
					
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		 return ID;
	}
	
	
	public static String getBalace(String username)
	{
		Connection con=DBUtil.getConnection();
		String sql="SELECT P_Balance\r\n" + 
				"FROM Patient\r\n" + 
				"WHERE P_Name= '"+ username + "' ";
		Statement st;
		String ID = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())  ID = rs.getString("P_Balance");
			rs.close();
     		st.close();
					
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		 return ID;
	}
	
	
	public static void Insert_patient(String username, String password ,String sex, String age, String tel)
	{
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		
		String sql0 = "Delete \r\nFROM Patient\r\nWhere P_Name = '"+username+"'";
		
		String sql = "INSERT INTO Patient(P_Name,P_Sex,P_Age,P_PN,P_Balance) Values ('"+username +"','"+ sex +"','" + age +"','" + tel + "','0')";
         
		String sql1 = "Update Admin set A_Password = '" + password + "' where A_Name = +'"+ username+"' AND A_Authority = 'patient'";

		try {
			Statement st = con.createStatement();
			
			if(Check_account(username))   
				st.execute(sql0);
			st.execute(sql);
			st.execute(sql1);
			
		 }catch(SQLException e)
			{
				e.printStackTrace();
			}
	}


	public static void Add_Balance(String ID,String price) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		String sql = "Update Patient set P_Balance = P_Balance + '" + price + "' where P_ID = +'"+ ID +"'";
	    try{
	    	Statement st = con.createStatement();
	    	st.execute(sql);
	    }catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void UnAdd_Balance(String ID,String price) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		String sql = "Update Patient set P_Balance = P_Balance - '" + price + "' where P_ID = +'"+ ID +"'";
	    try{
	    	Statement st = con.createStatement();
	    	st.execute(sql);
	    }catch(SQLException e)
		{
			e.printStackTrace();
		}
	}


	public static String getsex(String username) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		String sql="SELECT P_ID\r\n" + 
				"FROM Patient\r\n" + 
				"WHERE P_Name= '"+ username + "' ";
		Statement st;
		String sex = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())  sex = rs.getString("P_Sex");
			rs.close();
     		st.close();
					
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		 return sex;
	}


	public static String getage(String username) {
		// TODO Auto-generated method stub
		Connection con=DBUtil.getConnection();
		String sql="SELECT P_ID\r\n" + 
				"FROM Patient\r\n" + 
				"WHERE P_Name= '"+ username + "' ";
		Statement st;
		String age = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())  age = rs.getString("P_Age");
			rs.close();
     		st.close();
					
		 }
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		 return age;
	}
	
}
