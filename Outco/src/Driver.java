import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List <Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,7,3,6,5,6));
		int index = findFulcrum(numbers);
		System.out.println(index);
	}
	
	public static int findFulcrum(List<Integer> numbers) {
        int index = -1, leftSum = 0, rightSum = 0;

        //Collections.sort(numbers);
        int size = numbers.size()-1;

        leftSum = numbers.get(0);
        rightSum = numbers.get(size);
        int i = 0, j = size;
        
        while(!(i > j) && (i <= size) && (j >=0 )){
            
            if(leftSum < rightSum){
                i++;
                leftSum += numbers.get(i);
            }

            else {
            	if(leftSum > rightSum){
            		j--;
            		rightSum += numbers.get(j);
            	}
            }

            if(leftSum == rightSum){
                index = i;
                return index+1;
            }
        }
        return index;
    }


}
