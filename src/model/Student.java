package model;

import java.util.ArrayList;

public class Student extends User {

	private int index;
	private double gpa;
	private int schoolYear;
	private String faculty;
	private String parent;
	private String email;
	private String address;
	private int telephone;
	private String birthday;

	private double account;
	public static Student loggedIn;
	private ArrayList<Exam> examEntry;

	public Student(int id, String jmbg, String firstName, String lastName, String username, String password, int index, String faculty, int schoolYear, String parent, int telephone, String email, String address, double account, ArrayList<Exam> examEntry, String birthday) {
		super(id, jmbg, firstName, lastName, username, password);
		this.index = index;
		this.faculty = faculty;
		this.schoolYear = schoolYear;
		this.parent = parent;
		this.email = email;
		this.address = address;
		this.account = account;
		this.examEntry = new ArrayList<Exam>();
		this.setBirthday(birthday);
		
	}
	

	public static Student getLoggedIn() {
		return loggedIn;
	}


	public static void setLoggedIn(Student loggedIn) {
		Student.loggedIn = loggedIn;
	}


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(int schoolYear) {
		this.schoolYear = schoolYear;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	};

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	
	public int getTelephone() {
		return telephone;
	}


	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "Student [Id=" + getId() + ", JMBG=" + getJmbg() + ", First Name=" + getFirstName() + ", Last Name=" + getLastName()
				+ ", Username=" + getUsername() + ", Password=" + getPassword() + ", Index=" + index+", Faculty=" + faculty + ", School Year=" + schoolYear + ", Parent="+parent+", Telephone="+telephone+", Email=" +email+", Address="+address+", Account=" + account +"]";
	}
	
	@Override
	public String toFile() {
		return getId() + "|" + getJmbg() + "|" + getFirstName() + "|" + getLastName()
		+ "|" + getUsername() + "|" + getPassword() + "|" + getIndex()+"|" + getFaculty() + "|" + getSchoolYear() + "|"+getParent()+"|"+getTelephone()+"|" +getEmail()+"|"+getAddress()+"|"+ getAccount();
	}


	public ArrayList<Exam> getExamEntry() {
		return examEntry;
	}


	public void setExamEntry(ArrayList<Exam> examEntry) {
		this.examEntry = examEntry;
	}
	

}
