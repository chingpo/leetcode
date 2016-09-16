package dp;
import java.util.*;

//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//For example, given s = "leetcode", dict = ["leet", "code"].
//
//Return true because "leetcode" can be segmented as "leet code".
//动态规划   /(ㄒoㄒ)/~~

public class wordPrase2 {

	  public static boolean wordBreak2(String s, Set<String> dict) {
	        int length=s.length();
	        if(length<1)
	            return true;
	        boolean[] dp=new boolean[length+1];//默认值为false
	        dp[0]=true;
	        for(int i=0;i<length;i++){
	            if(dp[i]){
	                for(int j=i;j<length;j++){           
	                    if(dict.contains(s.substring(i,j+1))){//endIndex-1
	                        dp[j+1]=true;
	                    }
	                }
	            }
	        }
	        return dp[length];
	    }
	
public static void main(String[] args) {
	String s = "leetcode";
	Set<String> dict = new HashSet<String>();
	dict.add("leet");
	dict.add("code");
	boolean res=wordBreak2(s,dict);
	System.out.println(res);

}
}
