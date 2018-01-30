package GUI;

import java.io.IOException;

import application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Exam;
import utility.ExamUtil;

public class ApplyForTest extends Stage {
	{
		this.setTitle("Apply for Test");
		VBox vb = new VBox();
		vb.setSpacing(15);
		vb.setPadding(new Insets(15,45,45,45));
		
		HBox hb = new HBox();
		
		ComboBox<Exam> cb = new ComboBox<>();
	    cb.setPromptText("Choose An Exam");
	    cb.getItems().setAll(Application.getExams());
	    vb.getChildren().add(cb);
	    
	    Button btn1 = new Button("Apply");
	    btn1.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				close();
				final Exam chosenExam;
			    chosenExam = cb.getValue();
			    try {
					if(ExamUtil.checkTests(chosenExam)){
						ExamUtil.addtoAppliedTest(chosenExam);
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Action Completed");
						alert.setContentText("You have succesfully applied for this test");
						alert.showAndWait();
					}
					else{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Error");
						alert.setContentText("You have already applied for this test");
						alert.showAndWait();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	    	
	    });
	    hb.getChildren().add(btn1);
	    vb.getChildren().add(hb);
	    
	    Scene scene = new Scene(vb);
	    this.setScene(scene);
	    this.showAndWait();
	}
}
