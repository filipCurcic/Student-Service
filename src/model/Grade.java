package model;

public class Grade extends Exam {
	
	private String grade;

	public Grade(int id, ExamType type, Status status, String date, String classroom, Subject subject, String faculty,int index,String grade) {
		super(id, type, status, date, classroom, subject, faculty, index);
		this.grade=grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
