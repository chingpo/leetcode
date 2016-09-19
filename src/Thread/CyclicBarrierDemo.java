package Thread;

import java.util.concurrent.CyclicBarrier;

import org.junit.Test;

public class CyclicBarrierDemo {


	    @Test
	    public void test() {
	    	//当await的数量到达了设定的数量后，首先执行该Runnable对象。 
	        final CyclicBarrier barrier = new CyclicBarrier(2, myThread);
	        new Thread(new Runnable() {
	            public void run() {
	                try {
	                    System.out.println(Thread.currentThread().getName());
	                    barrier.await();
	                    System.out.println(Thread.currentThread().getName());
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }, "thread1").start();

	        new Thread(new Runnable() {
	            public void run() {
	                try {
	                    System.out.println(Thread.currentThread().getName());
	                    barrier.await();
	                    System.out.println(Thread.currentThread().getName());
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        }, "thread2").start();
	      
	    }

	    Thread myThread = new Thread(new Runnable() {
	        public void run() {
	            System.out.println("myThread");
	        }
	    }, "thread3");
	    
	
}

