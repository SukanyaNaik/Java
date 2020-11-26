import java.util.ArrayList;
import java.util.List;

public class StringCombinations {

	public static void main(String[] args) {
		String text = "abcd";
		
		List<String> strCombinations = StringCombinations.combinations(text);
		
		strCombinations.forEach((str) -> System.out.println(str));
	}

	public static List<String> combinations(String text){
		
		List <String> strCombinations = new ArrayList<String>();
		int size = text.length();
		
		for(int i = 0; i < size; i++) {
			
			String str1 = Character.toString(text.charAt(i));
			strCombinations.add(str1);
			
			for(int j = i+1; j < size; j++) {
				
				String str2 = str1;
				
				for(int k = j; k < size; k++) {
					str2 += Character.toString(text.charAt(k));
					strCombinations.add(str2);
				}
			}
		}
		
		return strCombinations;
	}
}
