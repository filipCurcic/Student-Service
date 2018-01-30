package GUI;

import java.io.BufferedWriter;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Professor;
import utility.Utilities;

public class CreateSubject extends Stage{
	
	public String Name;
	public String ID;
	
	{
		this.setTitle("Create a New Subject");
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(15,45,45,45));
		vb.setSpacing(10);
		
		TextField text1 = new TextField();
		text1.setPromptText("Name");
		vb.getChildren().add(text1);
		
		TextField text2 = new TextField();
		text2.setPromptText("ID");
		vb.getChildren().add(text2);
		
		ComboBox<String> cb = new ComboBox<>();
	    cb.setPromptText("Choose a Faculty");
	    cb.getItems().setAll("SII","IT");
	    vb.getChildren().add(cb);
	    
	    TextField tx3 = new TextField();
	    tx3.setPromptText("Weekly");
    	vb.getChildren().add(tx3);
    	
    	ComboBox<String> cb1 = new ComboBox<>();
    	cb1.setPromptText("Choose a professor");
    	
    	
    	
    	List<String> listap = new ArrayList<String>();
    	for (Professor prof : Application.getProfessors()) {
    		listap.add(prof.getFirstName() + " " + prof.getLastName());
    	}
    	cb1.getItems().setAll(listap);
    	vb.getChildren().add(cb1);
    	
    	Button btn1 = new Button("Create");
    	 btn1.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent e) {
					close();
					String check1 = text1.getText();
					if(Utilities.checkSubjectName(check1)){
						String check2 = text2.getText();
						if(Utilities.checkSubjectID(check2)){
							Name = text1.getText();
							ID = text2.getText();
						}
						else{
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Action Foreit");
							alert.setContentText("A subject with that ID already exists");
						}
					}
					else{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Action Forfeit");
						alert.setContentText("A subject with that name exists already");
					}
					String faculty = cb.getValue();
					String week = tx3.getText();
					String prof = cb1.getValue();
					
					String full_sub = Name+"|"+ faculty + "|" +week +"|"+prof+"|"+ID;
					
					try(FileWriter fw = new FileWriter("src/data/Subjects.txt", true);
							BufferedWriter bw = new BufferedWriter(fw);
							Scanner user_input = new Scanner(System.in);
							PrintWriter pw = new PrintWriter(bw))
								{
						pw.println(full_sub);
						pw.flush();
						pw.close();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Action Complete");
					alert.setContentText("You have succesfully added a new subject");
					 alert.showAndWait();
    	
	}

    	 });
    	 vb.getChildren().add(btn1);
    	 
    	 Scene scene = new Scene(vb);
    	 this.setScene(scene);
    	 this.showAndWait();
	}
}
