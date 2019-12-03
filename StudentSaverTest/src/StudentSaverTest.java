import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentSaverTest {

	public static void main(String[] args) {
		Student one = new Student(10, "James", new String[] {"Oracle", "Web Services", "Hibernet"});
		Student two = new Student(15, "Maya", new String[] {"JavaScript", "HTML", "CSS"});
		Student three = new Student(05, "Priyanka", new String[] {"C++", "Java", "JavaScript"});

		try {
			FileOutputStream fs = new FileOutputStream("StudentInfo.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeObject(one);
			os.writeObject(two);
			os.writeObject(three);
			
			os.close();
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		one = null;
		
		
		two = null;
		three = null;
		
		try {
			FileInputStream fs = new FileInputStream("StudentInfo.txt");
			ObjectInputStream is = new ObjectInputStream(fs);
			
			Student oneRestored = (Student) is.readObject();
			Student twoRestored = (Student) is.readObject();
			Student threeRestored = (Student) is.readObject();
			
			System.out.println("Student Name  " + oneRestored.getStudentName());
			System.out.println("Courses       " + oneRestored.getStudentCourses()  + "\n");
			
			System.out.println("Student Name  " + twoRestored.getStudentName());
			System.out.println("Courses       " + twoRestored.getStudentCourses() + "\n");
			
			System.out.println("Student Name  " + threeRestored.getStudentName());
			System.out.println("Courses       " + threeRestored.getStudentCourses() + "\n");
			
			is.close();
			
		} catch(IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

}
