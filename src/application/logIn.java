package application;


import model.Admin;
import model.Professor;
import model.Student;
import GUI.StudentMenu;
import GUI.AdminMenu;
import GUI.ProfessorMenu;
import application.Application;




public class logIn {
	
	
	public static String ulogovan;

	//---Functions for logging in---//
		public static String checkLog(String userName, String passWord){
			for (Admin admin : application.Application.getAdmins()){
				if (admin.getUsername().equals(userName) && admin.getPassword().equals(passWord)){
					Admin.AdloggedIn = admin;
					new AdminMenu();
					ulogovan = "Admin";
					return ulogovan;
				}
			}
			for (Student student : Application.getStudents()){
				if (student.getUsername().equals(userName) && student.getPassword().equals(passWord)){
					Student.loggedIn = student;
					ulogovan =  "Student";
					new StudentMenu();
					return ulogovan;
				}
			}
			for (Professor professor : Application.getProfessors()){

				if(professor.getUsername().equals(userName) && professor.getPassword().equals(passWord)){
					Professor.ProLoggedIn = professor;
					ulogovan = "Professor";
					new ProfessorMenu();
					return ulogovan;
				}
			}
			return null;
			}
		
		public static boolean returnLogin(String userName, String passWord){
			if (!checkLog(userName,passWord).equals(null)){
				return true;
			}
			else{
				return false;
			}
		}

}
