import java.util.Scanner;

public class BinaryNumbers {

	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        String binary = "";
        
        while(n > 0) {
       
        	binary = (n%2) + binary;
        	n = n / 2;
        }
        
        int count = 0, temp = 0;
        for (int i = 0; i < binary.length(); i++) {
        	if(binary.charAt(i) == '1') {
        		temp++;
        	}
        	else {
        		temp = 0;
        	}
        	if(temp > count) {
            	count = temp;
            }
        }
        
        System.out.println("Binary - " + binary);
        System.out.println(count);
        scan.close();

	}

}
