import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNo {

	public static void main(String[] args) {
		String digits = "2";
		
		List<String> result = letterCombinations(digits);

		for(String s : result) {
			System.out.print(s + " ");
		}
	}
	
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		List<String> strs = new ArrayList<String>();
		
		for(int i = 0; i < digits.length(); i++) {
			char ch = digits.charAt(i);
			String s = getChars(ch);
			strs.add(s);
		}
		
		String firstStr = strs.get(0);
		for(int i = 0; i < firstStr.length(); i++) {
			dfs("",strs, 0, i, 0, result);
		}
		
        return result;
    }
	
	public static void dfs(String s, List<String> strs, int index, int i, int j, List<String>result) {
		if(index == strs.size()) {
			result.add(s);
			index = index-1;
			s = s.substring(0, s.length() - 1);
			j++;
		}
				
		if(j == strs.get(index).length()) {
			return;
		}
		
		if(index == 0 && j == 0) {
			s = s + strs.get(index).charAt(i);
		}
		else
			s = s + strs.get(index).charAt(j);
		dfs(s, strs, index+1, i, j, result);
		
	}
		
	public static String getChars(char ch) {
		String s = new String ();
		
		switch(ch) {
					case '2': s = "abc";
							break;
					case '3': s = "def";
							break;
					case '4': s = "ghi";
							break;
					case '5': s = "jkl";
							break;
					case '6': s = "mno";
							break;
					case '7': s = "pqrs";
							break;
					case '8': s = "tuv";
							break;
					case '9': s = "wxyz";
							break;
		}
		
		return s;
	}

}
