import java.util.ArrayList;
import java.util.List;

public class Result {

	public static void main(String[] args) {
		List <Integer> unsorted = new ArrayList<Integer>();
		unsorted.add(5);
		unsorted.add(2);
		unsorted.add(7);
		unsorted.add(8);
		unsorted.add(-2);
		unsorted.add(25);
		unsorted.add(25);
		
		unsorted.sort(null);
		
		for(int i = 0; i < unsorted.size(); i++) {
			System.out.println(unsorted.get(i));
		}
	}

}
