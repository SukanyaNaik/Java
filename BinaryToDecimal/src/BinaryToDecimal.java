import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinaryToDecimal {

	public static void main(String[] args) {
		//List <Integer> binary = new ArrayList<Integer>();
		List <Integer> binary = new LinkedList<Integer>();
		
		binary.add(1);
		binary.add(1);
		binary.add(0);
		binary.add(1);
		binary.add(0);
		binary.add(0);
		binary.add(1);
		
		Iterator <Integer> it = binary.iterator();
		
		int decimal = 0;
		while(it.hasNext()) {
			int temp = it.next();
			decimal = decimal << 1 | temp;
		}
		
		System.out.println("Decimal no - " + decimal);
	}

}
