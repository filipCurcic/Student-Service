package GUI;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;
import javafx.scene.control.Label;

public class AdminMenu extends Stage {
	
	{
	    	this.setTitle("Admin Menu");
	    	Label lbl1 = new Label("You have logged in as: " + User.getAdloggedIn().getFirstName() +" "+ User.getAdloggedIn().getLastName());
	    	
	    	Button btn1 = new Button();
	    	btn1.setText("1 - Add a New Professor");
	    	btn1.setOnAction(new EventHandler<ActionEvent>(){
	    		@Override
	    		public void handle(ActionEvent event){
	    		
	    		new MakeNewProfessor();
	    		}
	    		
	    	});
	    	
	    	Button btn2 = new Button();
	    	btn2.setText("2 - Add a New Student");
	    	btn2.setOnAction(new EventHandler<ActionEvent>(){
	    		@Override
	    		public void handle(ActionEvent event){
	    		
	    		new MakeNewStudent();
	    		}
	    		
	    	});
	    	
	    	Button btn3 = new Button();
	    	btn3.setText("3 - Create a New Subject");
	    	btn3.setOnAction(new EventHandler<ActionEvent>(){
	    		@Override
	    		public void handle(ActionEvent event){
	    		new CreateSubject();
	    		}
	    		
	    	});
	    	
	    	Button btn4 = new Button();
	    	btn4.setText("4 - Search Students");
	    	btn4.setOnAction(new EventHandler<ActionEvent>(){
	    		@Override
	    		public void handle(ActionEvent event){
	    		
					new SearchStudents();
	    		}
	    		
	    	});
	    	
	    	Button btn5 = new Button();
	    	btn5.setText("5 - Search Professors");
	    	btn5.setOnAction(new EventHandler<ActionEvent>(){
	    		@Override
	    		public void handle(ActionEvent event){
	    		
	    		new SearchProfessors();
	    		}
	    		
	    	});
	    	
	    	Button btn6 = new Button();
	    	btn6.setText("6 - View Proof of Payments");
	    	btn6.setOnAction(new EventHandler<ActionEvent>(){
	    		@Override
	    		public void handle(ActionEvent event){
	    		
	    		new ViewAppliedTests();
	    		}
	    		
	    	});
	    	Button btn7 = new Button();
	    	btn7.setText("7 - View Students by Surname");
	    	btn7.setOnAction(new EventHandler<ActionEvent>(){
	    		@Override
	    		public void handle(ActionEvent event){
	    		
	    		new SortStudent();
	    		}
	    		
	    	});
	    	Button btn8 = new Button();
	    	btn8.setText("8 - Exit the program");
	    	btn8.setOnAction(new EventHandler<ActionEvent>(){
	    		@Override
	    		public void handle(ActionEvent event){

	    			  Alert alert = new Alert(AlertType.INFORMATION);
	    			  	alert.setTitle("University TITS");
	    		    	alert.setHeaderText("You have exited the application");
	    		    	alert.setContentText("Thank you for using the university service");

	    		    	alert.showAndWait();
	    		    
	    		}
	    		
	    	});
	    	VBox root = new VBox();
	    	root.getChildren().addAll(lbl1,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8);
	    	root.setSpacing(15);
			root.setPadding(new Insets(15,45,45,45));
	    	this.setScene(new Scene(root));
	    	this.show();
	    }
}

	