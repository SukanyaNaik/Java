
public class TestEquals {

	public static void main(String[] args) {

		String first = "Hello World!";
		String second = "Hello World!";
		
		if(first == second) {
			System.out.println("Strings are equal.");
		} else {
			System.out.println("Strings are not equal.");
		}
		
		System.out.println("\nStrings with equals method");
		if(first.equals(second)) {
			System.out.println("Strings are equal.\n");
		} else {
			System.out.println("Strings are not equal.\n");
		}
		
		Person p1 = new Person("Sukanya", "Naik", 40);
		Person p2 = new Person("Sukanya", "Naik", 40);
		
		if(p1 == p2) {
			System.out.println("Objects p1 and p2 are equal.");
		} else {
			System.out.println("Objects p1 and p2 are not equal.");
		}
		
		Person p3 = p1;
		if(p1 == p3) {
			System.out.println("Objects p1 and p3 are equal.");
		} else {
			System.out.println("Objects p1 and p3 are not equal.");
		}
		
		System.out.println("\nWith equals method overridden");
		if(p1.equals(p2)) {
			System.out.println("Objects p1 and p2 are equal.");
		} else {
			System.out.println("Objects p1 and p2 are not equal.");
		}
	}

}
