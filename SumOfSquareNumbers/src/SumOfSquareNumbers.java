
public class SumOfSquareNumbers {

	public static void main(String[] args) {
		int c = 4;
		
		boolean nosExist = judgeSquareSum(c);
		System.out.println("Numbers Exist? (true / false) - " + nosExist);
	}
	
	public static boolean judgeSquareSum(int c) {
		boolean nosExist = false;
		
		for(int i = 1; i < c-1; i++) {
			int sum = i * i;
			for(int j = i+1; j < c; j++) {
				sum = sum + j*j;
				if(sum == c) {
					nosExist = true;
					return nosExist;
				}
					
			}
		}
        return nosExist;
    }
}
