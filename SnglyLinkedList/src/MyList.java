
public class MyList {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		/*list.add(5);
		list.add(4);
		list.add(1);
		list.add(3);
		list.add(10);
		list.add(2);
		list.add(8);
		list.add(9);*/
		
		/*list.add(29);
		list.add(72);
		list.add(98);
		list.add(13);
		list.add(87);
		list.add(66);
		list.add(52);
		list.add(51);
		list.add(36);*/
		
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(10);
		list.add(12);
		list.add(1);
		list.add(5);
		list.add(6);
		
		int size = list.size();
		System.out.println("Size = " + size);
		System.out.println("The list is : ");
		list.display();
		
		/*list.add(20,1);
		System.out.println("\nThe list is : ");
		list.display();
		size = list.size();
		System.out.println("\nSize = " + size);
		
		boolean hasA = list.contains(5);
		System.out.println(hasA);
		
		list.reverse();
		System.out.println("\nThe list is : ");
		list.display();
		
		
		list.reverse();
		System.out.println("\nThe list is : ");
		list.display();
		
		boolean flag = list.remove(5); // Remove element by position
		System.out.println("\nThe list is : ");
		list.display();*/
		
		list.sort();
		System.out.println("\nThe list is : ");
		list.display();
	}

}
