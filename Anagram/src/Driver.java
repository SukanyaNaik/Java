import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {

	public static void main(String[] args) {
		String strs[] = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> anagrams = groupAnagrams(strs);
		
		System.out.println("Anagrams = ");
		for(int i = 0; i < anagrams.size(); i++) {
			for(int j = 0; j < anagrams.get(i).size(); j++) {
				System.out.print(anagrams.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		
		Map <String, String> strMap = new HashMap<String, String>();
		
		for(int i = 0; i < strs.length; i++) {
			String str1 = strs[i];
			List <String> temp = new ArrayList<String>();
			temp.add(str1);
			
			if(!strMap.containsKey(str1)) {
				strMap.put(str1, str1);
			
				for(int j = i+1; j < strs.length; j++) {
					String str2 = strs[j];
					
					if(str1.length() == str2.length()) {
						boolean areLettersSame = true;
						Map <Character, Integer> map = new HashMap<Character, Integer>();
						
						for(int l = 0; l < str1.length(); l++) {
							char c = str1.charAt(l);
							if(map.containsKey(c)) {
								int count = map.get(c);
								map.put(c,count++);
							}
							else {
								map.put(c,1);
							}
						}
						
						for(int l=0; l < str2.length(); l++) {
							char c = str2.charAt(l);
							if(!map.containsKey(c)) {
								areLettersSame = false;
							}
						}
						if(areLettersSame) {
							if(!strMap.containsKey(str2)) {
								temp.add(str2);
								strMap.put(str2, str2);
							}
						}
					}
				
				}
				result.add(temp);
			}
		}
		return result;
	}
}
