import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		
		File f = new File("demo.txt");
		
		/*FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		DataOutputStream dos = new DataOutputStream(fos);
		
		try {
			dos.writeUTF("New to File Handling!");
			dos.writeUTF("First File Handling Demo");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		/*FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DataInputStream dis = new DataInputStream(fis);
		try {
			while(dis != null) {
				String str = dis.readUTF();
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		 
		/*FileWriter fw = null;
		try {
			fw = new FileWriter("demo.txt");
			String str = "New to File Handling!";
			fw.write(str);
			str = "First File Handling Demo.";
			fw.write(str);
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
	
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  
	    String st; 
		try {
			int i = 0;
			while ((st = br.readLine()) != null) {
				System.out.println("i = " + i + " "+ st);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
