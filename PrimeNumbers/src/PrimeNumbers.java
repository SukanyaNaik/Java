import java.util.Scanner;

public class PrimeNumbers {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		Integer [] numbers = new Integer [n]; 
		
		for(int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		}
		
		int flag = 0;
		for(int i = 0; i < n; i++) {
			flag = 0;
	        if (numbers[i] != 1){
	            for(int j = 2; j*j <= numbers[i] && flag == 0; j++) {
	            	if((numbers[i] % j) == 0) {
	            		flag = 1;
	                    System.out.println("Not prime");
	                }
	            }
	        }
	        else {
	        	flag = 1;
	        	System.out.println("Not prime");
	        }
	            
	        if(flag == 0) {
	        	System.out.println("Prime");
	        }
	    }

	}

}
