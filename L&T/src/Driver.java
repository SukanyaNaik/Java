
public class Driver {

	public static void main(String[] args) {
		int[] A = {-1, -3};
		boolean flag = false;
		int count = 1;
		for(int i = 0; i < A.length; i++, count++) {
			int j;
            for(j = 0; j < A.length; j++){
                if(count == A[j]){
                    break;
                }
            }
            if(j == A.length) {
            	System.out.println("count = " + (count));
            	flag = true;
            }
            
        }
		
		if(flag == false) {
			System.out.println("count = " + (count));
		}
	}

}
