package dp;
import java.util.*;
public class triangle {
	 public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		 
		 if(triangle==null)
	            return 0;
	        int first = triangle.get(0).get(0);//第一个数
	        if(triangle.size()==1)
	            return first;
	        //不需要O(n)的辅助空间，只需要最底层长度大小的辅助空间
	      
	        
	        
	        
	        
	        int maxSize= triangle.get(triangle.size()-1).size();
	        int[] a = new int[maxSize];
	        a[0] = first;
	        int min = Integer.MAX_VALUE;
	        //遍历triangle
	        for(int i = 1;i<triangle.size();i++){
	            ArrayList<Integer> list = triangle.get(i);
	            int temp = a[0];
	            for(int j = 0;j<list.size();j++){
	                int minCost = j==0||j+1==list.size()?temp:Math.min(temp, a[j]);
	                temp = a[j];
	                a[j] = list.get(j)+minCost;
	                if(i+1==triangle.size()){
	                    //最后一层
	                    if(a[j]<min)
	                        min = a[j];
	                }
	            }
	        }
	        return min;
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
