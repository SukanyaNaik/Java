import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LargeResponses {

	public static void main(String[] args) {

		String fileName = "hosts_access_log_00.txt";
		
		LargeResponses.numberOfRequests(fileName);
	}
	
	public static void numberOfRequests(String inputFileName) {
		
		String outputFileName = "bytes_" + inputFileName;
		File inputFile = new File(inputFileName);
		File outputFile = new File(outputFileName);
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  
		FileWriter fw = null;
		try {
			fw = new FileWriter(outputFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	    String str = " ";
	    int count = 0, totalBytes = 0;
	    
		try {
			while ((str = br.readLine()) != null) {
				String numberOfBytes = new String();
				
				int lastSpaceIndex = str.lastIndexOf(Character.toString(' '));
			
				for(int i = lastSpaceIndex+1; i < str.length(); i++) {
					numberOfBytes = numberOfBytes + Character.toString(str.charAt(i));
				}
				
				Integer noOfBytes = Integer.valueOf(numberOfBytes);
				System.out.println(noOfBytes);
				
				if(noOfBytes > 5000) {
					count++;
					totalBytes = totalBytes + noOfBytes;
				}
			}
			//System.out.println("\nCount - " + count + "\ntotalBytes - " + totalBytes);
			
			fw.write(Integer.toString(count));
			fw.write("\n");
			fw.write(Integer.toString(totalBytes));
			
			fw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		
		File inputFile2 = new File(outputFileName);

        try{
           br = new BufferedReader(new FileReader(inputFile2));
       }catch(FileNotFoundException e){
           e.printStackTrace();
       }

       try{
           while((str = br.readLine()) != null){
               System.out.println(str);
           }
       } catch(IOException e){
           e.printStackTrace();
       }
	}

}


/* Writer out = new BufferedWriter(new OutputStreamWriter
(new FileOutputStream(outputFile), StandardCharsets.UTF_8));

out.append(Integer.toString(count)).append("\r\n");
out.append(Long.toString(totalBytes));

out.flush();
out.close();*/