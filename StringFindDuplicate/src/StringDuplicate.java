
public class StringDuplicate {

	public static void main(String[] args) {
		String str = "sukanya";
		boolean isDuplicate = false; 
		
		boolean flags[] = new boolean [26];
		
		for(int i = 0; i < str.length(); i++) {
			int pos = str.charAt(i) - 'a';
			
			if(flags[pos] == true) {
				isDuplicate = true;
			}
			else {
				flags[pos] = true;
			}
		}
		
		System.out.println("Duplicates = " + isDuplicate);
		char tempArray[] = str.toCharArray();
		
		for(int n = tempArray.length; n >= 1; n--)
		{
			for(int i = 0; i < n-1; i++)
			{
				if(	tempArray[i] > tempArray[i+1])
				{
					char c = tempArray[i];
					tempArray[i] = tempArray[i+1];
					tempArray[i+1] = c;
				}
			}
		}
		System.out.println("Sorted String - ");
		for(int i=0; i < tempArray.length; i++) {
			System.out.println(tempArray[i]);
		}
	}

}
