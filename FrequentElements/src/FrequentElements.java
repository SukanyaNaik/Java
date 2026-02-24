import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FrequentElements {

	public static void main(String[] args) {
		//int []nums = {1,2,2,2,3,3,3};
		//int []nums = {1,2};
		int []nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
		int k = 10;
		
		int []result = topKFrequent(nums, k);
		for (int i = 0; i < k; i++) {
			System.out.println(result[i]);
		}
	}
	
	 public static int[] topKFrequent(int[] nums, int k) {
		 int []result = new int[k];
		 int []count = new int[k];
		 
		 Arrays.sort(nums);
		 for(int i = 0; i < nums.length; i++) {
			 System.out.print(nums[i] + " ");
		 }
		 Map <Integer, Integer> noMap = new HashMap<Integer, Integer>();
		 Map <Integer, List<Integer>> countMap = new HashMap<Integer, List<Integer>>();
		 
		 for (int i = 0 ; i < nums.length; i++) {
			 if (noMap.containsKey(nums[i])) {
				 int frequency = noMap.get(nums[i]) + 1;
				 noMap.put(nums[i], frequency);
				 
			 } else {
				 noMap.put(nums[i], 1);
			 }
		 }
		 
		 for (Entry<Integer, Integer> entry : noMap.entrySet()) {
			 if (countMap.containsKey(entry.getValue())) {
				 List <Integer> noList = countMap.get(entry.getValue());
				 noList.add(entry.getKey());
				 countMap.put(entry.getValue(), noList);
			 } else {
				 List <Integer> noList = new ArrayList<Integer>();
				 noList.add(entry.getKey());
				 countMap.put(entry.getValue(), noList);
			 }
		 }
		 
		 for (int i = nums.length; i >=0; i--) {
			 if (countMap.containsKey(i)) {
				 int s = countMap.get(i).size();
				 int j = 0;
				 
				 while(j < k && count[j] != 0)
					 j++;
				 
				 for(int l = j, a = 0; l < k && a < s; l++, a++) {
					 count[l] = i;
				 }
			 }
		 }
		 
		 for (int i = 0; i < k; i++) {
			 List <Integer> no = countMap.get(count[i]);
			 if (no.size() == 1) {
				 int j = 0;
				 while(j < k && result[j] != 0)
					 j++;
				 if(j < k)
					 result[j] = no.getFirst();
			 }
			 else {
				 int j = 0;
				 while(j < k && result[j] != 0)
					 j++;
				 
				 for (int l = 0; j < k && l < no.size(); l++) {
						 result[j] = no.get(l);
						 j++;
						 i++;
				 }
				 i--;
			 }
		 }
		 
		 Arrays.sort(result);
		 return result;
	 }

}
