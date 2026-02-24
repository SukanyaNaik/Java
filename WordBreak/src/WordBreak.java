import java.util.Arrays;
import java.util.List;


/*
 * Dynamic programming
 */
public class WordBreak {

	public static void main(String[] args) {
		/*
		 *         TRUE */
		  String s = "leetcode";
		  List <String>wordDict = Arrays.asList("leet","code");
		 

		/*
		 *         FALSE
		 * String  s = "catsandog";
		 * List <String>wordDict = Arrays.asList("cats","dog","sand","and","cat");
		 */

		/*
		 *         TRUE
		 * String s = "applepenapple";
		 * List <String>wordDict = Arrays.asList("apple","pen");
		 */
		
		boolean canWordBeBroken = wordBreak(s, wordDict);
		System.out.println("canWordBeBroken - " + canWordBeBroken);
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
        boolean canWordBeBroken = true;
        
        String str = s;
        int len = wordDict.size();
        
        for(int i = 0; i < len; i++) {
        	String word = wordDict.get(i);
        	
        	if(str.contains(word))
        		str = str.replace(word, "");
        	else { 
        		canWordBeBroken = false;
        		break;
        	}
        }
        return canWordBeBroken;
    }
}
