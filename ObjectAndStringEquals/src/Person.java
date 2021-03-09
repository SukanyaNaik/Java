
public class Person {
	public String firstName;
	public String lastName;
	public int age;
	
	Person(String firstName, String lastName, int age){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof Person)) {
			return false;
		}
		
		Person p = (Person)obj;
		
		return (p.firstName).equals(firstName) == true &&
			   (p.lastName).equals(lastName) == true &&
			   p.age == age;
		
	}
}
