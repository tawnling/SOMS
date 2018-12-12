package Client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class DoctorController{
	public DoctorController() {
		// TODO Auto-generated constructor stub
	}
	@FXML
	private Button select;
    @FXML
    private Label tips;
	
    public void Exit_Action() throws Exception
    {
    	System.exit(0);
    }
 
    public void Select_Action() throws Exception{
    	Doctor_select a = new Doctor_select();
    	a.showWindow();
    }
    
    public void Diagnosis_Action() throws Exception{
    	Doctor_Diagnosis a = new Doctor_Diagnosis();
    	a.showWindow();
    }
    

    }
    