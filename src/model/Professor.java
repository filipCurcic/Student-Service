package model;

public class Professor extends User {

	private String faculty;
	private ProfessorStatus status;

	public enum ProfessorStatus {
		FULL_PROFESSOR, ASSOCIATE_PROFESSOR, DOCENT
	}

	public Professor(int id, String jmbg, String username, String password, String firstName, String lastName,
	 ProfessorStatus status, String date,String faculty) {
		super(id, jmbg,username,password,firstName,lastName);
		this.status = status;
		this.faculty = faculty;
	}

	public String getfaculty() {
		return faculty;
	}

	public void setfaculty(String faculty) {
		this.faculty = faculty;
	}

	public ProfessorStatus getStatus() {
		return status;
	}

	public void setStatus(ProfessorStatus status) {
		this.status = status;
	}
	

}
