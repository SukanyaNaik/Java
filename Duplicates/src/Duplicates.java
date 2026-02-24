import java.util.HashMap;
import java.util.Map;

public class Duplicates {

	public static void main(String[] args) {
		int []nums = {1,2,3,4};
		
		boolean ifDuplicates = hasDuplicate(nums);
		
		System.out.println("Contains duplicate - " + ifDuplicates);

	}

	 public static boolean hasDuplicate(int[] nums) {
		 Map <Integer, Integer> numsMap = new HashMap<Integer, Integer>();
		 boolean ifDuplicates = false;
		 
		 for (int i = 0; i < nums.length; i++) {
			 if (numsMap.containsKey(nums[i])) {
				 return true;
			 } else {
				 numsMap.put(nums[i], 1);
			 }
		 }
		 return ifDuplicates; 
	 }
}
