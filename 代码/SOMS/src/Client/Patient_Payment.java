
package Client;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


import Login.Login;
import Sql.Diagnosis_sql;
import Sql.Medicineprice_sql;
import Sql.Patient_sql;
import Sql.Registration_sql;

public class Patient_Payment extends Application {
	 Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage) {
        try {
         
            Parent root = FXMLLoader.load(getClass()
           		.getResource("Patient_payment.fxml"));
         
            primaryStage.setTitle("门诊管理系统");
            primaryStage.setScene(new Scene(root));
            Label p1 = (Label)root.lookup("#p1");
            Label p2 = (Label)root.lookup("#p2");
            Label p3 = (Label)root.lookup("#p3");
            Label p4 = (Label)root.lookup("#p4");
            TextField pay = (TextField)root.lookup("#pay");
            ImageView imv = (ImageView)root.lookup("#image");
            Image image = new Image("0.jpg");
            imv.setImage(image);
            
            if(Patient_sql.getID(Login.getusername()) == null || Registration_sql.getprice(Patient_sql.getID(Login.getusername())) == null)
            p1.setText("0");
            else p1.setText(Registration_sql.getprice(Patient_sql.getID(Login.getusername())));
            
            if(Patient_sql.getID(Login.getusername()) == null || Diagnosis_sql.getX(Patient_sql.getID(Login.getusername()),"D_Price") == null)
            p2.setText("0");		
            else p2.setText(Diagnosis_sql.getX(Patient_sql.getID(Login.getusername()),"D_Price"));
    		
            
            if(Patient_sql.getID(Login.getusername()) == null || Diagnosis_sql.getX(Patient_sql.getID(Login.getusername()),"R_ID") == null )  p3.setText("0");
            else
            	{
            	String  r_id =  Diagnosis_sql.getX(Patient_sql.getID(Login.getusername()),"R_ID");            
    		    if(Medicineprice_sql.gettotlprice(r_id) == null ) p3.setText("0");
    		    else p3.setText(Medicineprice_sql.gettotlprice(r_id));
            	}
            if(Patient_sql.getBalace(Login.getusername()) == null)
            {
            	p4.setText("0");
            	pay.setText("0");
            }
            else 
            	{
            	p4.setText(Patient_sql.getBalace(Login.getusername()));
                pay.setText(p4.getText());
            	}
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