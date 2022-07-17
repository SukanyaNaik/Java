class Student{
	int rollNo;
	String name;
	
	public Student(int no, String str) {
		this.rollNo = no;
		this.name = str;
	}
}

public class StudentArray {

	public static void main(String[] args) {
		Student arr [] = new Student[5];
		
		arr[0] = new Student(1, "Ram");
		arr[1] = new Student(2, "Shri");
		arr[2] = new Student(3, "Om");
		arr[3] = new Student(4, "Ganesh");
		arr[4] = new Student(5, "Arjun");
		
		System.out.println("Students - ");
		for(int i=0; i < arr.length; i++) {
			System.out.println(arr[i].rollNo + " : " + arr[i].name);
		}
		
		int twoDArray [][] =  {{1,2}, {3,4}};
		int arr1[][] = { { 1, 2 }, { 3, 4 } };

	}

}
