package Login;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
;
public class Login extends Application {

	private static String username;
	Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage) {
        try {
         
            Parent root = FXMLLoader.load(getClass()
           		.getResource("Login.fxml"));
                        
            primaryStage.setTitle("Login");
            primaryStage.setScene(new Scene(root));
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
	public static void setusername(String s)
	{
		username = s;
	}
	public static String getusername()
	{
		return username;
	}
	
	
}