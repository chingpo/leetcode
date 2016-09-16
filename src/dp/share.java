package dp;

import java.util.Arrays;

public class share {
	 public static int candy(int[] ratings) {
	        if(ratings==null || ratings.length==0) {
	            return 0;
	        }
	         
	        int[] count = new int[ratings.length];
	        //每个孩子初始都有一个糖果
	        Arrays.fill(count,1);
	        int sum = 0;
	        for(int i=1;i<ratings.length;i++) {
	            if(ratings[i]>ratings[i-1]) {
	                count[i] =count[i-1]+1;
	            }
	        }
	       
	        for(int i=ratings.length-1;i>0;i--) {
	            if(ratings[i]<ratings[i-1]&& count[i]>=count[i-1]) {
	                count[i-1]=count[i]+1;
	            }
	        }
	       for(int i=0;i<count.length;i++){
	    	  sum+=count[i]; 
	       }
	        
	         
	        return sum;
	    }
	 public static void main(String[] args) {
		int[] arr={2,3,1,3,2,1};
		System.out.println(candy(arr));
	}
}
