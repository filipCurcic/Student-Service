package GUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogInScreen extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Service");
        Button btn = new Button();
        TextField userField = new TextField ();
        userField.setPromptText("Username");
        TextField passField = new TextField ();
        passField.setPromptText("Password");
        btn.setText("Log In");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	String username = userField.getText();
                String password = passField.getText();
                try {
					application.Application.readAllData();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
                
                if(application.logIn.checkLog(username, password) != null){
                	
                }
                else{
                	Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Error");
					alert.setContentText("You have entered the wrong username or password");
					alert.showAndWait();
                }
                
            }
        });
        VBox root = new VBox();
        root.setSpacing(15);
		root.setPadding(new Insets(15,45,45,45));
        root.getChildren().addAll(userField, passField,btn);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        
        
    }

}