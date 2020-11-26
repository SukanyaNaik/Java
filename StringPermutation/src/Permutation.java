
public class Permutation {

	public static void main(String[] args) {
		//String word = "acba";
		//String word = "acab";
		//String word = "baca";
		//String word = "dacb";
		//String word = "hefg";
		String word = "yx";
		
		String nextPermutation = Permutation.rearrangeword(word);
		
		System.out.println("Next highest word - " + nextPermutation);

	}
	
	public static String rearrangeword(String word) {
		boolean flag = true;
		int len = word.length();
		
		int i = len - 1;
		
		while(flag && i >= 0) {
			
			for(int j = i-1; j>=0 && flag; j--) {
				
			char charAt_i = word.charAt(i);
			char charAt_i_1 = word.charAt(j);
			
			if(charAt_i > charAt_i_1) {
				String str1 = word.substring(j,i);
				String str2 = word.substring(i);
				word = word.substring(0, j);
				word = word.concat(str2);
				word = word.concat(str1);
				flag = false;
				}
			}
			
			i--;
		}
		
		return word;
	}

}
