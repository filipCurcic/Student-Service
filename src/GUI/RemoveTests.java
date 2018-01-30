package GUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Exam;
import utility.ExamUtil;
import utility.Utilities;
import javafx.scene.Scene;

public class RemoveTests extends Stage{
	{
		this.setTitle("Remove an Applied Test");
		VBox vb = new VBox();
		vb.setSpacing(15);
		vb.setPadding(new Insets(15,45,45,45));
		
		ComboBox<Exam> cb = new ComboBox<>();
	    cb.setPromptText("Choose An Exam");
	    cb.getItems().setAll(Application.getApplied());
	    vb.getChildren().add(cb);
	    
	    Button btn1 = new Button("Remove");
	    btn1.setOnAction(new EventHandler<ActionEvent>(){
	    	public void handle(ActionEvent arg0) {
				close();
				final Exam chosenExam;
			    chosenExam = cb.getValue();
			    try{
			    	if(ExamUtil.checkRemovalDate(chosenExam)){
			    		if(ExamUtil.checkIndex(chosenExam)){
			    			ArrayList<Exam> exams;
			    			exams = Utilities.readProof();
			    			exams.remove(cb.getValue());
							try(FileWriter fw = new FileWriter("src/data/AppliedTests.txt", true);
									BufferedWriter bw = new BufferedWriter(fw);
									PrintWriter pw = new PrintWriter(bw))
										{
								ExamUtil.clearTheFile();
								for (Exam e : exams) {
									pw.println(e.toFile());
									}
								exams.clear();
								pw.flush();
								pw.close();
										}
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Action Complete");
							alert.setContentText("You have succesfully removed the test");
			    		}
			    		else{
			    			Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Action Forfeit");
							alert.setContentText("You cannot remove another student's test");
			    		}
			    	}
			    	else{
			    		Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Action Forfeit");
						alert.setContentText("You may not cancel a test one day before!");
			    	}
			    }catch(IOException e){
			    	e.printStackTrace();
			    }
	    }
	    });
	    vb.getChildren().add(btn1);
	    Scene scene = new Scene(vb);
	    this.setScene(scene);
	    this.showAndWait();
}
}