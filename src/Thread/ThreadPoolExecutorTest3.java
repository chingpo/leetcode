package Thread;
import java.util.concurrent.Executors;  
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class ThreadPoolExecutorTest3 {  
//	 public static void main(String[] args) {  
//		  ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);  
//		  scheduledThreadPool.schedule(new Runnable() {  
//		   public void run() {  
//		    System.out.println("delay 3 seconds");  
//		   }  
//		  }, 3, TimeUnit.SECONDS);  
//		 }  
//	表示延迟3秒执行。
	 public static void main(String[] args) {  
		  ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);  
		  scheduledThreadPool.scheduleAtFixedRate(new Runnable() {  
		   public void run() {  
		    System.out.println("delay 1 seconds, and excute every 3 seconds");  
		   }  
		  }, 1, 3, TimeUnit.SECONDS);  
		 }  
//	 表示延迟1秒后每3秒执行一次。
}
//支持定时及周期性任务执行
 