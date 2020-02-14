import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecursionFactorial {

	
		static int factorial(int n) {
			int f = 1;
			if(n == 1) {
				return 1;
			}else {
				f = n * factorial(n-1);
			}
			return f;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int result = factorial(n);

	        //bufferedWriter.write(String.valueOf(result));
	       // bufferedWriter.newLine();

	        //bufferedWriter.close();
	        System.out.println("Factorial of " + n + " is - " + result);
	        scanner.close();
	    }
}
