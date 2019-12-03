import java.io.*;

public class Student implements Serializable {
	int studentID;
	String name;
	String[] courses;
	
	public Student(int ID, String n, String[] c) {
		studentID = ID;
		name = n;
		courses = c;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public String getStudentName() {
		return name;
	}

	public String getStudentCourses() {
		String courseList = "";
		
		for(int i = 0; i < courses.length; i++) {
			courseList += courses[i] + "   ";
		}
		
		return courseList;
	}
}
