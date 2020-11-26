import java.awt.List;
import java.util.ArrayList;
import java.util.*;

public class Driver {
 
	public static void main(String [] args) {
		int [] intArray = new int[5]; // default value is 0.
		char [] charArray = new char[5];
		float [] floatArray = new float[5]; // default value is 0.0
		
		for(int i = 0; i < 5; i ++ ) {
			System.out.println("int array[" + i + "] = " + intArray[i]);
		}
		
		for(int i = 0; i < 5; i ++ ) {
			System.out.println("char array[" + i + "] = " + charArray[i]);
		}
		
		for(int i = 0; i < 5; i ++ ) {
			System.out.println("float array[" + i + "] = " + floatArray[i]);
		}
		
		ArrayList<Integer> intList = new ArrayList <Integer>();
		ArrayList<Integer> answer = new ArrayList <Integer>();
		
		for(int i = 0; i < 5 ; i ++ ) {
			System.out.println("int list[" + i + "] = " );
		}
	}
}
