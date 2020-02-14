import java.util.Arrays;
import java.util.Scanner;

public class StringGridChallenge {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

	int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
    	int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
        	String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String result = gridChallenge(grid);
        System.out.println(result);
	}
    scanner.close();
}
        static String gridChallenge(String[] grid) {
            int i = 0, j = 0, n = 0, flag = 0, size = 0;
            char c1 = ' ', c2 = ' ';
            String ascending = "YES";
                        
            n = grid.length;

            for(i = 0; i < n ; i++) {
            	
                char[] chars = grid[i].toCharArray();
                Arrays.sort(chars);
                grid[i] = new String(chars);
            }

            size = grid[0].length();
            for(i = 0; i < size && flag == 0; i++){
                flag = 0;
               
                for(j = 0; j < (n-1) && flag == 0; j++) {
                	c1 = grid[j].charAt(i);
                	c2 = grid[j+1].charAt(i);
                    if(c1 > c2) {
                        flag = 1;
                        ascending = "NO";
                    }
                }
            }

            return ascending;
        }

}
