package utility;


import model.Admin;
import model.Exam;
import model.Professor;
import model.Subject;
import model.Exam.ExamType;
import model.Exam.Status;
import model.Grade;
import model.Professor.ProfessorStatus;
import model.Student;
import utility.SearchUtility;

public class DataMap {

	
	public static Professor makeProfessor(String line) {
		String[] data = line.split("\\|");
		int id = Integer.parseInt(data[0]);
		String jmbg = data[1];
		String firstname = data[2];
		String lastname = data[3];
		String username = data[4];
		String password = data[5];
		ProfessorStatus status = ProfessorStatus.valueOf(data[6]);
		String date = data[7];
		String faculty = data[8];
		return new Professor(id, jmbg, username, password, firstname, lastname,status,date,faculty);
	}
	
	public static Admin makeAdmin(String line) {
		String[] data = line.split("\\|");
		int id = Integer.parseInt(data[0]);
		String jmbg = data[1];
		String firstName = data[2];
		String lastName = data[3];
		String username = data[4];
		String password = data[5];
		return new Admin(id, jmbg, firstName, lastName, username, password);
	}
	
	public static Student makeStudent(String line) {
		String[] data = line.split("\\|");
		int id = Integer.parseInt(data[0]);
		String jmbg = data[1];
		String firstName = data[2];
		String lastName = data[3];
		String username = data[4];
		String password = data[5];
		int index = Integer.parseInt(data[6]);
		String faculty = data[7];
		int schoolYear =  Integer.parseInt(data[8]);
		String parent = data[9];
		int telephone = Integer.parseInt(data[10]);
		String email = data[11];
		String address = data[12];
		double account = Double.parseDouble(data[13]);
		String birthday = data[14];
		return new Student(id, jmbg, firstName, lastName, username, password, index,  faculty, schoolYear, parent, telephone, email, address, account, null, birthday);
	}

	public static Exam makeExam(String line) {
		String[] data = line.split("\\|");
		int id = Integer.parseInt(data[0]);
		ExamType type = ExamType.valueOf(data[1]);
		Status status = Exam.Status.valueOf(data[2]);
		String date = data[3];
		String classroom = data[4];
		Subject subject = SearchUtility.findSubjectByName(data[5]);
		String faculty = data[6];
		int index = Integer.parseInt(data[7]);
		return new Exam(id, type, status, date, classroom, subject,faculty, index);

	}
	
	public static Exam makeProof(String line){
		String[] data = line.split("\\|");
		int id = Integer.parseInt(data[0]);
		ExamType type = ExamType.valueOf(data[1]);
		Status status = Exam.Status.valueOf(data[2]);
		String date = data[3];
		String classroom = data[4];
		Subject subject = SearchUtility.findSubjectByName(data[5]);
		String faculty = data[6];
		int index = Integer.parseInt(data[7]);
		return new Exam(id, type, status, date, classroom, subject,faculty,index);
	}
	
	public static Grade makeGrades(String line){
		String[] data = line.split("\\|");
		int id = Integer.parseInt(data[0]);
		ExamType type = ExamType.valueOf(data[1]);
		Status status = Exam.Status.valueOf(data[2]);
		String date = data[3];
		String classroom = data[4];
		Subject subject = SearchUtility.findSubjectByName(data[5]);
		String faculty = data[6];
		int index = Integer.parseInt(data[7]);
		String grade = data[8];
		return new Grade(id,type,status,date,classroom,subject,faculty,index,grade);
	}

	public static Subject makeSubject(String line) {
		String[] data = line.split("\\|");
		String name = data[0];
		String fac = data[1];
		int weekly = Integer.parseInt(data[2]);
		String prof = data[3];
		int id = Integer.parseInt(data[4]);
		return new Subject(name, fac, weekly, prof,id);
	}
}
