package Client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Login.Login;
import Sql.Patient_sql;


public class PatientController{
	public PatientController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	private Button modify,exit,registration,select,payment;
    @FXML
    private Label tips;
	
    public void Exit_Action() throws Exception
    {
    	System.exit(0);
    }
    public void Modify_Action() throws Exception{
    	Patient_modify a = new Patient_modify();
		a.showWindow();
    }
    
    public void Registration_Action() throws Exception{
    	if(!Patient_sql.Check_account(Login.getusername()))
    	{
    	 tips.setText("请完善个人信息");
    	 return ;
    	}
    	Patient_Registration a = new Patient_Registration();
    	a.showWindow();
    }
    public void Select_Action() throws Exception{
    	Patient_book a = new Patient_book();
    	a.showWindow();
    }
    
    public void Payment_Action() throws Exception{
    	Patient_Payment a = new Patient_Payment();
    	a.showWindow();	
    			}
    }
    