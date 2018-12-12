package Client;

import Login.Login;
import Sql.Diagnosis_sql;
import Sql.Doctor_sql;
import Sql.Medicine_sql;
import Sql.Medicineprice_sql;
import Sql.Patient_sql;
import Sql.Recipt_sql;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Doctor_DiagnosisController {

	
	public Doctor_DiagnosisController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	private Button ok,add;
    @FXML
    private TextArea condition,recipt;
    @FXML
    private TextField user,price,mname,mn;
    @FXML
    private Label tips;
    String s = "";
    int tot = 0;
    String Name[] = new String[50];
    String NN[] = new String[50];
    @FXML
    public void Add_Action()throws Exception{
    	if(mname.getText().isEmpty())
    	{
    		tips.setText("请填写药品名称");  	
    		return ;
    	}
    	else if(mn.getText().isEmpty())
    	{
    		tips.setText("请填写药品数量");
    		return ;
    	}
    	else if(!Medicine_sql.Check_account(mname.getText()))
    	{
    		tips.setText("药品名称错误");
    		return ;
    	}
    	else if(Double.parseDouble(Medicine_sql.getlStock(mname.getText())) < Double.parseDouble(mn.getText()))
    	{
    		tips.setText("该药品库存不足");
    		return ;
    	}
    	else 
    	{
    		Name[tot] = mname.getText();
    		NN[tot++] = mn.getText();
    		s += mname.getText() + "   " + mn.getText() + "\n"; 
    		recipt.setText(s);
    	}    
    }
    
    public void OK_Action() throws Exception
    {
    	if(user.getText().isEmpty())
    	{
    		tips.setText("请填写病人姓名");
    		return ;
    	}
    	else if(!Patient_sql.Check_account(user.getText()))
    	{
    		tips.setText("该病人不存在");
    		return ;
    	}
    	else if(price.getText().isEmpty())
    	{
    		tips.setText("请填写诊断费用");
    		return;
    	}
    	else if(condition.getText().isEmpty())
    	{
    		tips.setText("请填写病情");
    		return ;
    	}
    	else 
    	{
    	   		
    		if(recipt.getText().isEmpty())
    	  	{
    			Diagnosis_sql.Insert(Patient_sql.getID(user.getText()), Doctor_sql.getID(Login.getusername()), null,Others.GetTime.getCurTime(), condition.getText(),price.getText());
    	  	    Patient_sql.Add_Balance(Patient_sql.getID(user.getText()), price.getText());
    	  	}
    		else 
    		{
    		String r_id = Recipt_sql.getid();
    		Integer  x;  
    		if(r_id == null)  x =  1;
    		else x =  Integer.parseInt(r_id)+1;
    		
    		r_id = x.toString();
    		Diagnosis_sql.Insert(Patient_sql.getID(user.getText()), Doctor_sql.getID(Login.getusername()), r_id,Others.GetTime.getCurTime(), condition.getText(),price.getText());
    		for(int i = 0; i < tot; i++)
    		{
    		    String m_id = Medicine_sql.getID(Name[i]);
    			Recipt_sql.Insert(r_id,m_id,NN[i]);
    		}
    		Patient_sql.Add_Balance(Patient_sql.getID(user.getText()), Medicineprice_sql.gettotlprice(r_id));
    		}
    		ok.getScene().getWindow().hide(); 
    	  }
    }
}  
    