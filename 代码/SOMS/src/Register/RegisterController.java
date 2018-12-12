package Register;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import Login.Login;
import Sql.*;

public class RegisterController{
	public RegisterController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	private Button login,register;
	@FXML
	private TextField account;
	@FXML
	private PasswordField password,rpassword;
	@FXML
	private RadioButton rbpatient,rbdoctor;
    @FXML
    private Label tips;
    @FXML
    private ToggleGroup group;
    
	public void to_Login() throws Exception {
		Login l=new Login();
		l.showWindow();
		login.getScene().getWindow().hide(); 
	}
	
	@FXML
	public void to_Register() throws Exception{
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
	  else if(rpassword.getText().isEmpty())
	  {
		  tips.setText("请填写重复密码");
		  return ;
	  }
	  else if(!password.getText().equals(rpassword.getText()))
     {
		  tips.setText("两次填写的密码不一致");
		  return ;
     }
	 else if(group.getSelectedToggle() == rbpatient)
	 {
		 if(Register_sql.Check_account(account.getText(), "patient"))
			tips.setText("该账号已被注册");
		 else {
			 Register_sql.Register(account.getText(), password.getText(), "patient");
			 tips.setText("注册成功");
		 }
	 }
	 else if(group.getSelectedToggle() == rbdoctor)
	 {
		 if(Register_sql.Check_account(account.getText(), "doctor"))
			tips.setText("该账号已被注册");
		 else 
			 {
			 Register_sql.Register(account.getText(), password.getText(), "doctor");
			 tips.setText("注册成功");
			 }
	 }
	 else tips.setText("请选择身份");
	}
  }