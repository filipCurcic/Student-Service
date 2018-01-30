package GUI;

import java.util.ArrayList;
import application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Exam;

public class ViewAppliedTests extends Stage{
	{
		this.setTitle("Applied Tests");
		VBox vb = new VBox();
		vb.setSpacing(15);
		vb.setPadding(new Insets(15,45,45,45));
		
		ArrayList<Exam> applied = Application.getApplied();
		
		Label label = new Label();
		
		for(Exam e:applied){
			label.setText(label.getText()+"Exam ID:"+e.getId() + ", Exam Classroom:"+e.getClassroom()+", Subject:"+e.getSubject().getName()+", Exam Date:"+e.getDate()+", Student Index:"+e.getIndex()+"\n");
		}
		vb.getChildren().add(label);
		
		Scene scene = new Scene(vb);
		this.setScene(scene);
		this.showAndWait();
	}
}
