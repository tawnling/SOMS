
package Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Sql.DBUtil;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Patient_Registration extends Application {
	 Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage) {
       try {
         
            Parent root = FXMLLoader.load(getClass()
           		.getResource("Patient_registration.fxml"));
         
            primaryStage.setTitle("门诊管理系统");
            primaryStage.setScene(new Scene(root));
            @SuppressWarnings("unchecked")
			TableView<Person> table = (TableView<Person>)root.lookup("#doc_excel");
            table.setEditable(true);
            
            TableColumn firstNameCol = new TableColumn("编号");
            firstNameCol.setMinWidth(50);
            firstNameCol.setCellValueFactory(
                    new PropertyValueFactory<>("ID"));

            TableColumn lastNameCol = new TableColumn("姓名");
            lastNameCol.setMinWidth(150);
            lastNameCol.setCellValueFactory(
                    new PropertyValueFactory<>("Name"));

            TableColumn emailCol = new TableColumn("科室");
            emailCol.setMinWidth(150);
            emailCol.setCellValueFactory(
                    new PropertyValueFactory<>("Department"));

           
        
            
            ObservableList<Person> list = FXCollections.observableArrayList();
            Connection con=DBUtil.getConnection();
    		String sql="SELECT *\r\n" + 
    				"FROM Doctor";
    		Statement st;
    		try {
    			st = con.createStatement();
    			ResultSet rs = st.executeQuery(sql);
    			while(rs.next())  
    				{
    				list.add(new Person(rs.getString("D_ID"),rs.getString("D_Name"),rs.getString("D_Department")));
    				}
    			rs.close();
         		st.close();
    		 }
    			catch(SQLException e)
    			{
    				e.printStackTrace();
    			}
            
            table.setItems(list);
            table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
            
            
           // Label username = (Label)root.lookup("#username");
            //username.setText(Login.getusername());
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
	
	
	
	 public static class Person {

	        private final SimpleStringProperty ID;
	        private final SimpleStringProperty Name;
	        private final SimpleStringProperty Department;

	        private Person(String ID, String Name, String Department) {
	            this.ID = new SimpleStringProperty(ID);
	            this.Name = new SimpleStringProperty(Name);
	            this.Department = new SimpleStringProperty(Department);
	        }

	        public void setID(String ID)
	        {
	        	this.ID.set(ID);
	        }
	        public void setName(String Name)
	        {
	        	this.Name.set(Name);
	        }
	        public void setDepartment(String Department)
	        {
	        	this.Department.set(Department);
	        }
	        public String getID() 
	        {
	            return this.ID.get();
	        }
            public String getName()
            {
            	return this.Name.get();
            }
            public String getDepartment()
            {
            	return this.Department.get();
            }
	    }
	
	
	
	
	
}
