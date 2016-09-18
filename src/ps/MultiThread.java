package ps;

public class MultiThread {
	public static void main(String[] args) {
		new Thread(new Thread1()).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		new Thread(new Thread2()).start();
	}
private static class Thread1 implements Runnable{

		public void run(){
			synchronized (MultiThread.class) {
				System.out.println("enter Thread1...");
				System.out.println("Thread1 is waiting");
				try {
					MultiThread.class.wait();
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println("Thread1 is going on...");
				System.out.println("Thread1 is being over!");
			}
		}
			
	}
}
class Thread2 implements Runnable{
	
	public void run(){
		synchronized (MultiThread.class) {
			System.out.println("enter Thread2");
			System.out.println("Thread2 notify other thread can release wait status...");
			MultiThread.class.notify();
			System.out.println("Thread2 is sleeping ten millisecond...");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("Thread2 is going on...");
			System.out.println("Thread2 is being over!");
		}
	}
	
}
