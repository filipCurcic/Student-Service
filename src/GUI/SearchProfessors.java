package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchProfessors extends Stage{
	{
		this.setTitle("Search Professors");
		VBox vb = new VBox();
		vb.setSpacing(15);
		vb.setPadding(new Insets(15,45,45,45));
		
		ComboBox<String> cb = new ComboBox<>();
	    cb.setPromptText("Choose what to Search By");
	    cb.getItems().setAll("Surname","ID");
	    vb.getChildren().add(cb);
	    
	    Button btn = new Button("Choose");
	    btn.setOnAction(new EventHandler<ActionEvent>(){
	    	public void handle(ActionEvent arg0) {
	    		if(cb.getValue().toLowerCase().equals("surname")){
	    			new SearchProfessorBySurname();
	    		}
	    		else if(cb.getValue().toLowerCase().equals("ID")){
	    			new SearchProfessorByID();
	    		}
	    	}
	    	
	    });
	    vb.getChildren().add(btn);
	    
	    Scene scene = new Scene(vb);
		this.setScene(scene);
		this.showAndWait();
	}
}
