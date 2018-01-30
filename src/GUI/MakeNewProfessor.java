package GUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import utility.Utilities;

public class MakeNewProfessor extends Stage{
	
	public String JMBG;
	public String ID;
	public String name;
	public String surname;
	public String date;
	public String faculty;
	public String subject;
	public String password;
	public String profType;
	{
		this.setTitle("Create a New Professor");
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(15,45,45,45));
		vb.setSpacing(10);
		
		Label lbl = new Label("Please enter the information for the professor");
		vb.getChildren().add(lbl);
		
		TextField text1 = new TextField();
		text1.setPromptText("ID");
		vb.getChildren().add(text1);
		
		TextField text2 = new TextField();
		text2.setPromptText("JMBG");
		vb.getChildren().add(text2);
		
		TextField text3 = new TextField();
		text3.setPromptText("Name");
		vb.getChildren().add(text3);
	    
	    TextField text4 = new TextField();
	    text4.setPromptText("Last name");
    	vb.getChildren().add(text4);
    	
    	ComboBox<String> cb = new ComboBox<>();
	    cb.setPromptText("Choose type");
	    cb.getItems().setAll("FULL_PROFESSOR","ASSOCIATE_PROFESSOR", "DOCENT");
	    vb.getChildren().add(cb);
    	
    	
    	
    	DatePicker datePicker = new DatePicker();
    	vb.getChildren().add(datePicker);
    	
    	ComboBox<String> cb1 = new ComboBox<>();
	    cb1.setPromptText("Choose faculty");
	    cb1.getItems().setAll("SII", "IT");
	    vb.getChildren().add(cb1);
    	
    	TextField text6 = new TextField();
    	text6.setPromptText("Subject");
    	vb.getChildren().add(text6);
    	
    	Button btn1 = new Button("Create");
    	 btn1.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent e) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					close();
					String check1 = text1.getText();
					if(Utilities.checkProfID(check1)){
						String check2 = text2.getText();
						if(Utilities.checkProfJMBG(check2)){
							ID = text1.getText();
							JMBG = text2.getText();
							password = Utilities.passwordGenerator();
							 name = text3.getText();
							 surname = text4.getText();
							 date = formatter.format(datePicker.getValue());
							 faculty = cb1.getValue();
							 profType = cb.getValue();
							 subject = text6.getText();
							 //username is jmbg
							 //randomly generated password
							 
							 String full_prof = ID+"|"+ JMBG +"|" + JMBG + "|" + password+  "|" +name +"|"+surname+ "|" + profType + "|"+date+"|"+ faculty + "|" + subject;
								
								try(FileWriter fw = new FileWriter("src/data/Professor.txt", true);
										BufferedWriter bw = new BufferedWriter(fw);
										Scanner user_input = new Scanner(System.in);
										PrintWriter pw = new PrintWriter(bw))
											{
									pw.println(full_prof);
									pw.flush();
									pw.close();
											} catch (IOException e1) {
												e1.printStackTrace();
											}
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Action Complete");
								alert.setContentText("You have succesfully added a new professor");
								 alert.showAndWait();
						}
						else{
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Action Foreit");
							alert.setContentText("A professor with that JMBG already exists");
							alert.showAndWait();
						}
					}
					else{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Action Forfeit");
						alert.setContentText("A professor with that ID already exists");
						alert.showAndWait();
					}
    	
	}

    	 });
    	 vb.getChildren().add(btn1);
    	 
    	 Scene scene = new Scene(vb);
    	 this.setScene(scene);
    	 this.showAndWait();
	}
}
