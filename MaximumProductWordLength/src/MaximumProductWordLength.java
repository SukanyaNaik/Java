
public class MaximumProductWordLength {

	public static void main(String[] args) {
		String []words = {"abcw","baz","foo","bar","xtfn","abcdef"};
		
		int product = maxProduct(words);
		System.out.println("Product - " + product);
	}
	
	public static int maxProduct(String[] words) {
		int product = 0;
		
        for(int i = 0; i < words.length; i++) {
        	String word1 = words[i];
        	for(int j = i+1; j < words.length; j++) {
        		String word2 = words[j];
        		if(!word1.equals(word2) || !word1.contains(word2) || !word2.contains(word1)) {
        			boolean containsChar = false;
        			for(int k = 0; k < word1.length(); k++) {
        				if(word2.contains(Character.toString(word1.charAt(k)))) {
        					containsChar = true;
        				}
        			}
        			
        			if(!containsChar) {
        				int p = word1.length() * word2.length();
        				if(product == 0)
        					product = p;
        				else if(product < p)
        					product = p;
        			}
        		}
        	}
        }
        
        return product;
    }

}
