import java.lang.reflect.Array;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {2,4,5,8,11,15,20,21,24,30,35,37};
		BinarySearch obj = new BinarySearch();
		boolean isNo = false;
		int no = 2;
		
		isNo = obj.search(no, array);
		System.out.println("found = " + isNo);
	}
	
	public boolean search(int no, int array[]) {
		boolean found = false;
		int start = 0, end = 0, mid = 0, temp = 0;
		
		end = Array.getLength(array);
 		//mid = end / 2;
		
		//while(found == false && start!= end) {
		while(found == false && end >= start) {
			mid = start + (end-start) /2;
			if(array[mid] == no) {
				found = true;
			}
			else {
				if(array[mid] > no) {
					end = mid - 1;
					//mid = start + ((end+1) - start) / 2;
				}
				else {
					start = mid + 1;
					//mid = mid + ((end - (start-1)) / 2);
					
				}
			}
		}
		return found;
	}

}
