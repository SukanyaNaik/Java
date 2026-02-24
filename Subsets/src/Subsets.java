import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int []nums = {1,2,3};
		//int []nums = {0};
		//int []nums = {3,2,4,1};
		List<List<Integer>> subset = getSubsets(nums);
		for(int i = 0; i < subset.size(); i++) {
			List<Integer> list = subset.get(i);
			for(int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    private static void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, res);
    }

//	 public static List<List<Integer>> getSubsets(int[] nums) {
//		 List<List<Integer>> subset = new ArrayList<List<Integer>>();
//		 
//		 List<Integer> emptyList = new ArrayList<Integer>();
//		 subset.add(emptyList);
//		 List<Integer> allList = new ArrayList<Integer>();
//		 for (int i = 0; i < nums.length; i++) {
//			 if(i == 0)
//				 subset.add(Arrays.asList(nums[i]));
//			 if(nums.length > 1)
//				 allList.add(nums[i]);
//			 for(int j = i+1; j < nums.length; j++) {
//				 if(!subset.contains(Arrays.asList(nums[j])))
//					 subset.add(Arrays.asList(nums[j]));
//				 if(!subset.contains(Arrays.asList(nums[i], nums[j]))) {
//					 if(nums[i] < nums[j])
//						 subset.add(Arrays.asList(nums[i], nums[j]));
//					 else
//						 subset.add(Arrays.asList(nums[j], nums[i]));
//				 }
//			 }
//		 }
//		 if(nums.length > 2)
//			 subset.add(allList);
//		 return subset;
//	 }
}
