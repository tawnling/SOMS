package Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Sql.DBUtil;
import Sql.Patient_sql;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Doctor_selectController {

	
	public Doctor_selectController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	private Button select;
	@FXML
    private Label username,P_ID,sex,age,tel,dep,reg,rt,doc,dt;
    @FXML
    private TextArea condition,recipt;
    @FXML
    private TextField user;
    @FXML
    private Label tips;
    
    public void Action_select() throws Exception{
    
    
    	
    if(user.getText().isEmpty()){
    	tips.setText("查询名字不能为空");
    	return ;
    }
    else if(Patient_sql.Check_account(user.getText()) == false)
    {
    	return ;
    }
    else{    
    username.setText(user.getText());
    
    Connection con=DBUtil.getConnection();
	String sql="SELECT *\r\n" + 
			"FROM Patient\r\n" + 
			"WHERE P_Name= '"+ user.getText() + "' ";
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
    }
    }	
}
