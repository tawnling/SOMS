package Login;

import javafx.fxml.FXML;
import Sql.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import Register.Register;

import Client.*;



public class LoginController{
	public LoginController() {
		// TODO Auto-generated constructor stub
		  
	}
	@FXML
	private Button login,register;
	@FXML
	private TextField account;
	@FXML
	private PasswordField password;
	@FXML
	private RadioButton rbpatient,rbdoctor,rbmadmin,rbadmin;
    @FXML
    private Label tips;
    @FXML
    private ToggleGroup group;
    
 
    
	public void to_Register() throws Exception {
		Register r=new Register();
		r.showWindow();
		register.getScene().getWindow().hide(); 
	}
	
	@FXML
	public void to_Client() throws Exception{
				
		if(account.getText().isEmpty())
		{
			tips.setText("账号不能为空");
			return ;
		}
	  else if(password.getText().isEmpty())
		{
			tips.setText("密码不能为空");
			return ;
		}
	else if(group.getSelectedToggle() == rbpatient)
		{
		    
		  if(!Login_sql.Login(account.getText(), password.getText(), "patient"))
		  {
			 tips.setText("账号不存在或者密码错误");
			 return ;
		  }
			Login.setusername(account.getText());
			Patient p = new Patient();
			p.showWindow();
			register.getScene().getWindow().hide(); 
		}
		else if(group.getSelectedToggle() == rbdoctor)
		{
			if(!Login_sql.Login(account.getText(), password.getText(), "doctor"))
			  {
				 tips.setText("账号不存在或者密码错误");
				 return ;
			  }
			Login.setusername(account.getText());
			Doctor d = new Doctor();
			d.showWindow();
			register.getScene().getWindow().hide();
		}
		else if(group.getSelectedToggle() == rbmadmin)
		{
			if(!Login_sql.Login(account.getText(), password.getText(), "madmin"))
			  {
				 tips.setText("账号不存在或者密码错误");
				 return ;
			  }
			Login.setusername(account.getText());
			Madmin m = new Madmin();
			m.showWindow();
			register.getScene().getWindow().hide();
			return ;
		}
		else if(group.getSelectedToggle() == rbadmin)
		{
			if(!Login_sql.Login(account.getText(), password.getText(), "admin"))
			  {
				 tips.setText("账号不存在或者密码错误");
				 return ;
			  }
			Login.setusername(account.getText());
			Admin a = new Admin();
			a.showWindow();
			register.getScene().getWindow().hide();
			return ;
		}
		
		tips.setText("请选择身份");
	}
	
	}