package dp;
import java.util.*;
public class triangle {
	 public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		 
		 if(triangle==null)
	            return 0;
	        int first = triangle.get(0).get(0);//第一个数
	        if(triangle.size()==1)
	            return first;
	       int[] total=new int[triangle.size()];
	       int row=triangle.size()-1;
	       for(int i=0;i<triangle.get(row).size();i++){
	    	   total[i]=triangle.get(row).get(i);
	       }//初始化为最后一行的值
	       for(int i=row-1;i>=0;i--){
	    	   for(int j=0;j<triangle.get(i).size();j++){
	    		   total[j]=triangle.get(i).get(j)+Math.min(total[j], total[j+1]);//从下往上
	    	   }
	       }
	       return total[0];
	        
	        
	        
	     
	    }
	 public static void main(String[] args) {
		 ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
		 ArrayList<Integer> list=new ArrayList<Integer>();
		 list.add(-1);
		 arr.add(list);
		 ArrayList<Integer> list2=new ArrayList<Integer>();
		 list2.add(2);
		 list2.add(3);
		 arr.add(list2);
		 ArrayList<Integer> list3=new ArrayList<Integer>();
		 list3.add(1);
		 list3.add(-1);
		 list3.add(-3);
		 arr.add(list3);
		 System.out.println(minimumTotal(arr));
	}
}
