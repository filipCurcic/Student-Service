package GUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Exam;
import model.Subject;

public class EnterGrades extends Stage {
	public String grade;
	public String firstName;
	public String lastName;
	public int index;
	public Subject subject;
	public int examID;
	{
		this.setTitle("Enter Grades");
		VBox vb = new VBox();
		vb.setSpacing(15);
		vb.setPadding(new Insets(15,45,45,45));
		
		HBox hb = new HBox();
		
		ComboBox<Exam> cb = new ComboBox<>();
	    cb.setPromptText("Choose an Exam to Enter Marks");
	    cb.getItems().setAll(Application.getApplied());
	    vb.getChildren().add(cb);
	    
	    TextField txt1 = new TextField();
	    vb.getChildren().add(txt1);
	    
	    Button btn1 = new Button("Apply");
	    btn1.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				close();
				final Exam chosenExam;
			    chosenExam = cb.getValue();
			    
			    try(FileWriter fw = new FileWriter("src/data/Grades.txt", true);
						BufferedWriter bw = new BufferedWriter(fw);
						Scanner user_input = new Scanner(System.in);
						PrintWriter pw = new PrintWriter(bw))
							{
					pw.println(chosenExam.getId()+"|"+chosenExam.getType()+"|"+chosenExam.getStatus()+"|"+chosenExam.getDate()+"|"+chosenExam.getClassroom()+"|"+chosenExam.getSubject().getName()+"|"+chosenExam.getFaculty()+"|"+chosenExam.getIndex()+"|"+txt1.getText());
					pw.flush();
					pw.close();
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
