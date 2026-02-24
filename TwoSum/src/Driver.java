
public class Driver {

	public static void main(String[] args) {
		int []numbers = {2,3,4};
		int target = 6;
		
		int []result = twoSum(numbers, target);
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	public static int[] twoSum(int[] numbers, int target) {
        int []indices = new int[2];
        int len = numbers.length;

        for(int i = 0; i < len-1; i++) {
            for(int j = i+1; j <len; j++) {
                if((numbers[i] + numbers[j]) == target) {
                    indices[0] = i+1;
                    indices[1] = j+1;
                    break;
                }
            }
        }
        return indices;
    }
}
