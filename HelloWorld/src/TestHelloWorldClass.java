import java.util.Scanner;

public class TestHelloWorldClass {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//String myString = scanner.next();
		int no1 = 0, no2 = 0, no3 = 0;
		no1 = scanner.nextInt();
		no2 = scanner.nextInt();
		no3 = scanner.nextInt();
		scanner.close();

		System.out.println("no1 is: " + no1);
		System.out.println("no1 is: " + no2);
		System.out.println("no1 is: " + no3);
	}

}
