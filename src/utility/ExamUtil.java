package utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.text.SimpleDateFormat;

import utility.Utilities;
import model.Exam;
import model.Student;

public class ExamUtil {
	public static ArrayList<Exam> proof;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY.");


	//---Index validation, File Clear, Refund and Date Check for removing Tests---//
	public static boolean checkIndex(Exam chosenExam){
		if(chosenExam.getIndex() == Student.getLoggedIn().getIndex()){
			return true;
		}
		else{
			return false;
		}
	}
	public static void clearTheFile() throws IOException {
        FileWriter fwOb = new FileWriter("src/data/AppliedTests.txt", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }
	public static void returnCash(){
			double value1 =  Student.loggedIn.getAccount();
			double value2 = (value1 + 400.00);
			Student.loggedIn.setAccount(value2);
			Utilities.writeToFile(Application.getStudents(),"Student");
		
	}
	public static boolean checkRemovalDate(Exam chosenExam){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String examDate = chosenExam.getDate().substring(0, 2);
		int result = (Integer.valueOf(examDate) - day);
		if(result <= 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	//----Functions for finalizing application of test---//
	public static boolean deductAccount() {
		if(checkAccount()){
			double value1 =  Student.loggedIn.getAccount();
			double value2 = (value1 - 200.00);
			Student.loggedIn.setAccount(value2);
			Utilities.writeToFile(Application.getStudents(),"Student");
			return true;
				
			
		}
		else{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setContentText("You don't have enough funds for this!");
			alert.showAndWait();
			return false;
		}
	}	
	public static void addtoAppliedTest(Exam chosenExam) throws IOException {
		Student.getLoggedIn().getExamEntry().add(chosenExam);
		addtofileAppliedTests();
	}
	public static void addtofileAppliedTests() throws IOException{
		try(FileWriter fw = new FileWriter("src/data/AppliedTests.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw))
					{
			for (Exam e : Student.getLoggedIn().getExamEntry()) {
				   pw.println(e.toFile());
				}
			Student.getLoggedIn().getExamEntry().clear();
			pw.flush();
			pw.close();
					}
	}
	
	//-----Functions for checking tests, account and exam time----//
	public static boolean checkTests(Exam chosenExam) throws IOException{
		List<Integer> exams = new ArrayList<Integer>();
		for(Exam e : Application.getApplied()){
			exams.add(e.getId());
		}
		if(exams.contains(chosenExam.getId())){
			return false;
		}
		else{
			if(deductAccount()){
				return true;
			}
		}
		return false;
		
	}
	public static boolean checkAccount(){
		double acc = Student.loggedIn.getAccount();
		if(acc > 400.00){
			return true;
		}
		else{
			return false;
		}
	}

}
