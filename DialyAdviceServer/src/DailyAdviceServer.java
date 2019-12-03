import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

	String[] adviceList = {"Do not pray for an easy life, pray for the strength to endure a difficult one.", 
			               "It is unwise to be part of what reduces you to less than yourself.",
			               "You can't make someone understand a message they are nor ready to receive.",
			               "This too, shall pass.",
			               "Believe you can and you're halfway there.",
			               "Plant your garden and decorate your own soul, instead of waiting for someone to bring you flowers."};
	
	public static void main(String[] args) {
		
		DailyAdviceServer server = new DailyAdviceServer();
		server.start();
	}
	
	public void start() {
		
		try {
			ServerSocket serverSocket = new ServerSocket(4242);
			
			while (true) {
				Socket socket = serverSocket.accept();
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private String getAdvice() {
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}
}
