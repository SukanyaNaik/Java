package com.sukanya;

public class PassByReference {

	public static void main(String[] args) {

		int [] array = {1,2};
//		System.out.println("Array before update ");
//		for(int values : array) {
//			System.out.print(" " + values);
//		}
		System.out.print(array[0]);
		System.out.print(" " +array[1] + "\n");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		update(array);
		System.out.print("\n"+ array[0]);
		System.out.print(" " + array[1]+"\n");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
//		System.out.println("\nArray after update ");
//		for(int values : array) {
//			System.out.print(" " + values);
//		}
	}

	public static void update(int array[]) {
		
//		array[0] = array[0] + 1;
//		array[1] = array[1] + 1;
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] 
					+ 1;
		}
	}
}
