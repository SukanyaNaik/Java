import java.util.HashMap;
import java.util.Map;

public class Driver {

	public static void main(String[] args) {
		String str = "dvdf";
		
		Map <Character, Character> map = new HashMap<Character, Character>();
		
		int len = str.length();
		int length = 1, temp = 0;
		for(int i = 0; i < len; i++) {
			if(map.containsKey(str.charAt(i))) {
				if(length < temp) {
					length = temp;
				}
				temp = 0;
				map.remove(str.charAt(i));
				int j = i-1;
				while(j >= 0 && str.charAt(i) != str.charAt(j)) {
					map.remove(str.charAt(j));
					j--;
				}
				i = j;
			}
			else {
				map.put(str.charAt(i), str.charAt(i));
				temp++;
			}
		}
		if(length < temp) {
			length = temp;
		}
		System.out.println("Substring length = " + length);
	}

}
