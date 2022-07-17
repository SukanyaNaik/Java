import java.util.HashMap;
import java.util.Map;

public class Driver {

	public static void main(String[] args) {
		//int nums [] = new int []{2,1};
		//int nums [] = new int []{3,4,-1,1};
		int nums [] = new int []{1,2,6,3,5,4};
		
		int no = firstMissingPositive(nums);
		
		System.out.println("Smallest missing number = " + no);

	}
	
	public static int firstMissingPositive(int[] nums) {
	     int no = 1;
	     Map <Integer, Integer> map = new HashMap<Integer, Integer>();
	     
	     for(int i = 0; i < nums.length; i++) {
	    	 map.put(nums[i], nums[i]);
	    	 if(no == nums[i])
	    		 no++;
	     }
	     
	     while(map.containsKey(no))
	    	 no++;
    	 return no;
	}

}
