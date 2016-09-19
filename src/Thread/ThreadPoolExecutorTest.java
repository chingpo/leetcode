package Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPoolExecutorTest {
	 public static void main(String[] args) {
	  ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	  for (int i = 0; i < 10; i++) {
	   final int index = i;
	   try {
	    Thread.sleep(index * 1000);
	   } catch (InterruptedException e) {
	    e.printStackTrace();
	   }
	   cachedThreadPool.execute(new Runnable() {
	    public void run() {
	     System.out.println(index);
	    }
	   });
	  }
	 }
	}
//线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。