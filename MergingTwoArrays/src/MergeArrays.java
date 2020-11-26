import java.util.ArrayList;

public class MergeArrays {

	public static void main(String[] args) {
		int []a = {1,5,7,7};
		int []b = {0,1,2,3};
		
		MergeArrays.mergeArrays(a,b);
	}

	public static void mergeArrays(int []a, int []b) {
		
		//int size = a.length+b.length; 
		ArrayList <Integer> c = new ArrayList<Integer>();
		int i = 0, j = 0, k = 0;
		
		do{
			if(a[i] < b[j]) {
				c.add(a[i]);
				i++;
			}
			else if(a[i] > b[j]) {
				c.add(b[j]);
				j++;
			}
			else if(a[i] == b[j]) {
				c.add(a[i]);
				i++;
				c.add(b[j]);
				j++;
			}
			
		}while(i < a.length && j < b.length);
		
		for(k = i; k < a.length; k++) {
			c.add(a[k]);
		}
		
		for(k = j; k < b.length; k++) {
			c.add(b[k]);
		}
		
		for(k = 0; k < c.size(); k++) {
			System.out.print(c.get(k) + " ");
		}
	}
}
