import java.util.ArrayList;
import java.util.List;

public class combinationSum {

	public static void main(String[] args) {
		int []nums = {2,5,6,9};
		int target = 9;
		
		List<List<Integer>> results = getCombinationSum(nums, target);
		//List<List<Integer>> results = combinationSums(nums, target);
		
		for(int i = 0; i < results.size(); i++) {
			List<Integer> res = results.get(i);
			for(int j = 0; j < res.size
					(); j++) {
				System.out.print(res.get(j));
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> getCombinationSum(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> subset = new ArrayList<>();
		int sum = 0;
        dfs(0, nums, target, subset, sum, results);
       
		return results;
	}
	
	public static void dfs(int i, int[] nums, int target, List<Integer> subset, int sum, List<List<Integer>> results) {
		if(sum == target) {
			results.add(new ArrayList<Integer>(subset));
			return;
		}
		
		if(i >= nums.length || sum > target)
			return;
		
		subset.add(nums[i]);
		dfs(i, nums, target, subset, sum + nums[i], results);
		
		subset.remove(subset.size()-1);
		dfs(i+1, nums, target, subset, sum, results);
	}
	
	
	
	public static List<List<Integer>> combinationSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs1(0, nums, target, new ArrayList<>(), 0, res);
        return res;
    }

    private static void dfs1(int i, int[] nums, int target, List<Integer> cur, int total, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(cur)); // copy current list
            return;
        }

        if (i >= nums.length || total > target) {
            return;
        }

        // Choose nums[i]
        cur.add(nums[i]);
        dfs1(i, nums, target, cur, total + nums[i], res);

        // Backtrack
        cur.remove(cur.size() - 1);

        // Skip nums[i]
        dfs1(i + 1, nums, target, cur, total, res);
    }
}
