import java.util.Arrays;

public class BananaEatingSpeed {

	public static void main(String[] args) {
		int []piles = {25,10,23,4}; 
		int h = 4;
//		int []piles = {3,6,7,11};
//		int h = 8;
//		int []piles = {1,4,3,2}; 
//		int h = 9;

		int speed = minEatingSpeed(piles, h);
		System.out.println("Speed - " + speed);
	}

	public static int minEatingSpeed(int[] piles, int h) {
        int speed = 0, len = 0, max = 0, sum = 0;
        
        Arrays.sort(piles);
        len = piles.length;
        
        max = piles[len-1];
        
        for(int no : piles) {
        	sum = sum + no;
        }
        
        int quotient = sum / h;
        int remender = sum % h;
        if(remender != 0) {
	        int temp = 0;
	        while (temp < sum) {
	        	quotient++;
	        	temp = quotient * h; 
	        }
        }
        
        if(quotient < max && max % quotient != 0) {
        	int i = 1;
        	int temp = quotient * i;
        	int distance = max - quotient;
        	if(distance < quotient) {
        		speed = max;
        	} else {
        		speed = quotient;
        	}
        } else {
        	speed = quotient;
        }
        
        return speed;
    }
}
