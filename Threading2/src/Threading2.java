
public class Threading2 {

	public static void main(String[] args) {
		Runnable runnable =() -> {
			while(true) {
				sleep(1000);
				System.out.println("Running");
			}
		};

		Thread thread = new Thread (runnable);
		thread.setDaemon(true);
		thread.start();
		sleep(3000);
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
