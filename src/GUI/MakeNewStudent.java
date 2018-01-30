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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import utility.Utilities;

public class MakeNewStudent extends Stage{
	
	public String ID;
	public String Index;
	public String Parent;
	public String JMBG;
	public String name;
	public String surname;
	public String address;
	public String email;
	public String tele;
	public String Fac;
	public String date;
	{
		this.setTitle("Create a New Student");
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(15,45,45,45));
		vb.setSpacing(10);
		
		Label lbl = new Label("Please enter the information for the student");
		vb.getChildren().add(lbl);
		
		TextField text1 = new TextField();
		text1.setPromptText("ID");
		vb.getChildren().add(text1);
		
		TextField text2 = new TextField();
		text2.setPromptText("Index");
		vb.getChildren().add(text2);
		
		TextField text3 = new TextField();
		text3.setPromptText("Parent");
		vb.getChildren().add(text3);
	    
	    TextField text4 = new TextField();
	    text4.setPromptText("JMBG");
    	vb.getChildren().add(text4);
    	
    	TextField text5 = new TextField();
    	text5.setPromptText("Name");
    	vb.getChildren().add(text5);
    	
    	TextField text6 = new TextField();
    	text6.setPromptText("Last name");
    	vb.getChildren().add(text6);
    	
    	TextField text7 = new TextField();
    	text7.setPromptText("Address");
    	vb.getChildren().add(text7);
    	
    	TextField text8 = new TextField();
    	text8.setPromptText("Email");
    	vb.getChildren().add(text8);
    	
    	TextField text9 = new TextField();
    	text9.setPromptText("Phone number");
    	vb.getChildren().add(text9);
    	
    	
    	DatePicker datePicker = new DatePicker();
    	vb.getChildren().add(datePicker);
    	
    	ComboBox<String> cb = new ComboBox<>();
	    cb.setPromptText("Choose a Faculty");
	    cb.getItems().setAll("SII","IT");
	    vb.getChildren().add(cb);
    	
	    
    	Button btn1 = new Button("Create");
    	 btn1.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent e) {
					close();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String check1 = text1.getText();
					if(Utilities.checkIDStudent(check1)){
						String check2 = text2.getText();
						if(Utilities.checkIndexStudent(check2)){
							String check3 = text4.getText();
							if(Utilities.checkJMBGStudent(check3)){
								
								ID = text1.getText();
								Index = text2.getText();
								Parent = text3.getText();
								JMBG = text4.getText();
								name = text5.getText();
								surname = text6.getText();
								address = text7.getText();
								email = text8.getText();
								tele = text9.getText();
								Fac = cb.getValue();
								date = formatter.format(datePicker.getValue());
								
								String username = Index;
								String password = Utilities.passwordGenerator();
								int YoS = 1;
								String full_stud = ID+"|"+ JMBG + "|" +name +"|"+surname+"|"+username+"|"+ password + "|" + Index + "|" + Fac + "|" + YoS + "|" + Parent + "|" + 
								tele + "|" + email + "|" + address + "|" +400 + "|" + date;
								
								try(FileWriter fw = new FileWriter("src/data/Student.txt", true);
										BufferedWriter bw = new BufferedWriter(fw);
										Scanner user_input = new Scanner(System.in);
										PrintWriter pw = new PrintWriter(bw))
											{
									pw.println(full_stud);
									pw.flush();
									pw.close();
											} catch (IOException e1) {
												e1.printStackTrace();
											}
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Action Complete");
								alert.setContentText("You have succesfully added a new student");
								 alert.showAndWait();
							}
							else{
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Action Foreit");
								alert.setContentText("A student with that JMBG already exists");
								alert.showAndWait();
							}
						}
						else{
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Action Foreit");
							alert.setContentText("A student with that Index already exists");
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

