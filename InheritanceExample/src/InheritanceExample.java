import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}

class Student extends Person{
	private int[] testScores;
	
	Student(String firstName, String lastName, int identification, int []scores){
		super(firstName, lastName, identification);
		testScores = scores;
	}
	
	public char calculate() {
		char grade = ' ';
		int sum = 0, average = 0, n = 0;
		n = testScores.length;
		for(int i = 0; i < n; i++) {
			sum = sum + testScores[i]; 
		}
		
		average = sum / n;
		
		if (average >= 90 && average <= 100)
			grade = 'O';
		else if (average >= 80 && average < 90)
			grade = 'E';
		else if (average >= 70 && average < 80)
			grade = 'A';
		else if (average >= 55 && average < 70)
			grade = 'P';
		else if (average >= 40 && average < 55)
			grade = 'D';
		else
			grade = 'T';
		return grade;
	}
}

public class InheritanceExample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );

	}

}
