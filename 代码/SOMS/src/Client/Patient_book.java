
package Client;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Login.Login;
import Sql.DBUtil;

public class Patient_book extends Application {
	 Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage) {
        try {
         
            Parent root = FXMLLoader.load(getClass()
           		.getResource("Patient_book.fxml"));
         
            primaryStage.setTitle("门诊管理系统");
            primaryStage.setScene(new Scene(root));
            
            
            Label username = (Label)root.lookup("#username");
            username.setText(Login.getusername());
            
            Label P_ID = (Label)root.lookup("#P_ID");
            Label sex = (Label)root.lookup("#sex");
            Label age = (Label)root.lookup("#age");
            Label tel = (Label)root.lookup("#tel");
           
            
            
            Connection con=DBUtil.getConnection();
    		String sql="SELECT *\r\n" + 
    				"FROM Patient\r\n" + 
    				"WHERE P_Name= '"+ Login.getusername() + "' ";
    		Statement st;
    		try {
    			st = con.createStatement();
    			ResultSet rs = st.executeQuery(sql);
    			while(rs.next()) {
    				P_ID.setText(rs.getString("P_ID"));
    				sex.setText(rs.getString("P_Sex"));
    				age.setText(rs.getString("P_age"));
    				tel.setText(rs.getString("P_PN"));
    			}
    			rs.close();
         		st.close();
    		 }catch(SQLException e)
    			{
    				e.printStackTrace();
    			}
    		
    		  Label doc = (Label)root.lookup("#doc");
              Label dep = (Label)root.lookup("#dep");
              Label reg = (Label)root.lookup("#reg");
              Label rt = (Label)root.lookup("#rt");
              String ids = P_ID.getText();
              		
    		    sql="SELECT *\r\n" + 
    				"FROM Registration\r\n" + 
    				"WHERE P_ID= '"+ ids + "' ";
    
   		try {
    			st = con.createStatement();
    			ResultSet rs = st.executeQuery(sql);
    			while(rs.next()) {
    				doc.setText((rs.getString("D_ID")));
    				reg.setText(rs.getString("R_ID"));
    				rt.setText(rs.getString("R_Time"));
    			}
    			rs.close();
         		st.close();
    		 }catch(SQLException e)
    			{
    				e.printStackTrace();
    			}
    		
    		 String D_ID = doc.getText();
    		 sql="SELECT *\r\n" + 
     				"FROM Doctor\r\n" + 
     				"WHERE D_ID= '"+ doc.getText() + "' ";
     
     		try {
     			st = con.createStatement();
     			ResultSet rs = st.executeQuery(sql);
     			while(rs.next()) {
     				doc.setText(rs.getString("D_Name"));
     				dep.setText(rs.getString("D_Department"));
     			}
     			rs.close();
          		st.close();
     		 }catch(SQLException e)
     			{
     				e.printStackTrace();
     			}
     		
     		  TextArea condition = (TextArea)root.lookup("#condition");
 
              Label dt = (Label)root.lookup("#dt");
    		  String recipt_id = new String();
     		
     		sql = "SELECT *\r\n" + 
     				"FROM Diagnosis\r\n" + 
     				"WHERE P_ID= '"+ P_ID.getText() + "' AND D_ID = '" +  D_ID + "'";
     
     		try {
     			st = con.createStatement();
     			ResultSet rs = st.executeQuery(sql);
     			while(rs.next()) {
     				condition.setText(rs.getString("D_Condition"));
     				dt.setText(rs.getString("D_Date"));
     				recipt_id = rs.getString("R_ID");
     			}
     			condition.setEditable(false);
     			rs.close();
          		st.close();
     		 }catch(SQLException e)
     			{
     				e.printStackTrace();
     			}
     		
     		TextArea recipt = (TextArea)root.lookup("#recipt");
     		if(recipt_id != null)
     		{
     		String s = "药品编号      药品数量\n";
     		sql = "SELECT *\r\n" + 
     				"FROM Recipt\r\n" + 
     				"WHERE R_ID= '"+ recipt_id + "'";
     
     		try {
     			st = con.createStatement();
     			ResultSet rs = st.executeQuery(sql);
     			while(rs.next()) {
     				s += (rs.getString("M_ID") + "   " + rs.getString("R_Quantity") + "\n");
     			}
     			rs.close();
          		st.close();
     		 }catch(SQLException e)
     			{
     				e.printStackTrace();
     			}
     		
     		recipt.setText(s);
     		}
     		recipt.setEditable(false);
            
            primaryStage.show();
     
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
	public void  showWindow() throws Exception {
		start(stage);
	}
}