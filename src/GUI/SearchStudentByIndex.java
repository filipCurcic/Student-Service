package GUI;

import application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Student;

public class SearchStudentByIndex extends Stage {
	public Student foundStudent;
	public int Index;
	{
		this.setTitle("Search Students by Index");
		VBox vb = new VBox();
		vb.setSpacing(15);
		vb.setPadding(new Insets(15,45,45,45));
		
		TextField txt1 = new TextField("Index...");
		vb.getChildren().add(txt1);
		
		TextArea area = new TextArea();
		vb.getChildren().add(area);
		
		Button srch = new Button("Search");
		srch.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent arg0) {
				Index = Integer.valueOf(txt1.getText());
				for (Student student : Application.getStudents()) {
					if ((student.getIndex() == Index)){
						foundStudent = student;
						area.setText(foundStudent.toString());
					}
					
				}
					}
		});
		vb.getChildren().add(srch);
		
		Scene scene = new Scene(vb);
   	 	this.setScene(scene);
   	 	this.showAndWait();
	}
}
