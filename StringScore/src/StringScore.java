
public class StringScore {

	public static void main(String[] args) {
//		String str = new String("code");
//		
//		int score = scoreOfString(str);
//		System.out.println("Score - " + score);

		int []nums = {1,4,1,2};
		int []ans = getConcatenation(nums);
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	public static int[] getConcatenation(int[] nums) {
        int []ans = new int[2 * nums.length];
        
        for(int i = 0; i < nums.length; i++) {
        	ans[i] = nums[i];
        	ans[nums.length + i] = nums[i];
        }
        return ans;
    }

	public static int scoreOfString(String s) {
        int score = 0;
        
        for (int i = 1; i < s.length(); i++) {
        	score = score + (int) Math.abs(s.charAt(i) - s.charAt(i-1));
        }
        return score;
    }
}
