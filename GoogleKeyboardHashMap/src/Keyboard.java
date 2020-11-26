import java.util.HashMap;

public class Keyboard {

	public static void main(String[] args) {
		String kb = "abcdefghijklmnopqrstuvwxyz";
		String text = "happy";
		//String text = "cba";
		
		int timeTaken = timeToType(kb, text);
		
		System.out.println("Time taken to type " + text + " = " + timeTaken);
	}

	
	public static int timeToType(String kb, String text) {
		int timeTaken = 0, diff = 0, lastIndex = 0, currentIndex = 0;
		
		HashMap <Character, Integer> myKb = new HashMap<Character, Integer>();
		
		for(int i = 0; i < kb.length(); i++) {
			myKb.put(kb.charAt(i), i);
		}
		
		for(int j = 0; j < text.length(); j++) {
			currentIndex = myKb.get(text.charAt(j));
			diff = Math.abs(currentIndex - lastIndex);
			timeTaken = timeTaken + diff;
			lastIndex = currentIndex;
		}
		return timeTaken;
	}
}
