import java.util.HashMap;
import java.util.Map;

public class Driver {

	public static void main(String[] args) {
		int array[] = new int []{2,7,11,15};
		int target = 9;
		int pos [] = twoSum(array, target);
		
		System.out.println("Indices = " + pos[0] + ", " + pos[1]);
	}
	
	 public static int[] twoSum(int[] nums, int target) {
	        Map <Integer, Integer> map = new HashMap<Integer, Integer>();
	        
	        for(int i=0; i < nums.length; i++) {
	        	int compliment = target - nums[i];
	        	if(map.containsKey(compliment)) {
	        		return new int[] {i, map.get(compliment)};
	        	}
	        	else {
	        		map.put(nums[i], i);
	        	}
	        }
	        return null;
	    }

}
