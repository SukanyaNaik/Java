import java.util.HashMap;
import java.util.Map;

public class Driver {

	public static void main(String[] args) {
	String s = "ADOBECODEBANC";
	String t = "ABC";
	
	String subStr = minWindow(s, t);
	System.out.println("Substring - " + subStr);

	}

	public static String minWindow(String s, String t) {
		String str = "", subStr = "";
		Map<Character, Boolean> charMap = new HashMap<Character, Boolean>();
		
		for(int i=0; i < t.length(); i++) {
			if(!charMap.containsKey(t.charAt(i))) {
				charMap.put(t.charAt(i), false);
			}
		}
		int charsVisitedCount = 0;
		for(int i=0; i < s.length(); i++) {
			char ch = s.charAt(i);
			boolean visited = false;
			if(charMap.containsKey(ch)) {
				visited = charMap.get(ch);
				if(!visited) {
					subStr = subStr + ch;
					charMap.replace(ch, false, true);
					charsVisitedCount++;
					if(charsVisitedCount == t.length()) {
						if(str.length() == 0 || str.length() > subStr.length()) {
							str = subStr;
							subStr = "";
							charsVisitedCount = 0;
							for(Map.Entry<Character, Boolean> entry : charMap.entrySet()) {
								char temp = entry.getKey();
								charMap.replace(temp, false);
							}
						}
					}
				}
			}else {
				if(charsVisitedCount > 0)
					subStr = subStr + ch;
			}
			
		}
		return str;
	}
}
