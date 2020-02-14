import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Test {
	
	 public static void main(String[] args) {
		
		 java.util.List<Integer> array  =  new ArrayList<Integer>();
		 java.util.List<Integer> array1  =  new ArrayList<Integer>();
		 array.add(7);
		 array.add(5);
		 array.add(-2);
		 array.add(7);
		 array.add(8);
		 array.add(1);
		 array.add(3);
		 array.add(-5);
		 array.add(-10);
		 array.add(9);
				 
		/* System.out.println("The original array is : ");
		 
		 for(int i = 0; i < array.size(); i++) {
			 System.out.print(array.get(i) + " ");
		 }*/
		 
		 array1 = (java.util.List<Integer>) SortArr(array);
		 
		 System.out.println("\n");
		 System.out.println("The original array is : ");
		 
		 for(int i = 0; i < array.size(); i++) {
			 System.out.print(array.get(i) + " ");
		 }
		 
		 System.out.println("\n");
		 System.out.println("The sorted array is : ");
		 
		 for(int i = 0; i < array1.size(); i++) {
			 System.out.print(array1.get(i) + " ");
		 }
	 }
	 
	 static ArrayList<Integer> SortArr(java.util.List<Integer> unsortedArray) {
		 
		 ArrayList<Integer> arr = new ArrayList<Integer>();
		 //int i = 0, max = 0, min = 0, maxpos = 0, minpos = 0;
		 int i = 0, j = 0, size = 0;
		 
		 unsortedArray.sort(Comparator.naturalOrder());
		 
		 size = unsortedArray.size();
		 if((size%2) == 0) {
			 for(i = 0, j = (size - 1); i < (size/2); i++, j--) {
				 arr.add(unsortedArray.get(j));
				 arr.add(unsortedArray.get(i));
			 }
		 }
		 else {
			 for(i = 0, j = (size - 1); i < (size/2); i++, j--) {
				 arr.add(unsortedArray.get(j));
				 arr.add(unsortedArray.get(i));
			 }
			 arr.add(unsortedArray.get(j));
		 }
		
		 /*while (unsortedArray.size() > 0) {
			 
			 max = unsortedArray.get(0);
			 min = unsortedArray.get(0);
			 maxpos = 0; 
			 minpos = 0;
								 
			 for(i = 0; i < unsortedArray.size(); i++) {
				 if (max < unsortedArray.get(i)) {
					 max = unsortedArray.get(i);
					 maxpos = i;
				 }
				 
				 if (min > unsortedArray.get(i)) {
					 min = unsortedArray.get(i);
					 minpos = i;
					 
				 }
			 }
			 
			 arr.add(unsortedArray.get(maxpos));
			 unsortedArray.remove(maxpos);
			 
			 if(unsortedArray.size() > 0) {
				 if (maxpos < minpos) {
	  				 arr.add(unsortedArray.get(minpos-1));
					 unsortedArray.remove(minpos-1);
				 }
				 else {
					 arr.add(unsortedArray.get(minpos));
					 unsortedArray.remove(minpos);
				 }
			 }
		 }*/
		 
		 return arr;
	 }
}
