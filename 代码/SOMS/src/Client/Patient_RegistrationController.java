package Client;

import Login.Login;
import Sql.Doctor_sql;
import Sql.Patient_sql;
import Sql.Registration_sql;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Patient_RegistrationController{
		
		public Patient_RegistrationController() {
			// TODO Auto-generated constructor stub
		}
		@FXML
		private Button ensure;
		@FXML
		private TextField doctor;
	    @FXML
	    private Label tips, price;
	
	
	    public void Ensure_Action() throws Exception
	    {
	    	if(doctor.getText().isEmpty())
	    	{
	    		tips.setText("医生编号不能为空");
	    		return ;
	    	}
	    	else if(!Doctor_sql.Check_ID(doctor.getText()))
	    	{
	    	  	tips.setText("医生编号不存在");
	    	  	return ;
	    	}
	    	else 
	    	{   		
	    		Registration_sql.Insert_registration(Patient_sql.getID(Login.getusername()),doctor.getText(),price.getText(), Others.GetTime.getCurTime());
	    	    Patient_sql.Add_Balance(Patient_sql.getID(Login.getusername()),price.getText());
	    		ensure.getScene().getWindow().hide();
	    	}
       }
	   
	}
	
