package GUI;

import java.util.ArrayList;

import application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Student;

public class SortStudent extends Stage {
	{
		this.setTitle("Sorting by Surname");
		VBox vb = new VBox();
		vb.setSpacing(15);
		vb.setPadding(new Insets(15,45,45,45));
		
		ArrayList<Student> students = Application.getStudents();
		
		Label label = new Label();
		
		students.sort((o1,o2) -> o1.getLastName().compareTo(o2.getLastName()));
		
		for(Student s:students){
			label.setText(label.getText()+s.getFirstName() + ", "+s.getLastName()+", "+s.getIndex()+"\n");
		}
		vb.getChildren().add(label);
		
		Scene scene = new Scene(vb);
		this.setScene(scene);
		this.showAndWait();
	}
}
