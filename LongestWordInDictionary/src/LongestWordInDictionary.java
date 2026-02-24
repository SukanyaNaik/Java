import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestWordInDictionary {

	public static void main(String[] args) {
		String s = "abpcplea";
		List<String> dictionary = Arrays.asList("ale","apple","monkey","plea");

		String str = findLongestWord(s, dictionary);
		System.out.println(str);
	}
	
	public static String findLongestWord(String s, List<String> dictionary) {
		String str = new String();
		
		Map <Character, Integer> charMap = new HashMap<Character, Integer>();
		int l = s.length();
		for(int i = 0; i < l; i++) {
			char ch = s.charAt(i);
			if(charMap.containsKey(ch)) {
				int freq = charMap.get(ch);
				charMap.put(ch, freq+1);
			} else {
				charMap.put(ch, 1);
			}
		}
		
		int len = dictionary.size();
		
		for(int i = 0; i < len; i++) {
			String word = dictionary.get(i);
			Map <Character, Integer> wordMap = new HashMap<Character, Integer>();
			int wl = word.length();
			
			for(int j = 0; j < wl; j++) {
				char ch = word.charAt(j);
				
				if(wordMap.containsKey(ch)) {
					int freq = wordMap.get(ch);
					wordMap.put(ch, freq);
				} else {
					wordMap.put(ch, 1);
				}
			}
			
			boolean wordExists = true;
			for(Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
				char ch = entry.getKey();
				int val = entry.getValue();
				
				if(charMap.containsKey(ch)) {
					int freq = charMap.get(ch);
					
					if(freq < val)
						wordExists = false;
				} else
					wordExists = false;
			}
			
			if(wordExists && str.length() < word.length())
				str = word;
		}
		return str;
	}
}
