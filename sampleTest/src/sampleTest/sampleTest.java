package sampleTest;

public class sampleTest {

	public static void main(String[] args) {
		
		String s = "amazing";
		String pattern = "010";
		char c = ' ', n = ' ';
	    int i = 0, j = 0, k = 0, flag = 0, count = 0, patternLen = 0;
	    
	    patternLen = pattern.length();
	    for(i = 0; i <= (s.length()-patternLen); i++){
	        
	    	flag = 0;
	        for(j = 0, k = i; j < patternLen && k < s.length(); j++,k++) {
	        	c = s.charAt(k);
	        	n = pattern.charAt(j);
	        	if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
	        		if(n != '0') {
	        			flag = 1;
	        			break;
	        		}
	        	}
	        	else {
	        		if(n != '1') {
	        			flag = 1;
	        			break;
	        		}
	        	}
	        }
	        if(flag == 0) {
	        	count++;
	        }
	    }
	    System.out.println(count);
	}
}
