import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		//String s = "aab";
		//String s = "daab";
		//String s = "ab";
		String s = "aa";
		
		List<List<String>> result = partition(s);
		
		for(int i = 0; i < result.size(); i++) {
			List<String> l = result.get(i);
			for(String str : l) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
	public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        int len = s.length();
    	List<String> strList1 = new ArrayList<String>();
    	
        for(int i = 0; i < len; i++) {
        
        	strList1.add(Character.toString(s.charAt(i)));
        }
        result.add(strList1);
        
        if(s.length() <= 1)
        	return result;
        
        String str = new String();
        str = s;
        
        do {
    		List<String> strList = new ArrayList<String>();
    		boolean isStrChanged = false;
	        for(int count = 2; count <= str.length(); count++) {
	        	for(int i = 0; i <= str.length() - count; i++) {
	        
	        		int start = i;
	        		int end = i + count-1;
	        		boolean isPallindrome = true;
	
	        		for(int k = start, l = end; k <= l; k++, l--) {
	    				if(s.charAt(k) != s.charAt(l)) {
	    					isPallindrome = false;
	    					break;
	    				}
	    			}
	    			
	    			if(isPallindrome) {
	    				strList.add(str.substring(start, end+1));
	    				String temp = str.substring(0, start) + str.substring(end+1, str.length());
	    				str = temp;
	    				isStrChanged = true;
	    			}
	
	        	}
	        }
	        
	        if(!str.equals("") && isStrChanged) {
	        	for(int i = 0; i < str.length(); i++) {
	        		strList.add(Character.toString(str.charAt(i)));
	        	}
	        	str = "";
	        	result.add(strList);
	        } else if(isStrChanged) {
	        	result.add(strList);
	        } else
	        	str = "";
        }while(!str.equals(""));
        return result;
    }

	
//	public static List<List<String>> partition(String s) {
//        List<List<String>> result = new ArrayList<List<String>>();
//        
//        int len = s.length();
//        
//        for(int i = 0; i < len; i++) {
//        	List<String> str = new ArrayList<String>();
//        	str.add(Character.toString(s.charAt(i)));
//        	result.add(str);
//        }
//        
//        for(int no = 2; no < len; no++) {
//        	
//        	for(int i = 0; i < len-no; i++) {
//        		List<String> str = new ArrayList<String>();
//        		int start = i;
//    			int end = i + no - 1;
//    			
//    			boolean isPallindrome = true;
//    			String temp = new String();
//    			for(int k = start, l = end; k <= l; k++, l--) {
//    				if(s.charAt(k) != s.charAt(l)) {
//    					isPallindrome = false;
//    					break;
//    				}
//    			}
//    			
//    			if(isPallindrome) {
//    				str.add(s.substring(start, end));
//    			}
//        	}
//        }
//
//        
////        for(int no = 2; no < len; no++) {
////        	for(int i = 0; i < len-no; i++) {
////        		for(int j = i; j < i + no; j++) {
////        			int start = j;
////        			int end = i + no - 1;
////
////        			boolean isPallindrome = true;
////        			for(int k = start, l = end; k <= l; k++, l--) {
////        				if(s.charAt(k) != s.charAt(l)) {
////        					isPallindrome = false;
////        					break;
////        				}
////        			}
////        		}
////        	}
////        }
//        return result;
//    }

}
