package Client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Login.Login;
import Sql.Patient_sql;


public class Patient_PaymentController{
	
	public Patient_PaymentController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	private Button ok;
    @FXML
	private TextField pay;
	
    @FXML
    private Label tips;
   
    public void OK_Action() throws Exception
    {
    	if(pay.getText().isEmpty())
    	{
    		tips.setText("支付金额不能为空");
    		return ;
    	}
    	else 
    	{
    		Patient_sql.UnAdd_Balance(Patient_sql.getID(Login.getusername()), pay.getText());
    		ok.getScene().getWindow().hide();
    	}
    	
    }
    
    
   
}