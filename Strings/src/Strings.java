import java.io.*;
import java.util.*;

public class Strings {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		String s = new String();
		String even = new String(), odd = new String();

		int t = scanner.nextInt();
        int i = 0, len = 0, j = 0;
        
       scanner.nextLine();
        for(i = 0; i < t; i++) {
        	s = scanner.nextLine();
        	even = "";
            odd = "";
        	len = s.length();
        	for(j = 0; j < len; j++) {
        		if((j%2) == 0) {
        			even +=s.charAt(j);
        		}
        		else {
        			odd +=s.charAt(j);
        		}
        	}
        	System.out.println(even + " " + odd);
        }
        scanner.close();
	}

}
