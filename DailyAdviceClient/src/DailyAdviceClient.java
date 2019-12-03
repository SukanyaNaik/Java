import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {

	public static void main(String[] args) {
		
		DailyAdviceClient client = new DailyAdviceClient();
		
		client.start();
	}
	
	public void start() {
		try {
			Socket socket = new Socket("127.0.0.1", 4242);
			InputStreamReader stremReader = new InputStreamReader(socket.getInputStream());
			BufferedReader reader = new BufferedReader(stremReader);
			
			String advice = reader.readLine();
			System.out.println(advice);
			
			reader.close();
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
