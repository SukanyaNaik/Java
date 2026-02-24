import java.util.ArrayList;
import java.util.List;

public class CoinChange {

	public static void main(String[] args) {
		int []coins = {1,2,3};
		int amount = 5;

		int count = coinChange(coins, amount);
		System.out.println("Count - " + count);
	}
	
	public static int coinChange(int[] coins, int amount) {
		int count = 0;
		List<List<Integer>> coinList = new ArrayList<List<Integer>>();
		for(int i = 0; i < coins.length; i++) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(coins[i]);
			dfs(0, coins[i], amount, coins, l, coinList);
		}
		
		return count;
    }
	
	public static void dfs(int j, int sum, int amount, int[]coins, List<Integer>l, List<List<Integer>> coinList) {
		if(sum == amount) {
			coinList.add(l);
			sum = sum - coins[j];
			l.removeLast();
			j++;
			dfs(j, sum, amount, coins, l, coinList);
		}
		
		if(sum > amount) {
			sum = sum - coins[j];
			l.removeLast();
			j++;
			dfs(j, sum, amount, coins, l, coinList);
		}
		
		if(j == coins.length)
			return;
		
		l.add(coins[j]);
		sum = sum + coins[j];
		dfs(j, sum, amount, coins, l, coinList);
	}
}
