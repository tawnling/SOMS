package Client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import Sql.Patient_sql;


public class Patient_modifyController{
	
	public Patient_modifyController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	private Button ok;
	@FXML
	private RadioButton male,female;
	@FXML
	private TextField age,tel;
	@FXML   
	private PasswordField password;
    @FXML
    private Label username,tips;
    @FXML
    private ToggleGroup group;
   
    public void OK_Action() throws Exception
    {
    	if(password.getText().isEmpty())
    	{
    		tips.setText("密码不能为空");
    		return ;
    	}
    	else if(group.getSelectedToggle() == null)
    	{
    		tips.setText("请选择性别");
    		return ;
    	}
    	else if(age.getText().isEmpty())
    	{
    		tips.setText("请填写年龄");
    		return ;
    	}
    	else if(tel.getText().isEmpty())
    	{
    		tips.setText("请填写电话");
    	}
    	else {
    		  if(group.getSelectedToggle() == male)
    	      Patient_sql.Insert_patient(username.getText(),password.getText(),"男",age.getText(),tel.getText());	
    		  else
    	      Patient_sql.Insert_patient(username.getText(),password.getText(),"女",age.getText(),tel.getText());
    		  ok.getScene().getWindow().hide();
    	}
    }
    
    
   
}