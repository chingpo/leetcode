package Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;  
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class ThreadPoolExecutorTest4 {  
	public static void main(String[] args) {  
		  ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();  
		  for (int i = 0; i < 10; i++) {  
		   final int index = i;  
		   singleThreadExecutor.execute(new Runnable() {  
		    public void run() {  
		    	 try {  
		    	      while(true) {  
		    	       System.out.println(index);  
		    	       Thread.sleep(10 * 1000);  
		    	      }  
		    	     } catch (InterruptedException e) {  
		    	      e.printStackTrace();  
		    	     }  
		    	    }  
		   });  
		   try {  
			    Thread.sleep(500);  
			   } catch (InterruptedException e) {  
			    e.printStackTrace();  
			   }  
		  }  
		 }  
}
//结果依次输出，相当于顺序执行各个任务。
 
