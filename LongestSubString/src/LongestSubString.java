import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubString {

	public static void main(String[] args) {
		//String s = "zxyzxyz";
		//String s = "pwwkew";
		//String s = "aab";
		String s = "abcabcbb";
		//String s = "au";
		
		int count = lengthOfLongestSubstring(s);
		
		System.out.println("Length - " + count);

	}

	public static int lengthOfLongestSubstring(String s) {
//		int count = 0;
//		List <Integer> countList = new ArrayList<Integer>();
//		
//		for(int i = 0; i < s.length(); i++) {
//			char ch = s.charAt(i);
//			int position = s.indexOf(ch, i+1);
//			int len = 0;
//			if(position == -1) {
//				int temp = s.indexOf(ch, 0);
//				if(temp != i && temp > i)
//					len = s.length() - i;
//				else len = 0;
//			}
//			else 
//				len = position - i;
//			countList.add(len);
//		}
//		Collections.sort(countList);
//		count = countList.getLast();
//        return count;
		
		 int res = 0;
	        for (int i = 0; i < s.length(); i++) {
	            Set<Character> charSet = new HashSet<>();
	            for (int j = i; j < s.length(); j++) {
	                if (charSet.contains(s.charAt(j))) {
	                    break;
	                }
	                charSet.add(s.charAt(j));
	            }
	            res = Math.max(res, charSet.size());
	        }
	        return res;
    }
}
