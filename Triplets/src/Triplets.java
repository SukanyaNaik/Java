import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Triplets {

	public static void main(String[] args) {
		int []a = {1,2,3,4,5};
		
		ArrayList <Integer> b = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
				
		int noOfTriplets = 0, thresholdT = 8;
		noOfTriplets = triplets(a, thresholdT);
		System.out.println("Number of triplets = " + noOfTriplets);
		
		//noOfTriplets = triplets(b, thresholdT);
		//System.out.println("Number of triplets = " + noOfTriplets);
	}

	public static int triplets(int []a, int thresholdT) {
		int noOfTriplets = 0;
		
		for(int i = 0; i < (a.length-2); i++) {
			for(int j = i+1; j < (a.length-1); j++) {
				for(int k = j+1; k < a.length; k++ ) {
					int sum = a[i] + a[j] + a[k];
					
					if(sum <= thresholdT) {
						System.out.println(a[i] + " " + a[j] + " " + a[k]);
						noOfTriplets++;
					}
				}
			}
		}
		return noOfTriplets;
	}
	
	public static int triplets(ArrayList <Integer> b, int thresholdT) {
		int noOfTriplets = 0;
		
		Collections.sort(b);
		
		return noOfTriplets;
	}
}
