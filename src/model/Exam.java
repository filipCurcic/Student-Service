package model;

public class Exam implements Writable {

	public enum ExamType {
		ORAL_EXAM, TEST, PRACTICE
	}

	public enum Status {
		REGULAR, NOT_REGULAR
	}

	private int id;
	private ExamType type;
	private Status status;
	private String date;
	private String classroom;
	private Subject subject;
	private int index;
	private String faculty;

	public Exam(int id, ExamType type, Status status, String date, String classroom, Subject subject,String faculty, int index) {
		this.id = id;
		this.type = type;
		this.status = status;
		this.date = date;
		this.classroom = classroom;
		this.subject = subject;
		this.index = index;
		this.faculty = faculty;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public ExamType getType() {
		return type;
	}

	public void setType(ExamType type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Exam [ID=" + id + ", Type=" + type + ", Status=" + status + ", Date=" + date + ", Classroom="
				+ classroom + ", Subject: " + subject.getName()+ ", Index of Student:"+ index+"]";
	}
	
	@Override
	public String toFile() {
		return id + "|" + String.valueOf(type) + "|" + String.valueOf(status) + "|" + date + "|"
				+ classroom + "|" + subject.getName() + "|" +Student.getLoggedIn().getFaculty()+"|"+ Student.getLoggedIn().getIndex();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}


}
