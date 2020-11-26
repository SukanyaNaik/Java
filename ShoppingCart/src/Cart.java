import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	public static void main(String[] args) {
		ArrayList<Integer> priceOfJeans = new ArrayList<Integer>(Arrays.asList(2,3));
		ArrayList<Integer> priceOfShoes = new ArrayList<Integer>(Arrays.asList(4));
		ArrayList<Integer> priceOfSkirts = new ArrayList<Integer>(Arrays.asList(2));
		ArrayList<Integer> priceOfTops = new ArrayList<Integer>(Arrays.asList(1,2,3));
		int budgeted = 10;
		
		long no = Cart.getNumberOfOptions(priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops, budgeted);
		System.out.println(Cart.solve(budgeted, priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops));
		System.out.println("Number of Options - " + no);
	}
	
	public static long getNumberOfOptions(ArrayList <Integer>priceOfJeans, ArrayList <Integer>priceOfShoes, 
			ArrayList <Integer>priceOfSkirts, ArrayList <Integer>priceOfTops, int budgeted) {
		
		/*long numberOfOptions = 0;
		
		for(int i = 0; i < priceOfJeans.size(); i++) {
			int total = 0;
			for(int j = 0; j < priceOfShoes.size(); j++) {
				for(int k = 0; k < priceOfSkirts.size(); k++) {
					for(int l = 0; l < priceOfTops.size(); l++) {
						total = priceOfJeans.get(i) + priceOfShoes.get(j) + priceOfSkirts.get(k) + priceOfTops.get(l);
						
						if(total <= budgeted) {
							numberOfOptions++;
						}
					}
				}
			}
		}
		
		return numberOfOptions;*/
		
		/*long numberOfOptions = 0;

        int pOfJeans = 0, pOfShoes = 0, pOfSkirts = 0;

        int sizeOfJeans = priceOfJeans.size();
        int sizeOfShoes = priceOfShoes.size();
        int sizeOfSkirts = priceOfSkirts.size();
        int sizeOfTops = priceOfTops.size();
        
        for(int i = 0; i < sizeOfJeans; i++){
            long total = 0, temp = 0;

            temp = priceOfJeans.get(i);
            pOfJeans = priceOfJeans.get(i);

            if(temp >= budgeted){
                continue;
            }

            for(int j = 0; j < sizeOfShoes; j++){

                pOfShoes = priceOfShoes.get(j);
                temp = pOfJeans + pOfShoes;

                if(temp < budgeted){

                    for(int k = 0; k < sizeOfSkirts; k++){
                        pOfSkirts = priceOfSkirts.get(k);
                        temp = pOfJeans + pOfShoes + pOfSkirts;
 
                        if(temp < budgeted) {
 
                            for(int l = 0; l < sizeOfTops; l++){

                                total = pOfJeans + pOfShoes + pOfSkirts + priceOfTops.get(l);

                                if(total <= budgeted){
                                    numberOfOptions++;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return numberOfOptions;*/
		
		long numberOfOptions = 0;

        int pOfJeans = 0, pOfShoes = 0, pOfSkirts = 0;

        int sizeOfJeans = priceOfJeans.size();
        int sizeOfShoes = priceOfShoes.size();
        int sizeOfSkirts = priceOfSkirts.size();
        int sizeOfTops = priceOfTops.size();
        
        Collections.sort(priceOfJeans);
        Collections.sort(priceOfShoes);
        Collections.sort(priceOfSkirts);
        Collections.sort(priceOfSkirts);
        
        for(int z = 0; z < sizeOfJeans; z++) {
        	System.out.println(priceOfJeans.get(z) + " ");
        }
        for(int i = 0; i < sizeOfJeans; i++){
            long total = 0, temp = 0;

            temp = priceOfJeans.get(i);
            pOfJeans = priceOfJeans.get(i);

            if(temp >= budgeted){
                break;
            }

            for(int j = 0; j < sizeOfShoes; j++){

                pOfShoes = priceOfShoes.get(j);
                temp = pOfJeans + pOfShoes;

                if(temp < budgeted){

                    for(int k = 0; k < sizeOfSkirts; k++){
                        pOfSkirts = priceOfSkirts.get(k);
                        temp = pOfJeans + pOfShoes + pOfSkirts;
 
                        if(temp < budgeted) {
 
                            for(int l = 0; l < sizeOfTops; l++){

                                total = pOfJeans + pOfShoes + pOfSkirts + priceOfTops.get(l);

                                if(total <= budgeted){
                                    numberOfOptions++;
                                }
                                else {
                                	break;
                                }
                            }
                        }
                        else {
                        	break;
                        }
                    }
                }
                else {
                	break;
                }
            }
        }
        
        return numberOfOptions;
	}
	
	private static int solve(int k, ArrayList <Integer>priceOfJeans, ArrayList <Integer>priceOfShoes, 
			ArrayList <Integer>priceOfSkirts, ArrayList <Integer>priceOfTops) {
		
		int[][] dp = new int[4][k + 1];
		int res = 0;
		
		Map<Integer, ArrayList <Integer>> map = new HashMap<>();
		map.put(1, priceOfShoes);
		map.put(2, priceOfSkirts);
		map.put(3, priceOfTops);
		
		for(int i=0;i<dp.length;i++) {
				if(i == 0) {	
					for(int a=0;a<priceOfJeans.size();a++) {
						dp[i][priceOfJeans.get(a)] = 1;
					}
				}else{
					for(int j=0;j<dp[0].length;j++) {
						for(int a=0;a<map.get(i).size();a++) {
							if(dp[i-1][j] > 0 && j + map.get(i).get(a) <= k) {
								dp[i][j + map.get(i).get(a)] += dp[i-1][j];
							}
						}
				}
			}
		}
		
		for(int j=0;j<dp[0].length;j++) {
			res += dp[3][j];
		}
		return res;
		
		/*int [][]dp = new int[4][budgeted+1];
        int res = 0;

        Map<Integer, List <Integer>> map = new HashMap<>();
        map.put(1, priceOfShoes);
        map.put(2, priceOfSkirts);
        map.put(3, priceOfTops);
        
        for(int i = 0; i < dp.length; i++){
            if(i == 0){
                for(int k = 0; k < priceOfJeans.size(); k++){
                    dp[i][priceOfJeans.get(k)] = 1;
                }
            }
            else{
                for(int j = 0; j < dp[0].length; j++){
                    for(int k = 0; k < map.get(i).size(); k++){

                        if(dp[i-1][j] > 0 && j+map.get(i).get(k) <= budgeted){
                            dp[i][j+map.get(i).get(k)] += dp[i-1][j];
                        }
                    }
                }
            }
        }

        for(int i = 0; i < dp[0].length; i++) {
                res += dp[3][i];
        }

        return res;*/
	}
	
	

}
