
public class ObjectToString {

	public static void main(String[] args) {
		Student s1 = new Student(1, "abc", "First");
    	// Without toString override 
		//System.out.println(s1.toString());   // Student@7a81197d
		//System.out.println(s1);	           // Student@7a81197d
		
		// With over-ridden toString()
		System.out.println(s1.toString());     // 1 abc First
	}

}
