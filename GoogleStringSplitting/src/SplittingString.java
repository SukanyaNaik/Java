import java.util.HashMap;

public class SplittingString {

	public static void main(String[] args) {
		String str = "abcabcabcabc";
		
		int noOfSubStrings = splitString(str);
		System.out.println("Number of substrings = " + noOfSubStrings);
	}
	
	public static int splitString(String str) {
		int noOfSubStrings = 0;
		HashMap <Character, Integer> chars = new <Character, Integer> HashMap();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			Integer hashValue = chars.get(ch);
			
			if(hashValue != null) {
				hashValue++;
				chars.put(ch, hashValue);
				
			}
			else {
				chars.put(ch, 1);
			}
		}
		int i = 0;
		for (Integer no : chars.values()) {
			if(i == 0) {
				noOfSubStrings = no;
				i++;
			}
			if(no == 1) {
				noOfSubStrings = 0;
			}else {
				if(noOfSubStrings != no) {
					noOfSubStrings = 0;
				}
			}
		}

		return noOfSubStrings;
	}

}
