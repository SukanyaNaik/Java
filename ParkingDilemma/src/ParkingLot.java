import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParkingLot {

	public static void main(String[] args) {
		List <Integer> spots = new ArrayList <Integer>(Arrays.asList(2,5,8,11,15,18,22,30));
		int k = 5;
		
		int roofLength = findRoofLength(spots, k);
		System.out.println("Length of the roof - " + roofLength);
	}
	
	public static int findRoofLength(List <Integer> spots, int k) {
		int roofLength = 0, length = 0;
		
		Collections.sort(spots);
		
		if(spots.size() >= k) {
			roofLength = spots.get(k-1) - spots.get(0);
			roofLength++;
			
			for(int i = 1; i < (spots.size() - k + 1); i++) {
				int num1 = spots.get((i+k)-1);
				int num2 = spots.get(i);
				length = num1 - num2;
				length++;
				
				if(length < roofLength) {
					roofLength = length;
				}
			}
		}
		return roofLength;
	}

}
