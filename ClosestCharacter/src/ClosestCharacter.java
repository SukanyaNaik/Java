import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestCharacter {

	public static void main(String[] args) {
		//String str = "baabab";
		//List <Integer> query = new ArrayList<Integer> (Arrays.asList(3));
		
		//String str = "hackerrank";
		//List <Integer> query = new ArrayList<Integer> (Arrays.asList(4,1,6,8));
		
		String str = "sam";
		List <Integer> query = new ArrayList<Integer> (Arrays.asList(-1));
		
		List <Integer> closestCharAt = ClosestCharacter.closest(str, query);
		
		for(int i = 0; i < closestCharAt.size(); i++) {
			System.out.println(closestCharAt.get(i));
		}
	}

	public static List<Integer> closest(String str, List <Integer>query){
		List <Integer> closestCharAt = new ArrayList <Integer>();
		int pos = -1, index = -1, dist = -1;
		int size = str.length();
		char ch = ' ';
		
		for(int i = 0; i < query.size(); i++) {
			
			pos = query.get(i);
			
			if(pos >= 0 && pos < size) {
			
				ch = str.charAt(pos);	
				index = -1;
				dist = -1;
			
				for(int j = 0; j < size; j++) {
				
					if(str.charAt(j) == ch && j != pos) {
					
						int diff = Math.abs(pos - j);
		
						if(dist == -1) {
							dist = diff;
							index = j;
						}
						else {
							if(dist > diff) {
								dist = diff;
								index = j;
							}
						}
					
					}
				}
			}
			
			closestCharAt.add(index);
		}
		
		return closestCharAt;
	}
}
