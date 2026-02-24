
public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int [] nums = {1,2,1,0,4,2,6};
		int k = 3;

		int [] result = maxSlidingWindow(nums, k);
		System.out.println("");
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	 public static int[] maxSlidingWindow(int[] nums, int k) {
		 int [] result = new int[nums.length-k+1];
		 
		 for(int i = 0; i < nums.length - k+1; i++) {
			 int max = -999999999;
			 
			 for(int j = i; j < i+k; j++) {
				 if(max < nums[j]) {
					 max = nums[j];
				 }
			 }
			 
			 result[i] = max;
		 }
		 
		 return result;
	 }
}
