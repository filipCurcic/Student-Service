package application;

import java.io.IOException;

import java.util.ArrayList;

import utility.Utilities;
import model.Admin;
import model.Exam;
import model.Grade;
import model.Professor;
import model.Student;
import model.Subject;

public class Application  {

	private static ArrayList<Admin> admins;
	private static ArrayList<Professor> professors;
	private static ArrayList<Student> students;
	private static ArrayList<Subject> subjects;
	private static ArrayList<Exam> applied;
	private static ArrayList<Exam> exams;
	private static ArrayList<Grade> grades;
	public static String ulogovan;

	//---Getters and Setters for Users and Data---//
	public static ArrayList<Admin> getAdmins() {
		return admins;
	}

	public static void setAdmins(ArrayList<Admin> admins) {
		Application.admins = admins;
	}

	public static ArrayList<Exam> getExams() {
		return exams;
	}

	public static void setExams(ArrayList<Exam> exams) {
		Application.exams = exams;
	}

	public static ArrayList<Exam> getApplied() {
		return applied;
	}

	public static void setApplied(ArrayList<Exam> applied) {
		Application.applied = applied;
	}

	public static ArrayList<Grade> getGrades() {
		return grades;
	}

	public static void setGrades(ArrayList<Grade> grades) {
		Application.grades = grades;
	}

	public static ArrayList<Professor> getProfessors() {
		return professors;
	}

	public static void setProfessors(ArrayList<Professor> professors) {
		Application.professors = professors;
	}

	public static ArrayList<Student> getStudents() {
		return students;
	}

	public static void setStudents(ArrayList<Student> students) {
		Application.students = students;
	}

	public static ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public static void setSubjects(ArrayList<Subject> subjects) {
		Application.subjects = subjects;
	}

	
//---Read all data function---//
public static void readAllData() throws IOException {
			professors = Utilities.readProfessors();
			students = Utilities.readStudent();
			subjects = Utilities.readSubjects();
			admins = Utilities.readAdmin();
			applied = Utilities.readProof();
			exams = Utilities.readExams();
			grades = Utilities.readGrades();
	}
	
////---Run---//
//	public void run(){
//		try {
//			readAllData();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			logIn.login();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public static void main(String[] args) throws IOException{
//		Application ap = new Application();
//		ap.run();
//
//	}




}
