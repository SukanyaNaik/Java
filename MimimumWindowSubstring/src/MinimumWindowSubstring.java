import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		//String s = "OUZODYXAZV", t = "XYZ";
		//String s="ADOBECODEBANC", t="ABC";
		//String s="A", t="AA";
		//String s="a",t="b";
		//String s="aa",	t="aa";
		String s="aaaaaaaaaaaabbbbbcdd", t="abcdd";
		
		String subStr = minWindow(s, t);
		System.out.println(subStr);
	}

	public static String minWindow(String s, String t) {
		if(t.length() > s.length()) {
			return "";
		}
		
		if(s.length() == t.length() && s.contains(t))
			return s;
		
		if(s.contains(t))
			return t;
		
		Map <Character, List<Integer>> charMap = new HashMap <Character, List<Integer>> ();
		int rows = 1;
		String sb = new String(s + "#");

		for(int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			
			if(!charMap.containsKey(ch)) {
				String [] subStr = sb.split(Character.toString(ch));
				if(subStr.length > 0) {
					List <Integer> counts = new ArrayList<Integer>();
					int temp = 0;
					
					rows = rows * (subStr.length - 1);
					
					for(int j = 0; j < subStr.length-1; j++) {
						counts.add(temp + subStr[j].length());
						temp = subStr[j].length() + 1;
						charMap.put(ch, counts);
					}
				}
			}
		}
		if(charMap.size() < 1)
			return "";
		
		int [][]matrix = new int[rows][t.length()];
		int lastCount = rows;
		
		for(Map.Entry<Character, List<Integer>> entry : charMap.entrySet()) {
			char ch = entry.getKey();
			List <Integer> counts = entry.getValue();
			int len = counts.size();
			int col = t.indexOf(ch);
			
			for(int k = 0; k < (rows/lastCount); k++) {
				for(int i = 0; i < len; i++) {
					int start = (k*lastCount) + (i * (lastCount/len));
					int limit = start+(lastCount/len);
					for(int j = start; j < limit; j++) {
						matrix[j][col] = counts.get(i);
					}
				}
			}
			lastCount = lastCount / len;
		}
		
		int minMaxRow = 0, distance = s.length();
		int [][] minMax = new int[rows][2];
		
		for(int i = 0; i < rows; i++) {
			int min = s.length(), max = -1, diff = 0;
			
			for(int j = 0; j < t.length(); j++) {
				if(min > matrix[i][j]) {
					min = matrix[i][j];
					minMax[i][0] = min;
				}
				if(max < matrix[i][j]) {
					max = matrix[i][j];
					minMax[i][1] = max+1;
				}
			}
			
			diff = max - min;
			
			if(distance > diff) {
				distance = diff;
				minMaxRow = i;
			}
		}
		
		String str1 = s.substring(minMax[minMaxRow][0], minMax[minMaxRow][1]);
		return s.substring(minMax[minMaxRow][0], minMax[minMaxRow][1]);
    }
}
