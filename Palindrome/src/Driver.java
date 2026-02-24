
public class Driver {

	public static void main(String[] args) {
		//String s = "Was it a car or a cat I saw?";
		String s = " ";
		boolean isValidPalindrome = isPalindrome(s);
		
		System.out.println(isValidPalindrome);
	}

	public static boolean isPalindrome(String s) {
        int len = s.length();
        if(len == 1)
        	return true;
        
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < len; i++) {
        	if(Character.isLetterOrDigit(s.charAt(i))) {
        		sb = sb.append(s.charAt(i));
        	}
        }
        if(sb.isEmpty())
        	return true;
        
        String str = sb.toString().toLowerCase();
        len = str.length();
        boolean isValidPalindrome = true;
        
        for(int i = 0, j = len-1; i <= len/2; i++, j--) {
            if(str.charAt(i) != str.charAt(j)) {
            	isValidPalindrome = false;
            	break;
            }
        }
        
        return isValidPalindrome;
    }
}
