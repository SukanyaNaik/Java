
public class RotateArray {

	public static void main(String[] args) {
//		int []nums = {1,2,3,4,5,6,7};
//		int k = 3;
		
		int []nums = {-1};
		int k = 2;
		
		rotate(nums, k);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	public static void rotate(int[] nums, int k) {
		int []temp = new int[k];
		int len = nums.length;
		
		for(int i = len-k, j = 0; j < k; i++, j++) {
			temp[j] = nums[i];
		}
		
		for(int i = len-(k+1), j = len-1; i >= 0; i--, j--) {
			nums[j] = nums[i];
		}
		
		for(int i = 0; i < k; i++) {
			nums[i] = temp[i];
		}
        
    }

}
