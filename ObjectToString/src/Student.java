
public class Student {
	int rollNo;
	String name;
	String grade;
	
	public Student(int rollNo, String name, String grade) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.grade = grade;
	}
	
	public String toString() {
		return rollNo + " " + name + " " + grade; 
	}
}
