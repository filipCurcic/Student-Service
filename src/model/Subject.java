package model;

public class Subject implements Writable {

	private int id;
	private String name;
	private String department;
	private int weekly;
	private String professor;

	public Subject(String name, String department, int weekly, String professor,int id) {
		this.setId(id);
		this.name = name;
		this.department = department;
		this.weekly = weekly;
		this.professor = professor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getWeekly() {
		return weekly;
	}

	public void setWeekly(int weekly) {
		this.weekly = weekly;
	}
	
	public String getProfessor() {
		return professor;
	}
	
	public void setProfessor(String professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return " [Name=" + name + ", Department=" + department + "]" ;
	}

	@Override
	public String toFile() {
		return name + "|" + department + "|" + weekly ;				
	}

}
