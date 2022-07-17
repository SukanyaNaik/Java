import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class Threading3 {
	private final static Lock lock = new ReentrantLock(true);
	private final static ReadWriteLock readWritelock = new ReadWriteLock() {
		
		@Override
		public Lock writeLock() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Lock readLock() {
			// TODO Auto-generated method stub
			return null;
		}
		
	};
	
	public static void main(String[] args) {
		lock.lock();
		try {
			System.out.println("Locked");
		} finally {
			lock.unlock();
		}
		Runnable runnable = () -> {
			for(int i = 0; i < 5; i++){
				sleep(1000);
				System.out.println("Running");
			}
		};

		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
		
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
