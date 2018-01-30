package utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import application.Application;
import model.Student;
import model.Subject;

public class SearchUtility {
	static Scanner sc = new Scanner(System.in);
	public static Student foundStudent;
	public static int index;
	public static Subject subject;
	public static int examID;
	public static int grade;
	public static String firstName;
	public static String lastName;
	
	//---Data mapping utility for Finding Subject Name---//
	public static Subject findSubjectByName(String name) {
		for (Subject s : Application.getSubjects()) {
			if (s.getName().equals(name)){
				return s;
			}
		}
		return null;
	}
	
	//---Write Grades ToFile() and Return Name + Surname for Entering Grades---//	
	public static void writeGrades() throws IOException{
		try(FileWriter fw = new FileWriter("src/data/Grades.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				Scanner user_input = new Scanner(System.in);
				PrintWriter pw = new PrintWriter(bw))
					{
			pw.println("Student index: "+index +", Name:"+firstName+", Surname:"+lastName+", Student's grade: "+ grade+"%" +", Exam ID:"+examID+ ", Subject: " + subject );
			pw.flush();
			pw.close();
					}
	}
	public static void returnNameSurname(){
		for(Student student : Application.getStudents()){
			if (student.getIndex() == index){
				firstName = student.getFirstName();
				lastName =student.getLastName();
			}
		}
	}
}

