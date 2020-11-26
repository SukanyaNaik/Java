
public class TwoStrings {

	public static void main(String[] args) {
		//String []a = {"ab", "cd", "ef"};
		//String []b = {"af", "ee" , "ef"};
		
		String []a = {"Hello", "Hi"};
		String []b = {"World", "Bye"};
		TwoStrings.commonSubstring(a, b);
	}

	public static void commonSubstring(String []a, String []b) {
		int i = 0;
		boolean ifContains = false;
		
		while(i < a.length && i < b.length) {
			
			ifContains = false;
			
			for(int j = 0; j < b[i].length() && ifContains == false; j++) {
				
				if(a[i].contains(Character.toString(b[i].charAt(j)))) {
					System.out.println("Yes");
					ifContains = true;
				}
			}
			
			if(ifContains == false) {
				System.out.println("No");
			}
			
			i++;
		}
		
	}
}
