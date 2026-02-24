package characterReplacement;

public class Driver {

	public static void main(String[] args) {
		//String s = "XYYX";
		//String s = "AAABABB";
		//String s = "ABAB";
		String s = "ABCDE";
		int k = 1;

		int count = characterReplacement(s, k);
		
		System.out.println("Count - " + count);
	}

	 public static int characterReplacement(String s, int k) {
	        int count = 0;
	        char []charArr = s.toCharArray();
	        
	        for(int i = 0; i < charArr.length; i++) {
	        	int n = 1;
	        	char ch = charArr[i];
	        	
	        	int j = 0;
	        	boolean cont = true;
	        	do {
	        		if(i == j)
	        			j++;
	        		else {
			        	while(j < charArr.length && ch == charArr[j]) {
			        		n++;
			        		j++;
			        	}
			        	int position = s.indexOf(ch, j);
			        	
			        	if(position != -1 && position-j <= k) {
			        		int tempCount = 0;
			        		for(int l = j; l < j+k; l++) {
			        			if(charArr[l] != ch) {
			        				charArr[l] = ch;
			        				tempCount++;
			        			}
			        		}
			        		j = j + k + 1;
			        		n = n + k + 1;
			        		k = k - tempCount;
			        	} else
			        		cont = false;
	        		}
	        	}while (cont && j < charArr.length);
	        	
	        	count = Math.max(count, n);
	        }
	        
	        if(count == 1 && s.length() > 1)
	        	count = count + k;
	        return count;
	 }
}
