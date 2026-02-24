import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {

	public static void main(String[] args) {
		List<String> input = Arrays.asList("Hello","World");
		
		String encodedStr = encode(input);
		System.out.println(encodedStr);
		
		List<String> output = decode(encodedStr);
		
		for(String str: output) {
			System.out.print(str + " ");
		}
	}

	public static String encode(List<String> strs) {
		StringBuffer encodedStr = new StringBuffer();
		
		for (String str : strs) {
			int strLen = str.length();
			StringBuffer sb = new StringBuffer(strLen + "#");
			
			sb.append(str);
			System.out.println(sb);
			encodedStr.append(sb);
		}
		
		return encodedStr.toString();
    }

    public static List<String> decode(String str) {
    	List <String> output = new ArrayList<String>();
    	
    	int i = 0;
    	
    	do {
	    	StringBuffer sb = new StringBuffer();
	    	while(i < str.length() && str.charAt(i) != '#') {
	    		sb = sb.append(str.charAt(i));
	    		i++;
	    	}
	    	
	    	i++;
	    	int n = Integer.parseInt(sb.toString());
	    	
	    	StringBuffer s = new StringBuffer();
	    	for(int k = i; k < i+n; k++) {
	    		s = s.append(str.charAt(k));
	    	}
	    	i = i + n;
	    	output.add(s.toString());
    	} while (i < str.length());
    	
    	return output;
    }
}
