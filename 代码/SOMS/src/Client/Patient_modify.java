
package Client;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import Login.Login;

public class Patient_modify extends Application {
	 Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage) {
        try {
         
            Parent root = FXMLLoader.load(getClass()
           		.getResource("Patient_modify.fxml"));
         
            primaryStage.setTitle("门诊管理系统");
            primaryStage.setScene(new Scene(root));
            Label username = (Label)root.lookup("#username");
            username.setText(Login.getusername());
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