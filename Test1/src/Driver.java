import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Driver {

	/*public static void main(String[] args) throws IOException {
		//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String s = bufferedReader.readLine();
		String s = "0100101";

        int result = Driver.minSwapsRequired(s);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedReader.close();
        //bufferedWriter.close();

	}

	
	 public static int minSwapsRequired(String s) {
		 int noOfSwaps = 0;
		 
		 int strLen = s.length();
		 
		 
		 return noOfSwaps;
	 }*/
	
	public static void main(String[] args) {
		List <Integer> processingPower = new ArrayList<Integer>();
		processingPower.add(4);
		processingPower.add(1);
		processingPower.add(4);
		processingPower.add(5);
		processingPower.add(3);
		//processingPower.add(12);
		
		List <Integer> bootingPower = new ArrayList<Integer>();
		bootingPower.add(8);
		bootingPower.add(8);
		bootingPower.add(10);
		bootingPower.add(9);
		bootingPower.add(12);
		//bootingPower.add(3);
		
		long powerMax = 33;
		
		int max = findMaximumSustainableClusterSize(processingPower, bootingPower, powerMax);
		System.out.println("Max - " + max);
	}
	
	 public static int findMaximumSustainableClusterSize(List<Integer> processingPower, List<Integer> bootingPower, long powerMax) {
		 int maxSize = 0;
	        int k = 2;
	        int size = processingPower.size();
	        
	        for(int l = k; l < size; l++){
	            int ppTotal = 0;
	            int max = 0;
	            
	            for(int i = 0; i <= (size-l); i++){
	            	max = bootingPower.get(i);
	            	ppTotal = processingPower.get(i);
	                for(int j = i+1; j < (i+l) && j < size; j++){
	                    //ppTotal = ppTotal + processingPower.get(j);
	                    if(max < bootingPower.get(j)){
	                        max = bootingPower.get(j);
	                    }
	                    ppTotal = ppTotal + processingPower.get(j);
	                }
	                int total = max + (ppTotal * l);
	                
	                if(total < powerMax){
	                    if(maxSize < l){
	                        maxSize = l;
	                    }
	                }
	            }
	        }
	        
	        
	        return maxSize;
	}
}
