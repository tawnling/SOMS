package Sql;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class DBUtil {
	    
	    private static final String URL="jdbc:sqlserver://localhost:1433;DatabaseName=Shoms";
	    private static final String NAME="sa";
	    private static final String PASSWORD="sasasa";
	    
	    private static Connection conn=null;
	    //静态代码块（将加载驱动、连接数据库放入静态块中）
	    static{
	        try {
	            //1.加载驱动程序
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            //2.获得数据库的连接
	            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    //对外提供一个方法来获取数据库连接
	    public static Connection getConnection(){
	        return conn;
	    }
//	    public static void main(String[] args) throws Exception{
//	        
//	        //3.通过数据库的连接操作数据库，实现增删改查
//	        Statement stmt = conn.createStatement();
//	        ResultSet rs = stmt.executeQuery("SELECT *\r\n" + 
//	        		"FROM Member");//选择import java.sql.ResultSet;
//	        while(rs.next()){//如果对象中有数据，就会循环打印出来
//	            System.out.println(rs.getString("Member_no")+","+rs.getString("Member_name"));
//	            
//	        }
//	        rs.close();
//	        stmt.close();
//	        conn.close();
//	    }
	}

