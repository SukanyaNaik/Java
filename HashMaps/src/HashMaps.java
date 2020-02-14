import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMaps {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String,Integer> directory = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            directory.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            
            if(directory.get(s) != null) {
            	int phone = directory.get(s);
            	System.out.println(s+"="+phone);
            }
            else {
            	System.out.println("Not Found");
            }
        }
        in.close();

	}

}
