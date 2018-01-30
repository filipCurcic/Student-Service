package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import application.Application;
import model.Admin;
import model.Exam;
import model.Grade;
import model.Professor;
import model.Student;
import model.Subject;
import model.Writable;


public class Utilities {
	
//--- ID + JMBG + Index validation for Student---//
public static boolean checkIDStudent(String check1){
	List<Integer> StudID = new ArrayList<Integer>();
	for(Student s : Application.getStudents()){
		StudID.add(s.getId());
	}
	if(StudID.contains(Integer.valueOf(check1))){
		return false;
	}
	else{
		return true;
	}
}
public static boolean checkJMBGStudent(String check3){
	List<String> JMBGStud = new ArrayList<String>();
	for(Student s : Application.getStudents()){
		JMBGStud.add(s.getJmbg());
	}
	if (JMBGStud.contains(check3)){
		return false;
	}
	else{
		return true;
	}
}
public static boolean checkIndexStudent(String check2){
	List<Integer> indexes = new ArrayList<Integer>();
	for(Student s : Application.getStudents()){
		indexes.add(s.getIndex());
	}
	if(indexes.contains(Integer.valueOf(check2))){
		return false;
	}
	else{
		return true;
	}
}

//--- ID + JMBG validation for Professor---//
public static boolean checkProfJMBG(String check2){
	List<String> profJMBG = new ArrayList<String>();
	for (Professor p : Application.getProfessors()){
		profJMBG.add(p.getJmbg());
	}
	if (profJMBG.contains(check2)){
		return false;
	}
	else{
		return true;
	}
}
public static boolean checkProfID(String check1){
	List<Integer> ProfID = new ArrayList<Integer>();
	for(Professor p : Application.getProfessors()){
		ProfID.add(p.getId());
	}
	if(ProfID.contains(Integer.valueOf(check1))){
		return false;
	}
	else{
		return true;
	}
}

//--- ID + Name validation for Subject--//
//---ID + Name validation---//
public static boolean checkSubjectID(String check2){
	List<Integer> subID = new ArrayList<Integer>();
	for(Subject s : Application.getSubjects()){
		subID.add(s.getId());
	}
	if(subID.contains(Integer.valueOf(check2))){
		return false;
	}
	else{
		return true;
	}
}
public static boolean checkSubjectName(String check1){
	List<String> subName = new ArrayList<String>();
	for(Subject s : Application.getSubjects()){
		subName.add(s.getName());
	}
	if(subName.contains(check1)){
		return false;
	}
	else{
		return true;
	}
}


//----Functions for writing to file and path return----//
public static void writeToFile(ArrayList<? extends Writable> writable, String filename) {
	String path = getRelativePath(filename);
	File f = new File(path);
	if (!f.exists()) {
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	PrintWriter out;
	try {
		out = new PrintWriter(new FileWriter(path));
		for (Writable w : writable)
			out.println(w.toFile());
		out.flush();
		out.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public static String getRelativePath(String fileName) {
	return "src" + File.separator + "data" + File.separator + fileName + ".txt";
}

//-----Functions for Reading Txt Files------//
private static ArrayList<String> readLines(String filename) {

	try {
		String path = getRelativePath(filename);
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("File '" + filename + "' does not exist!");
			return null;
		}

		BufferedReader in = new BufferedReader(new FileReader(path));
		String line;
		ArrayList<String> ret = new ArrayList<>();
		while ((line = in.readLine()) != null) { 
			ret.add(line.trim());
		}
		in.close();
		return ret;

	} catch (Exception e) {
		System.out.println("Something went wrong with file " + filename + "!");
		e.printStackTrace();
		return null;
	}
}
public static ArrayList<Professor> readProfessors() {
	ArrayList<Professor> ret = new ArrayList<>();
	ArrayList<String> lines = readLines("Professor");
	for (String line : lines) {
		ret.add(DataMap.makeProfessor(line));
	}
	return ret;
}
public static ArrayList<Admin> readAdmin() {
	ArrayList<Admin> ret = new ArrayList<>();
	ArrayList<String> lines = readLines("Admins");
	for (String line : lines) {
		ret.add(DataMap.makeAdmin(line));
	}
	return ret;
}
public static ArrayList<Student> readStudent() {
	ArrayList<Student> ret = new ArrayList<>();
	ArrayList<String> lines = readLines("Student");
	for (String line : lines) {
		ret.add(DataMap.makeStudent(line));
		}
	return ret;
}
public static ArrayList<Subject> readSubjects() {
	ArrayList<Subject> ret = new ArrayList<>();
	ArrayList<String> lines = readLines("Subjects");
	for (String line : lines) {
		ret.add(DataMap.makeSubject(line));
	}
	return ret;
}
public static ArrayList<Exam> readExams() {
	ArrayList<Exam> ret = new ArrayList<>();
	ArrayList<String> lines = readLines("Exams");
	for (String line : lines) {
		ret.add(DataMap.makeExam(line));
	}
	return ret;
}
public static ArrayList<Exam> readProof(){
	ArrayList<Exam> ret = new ArrayList<>();
	ArrayList<String> lines = readLines("AppliedTests");
	for (String line : lines){
		ret.add(DataMap.makeProof(line));
	}
	return ret;
}
public static ArrayList<Grade> readGrades(){
	ArrayList<Grade> ret = new ArrayList<>();
	ArrayList<String> lines = readLines("Grades");
	for (String line:lines){
		ret.add(DataMap.makeGrades(line));
	}
	return ret;
}

public static String passwordGenerator() {
	String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	SecureRandom rnd = new SecureRandom();
    StringBuilder sb = new StringBuilder(10);
    for( int i = 0; i < 10; i++ ) {
	    sb.append(AB.charAt(rnd.nextInt(AB.length())));
    }
    return sb.toString();


}


public static void SurnameDisplay() throws IOException{
	List<String> surname = new ArrayList<String>();
	for (Student s : Application.getStudents()){
		surname.add(s.getLastName());
	}
	java.util.Collections.sort(surname);
	int i = 0;
	while(surname.size() > i){
		for (Student s : Application.getStudents()){
			if (s.getLastName().equals(surname.get(i))){
				System.out.println("Name:" + s.getFirstName() + ", Surname:" + s.getLastName() + ", Index:" + s.getIndex());
			}
		}
		i++;
	}
}

}




