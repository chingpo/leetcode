package dp;
import java.util.*;
//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return all possible palindrome partitioning of s.
//
//For example, given s ="aab",
//Return
//
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]


//好难，好虐
public class str2 {
	
public static void main(String[] args) {
	String a="abcdcbab";
	System.out.println(getResult(a));
}

@SuppressWarnings("unchecked")
private static ArrayList<ArrayList<String>> getResult(String s) {
	 int len=s.length();
     ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
     if(len<=0){return null;}
     if(len==1){
         ArrayList<String> templist=new ArrayList<String>();
         templist.add(s);
         list.add( templist);
     }else{
         for(int i=1;i<len+1;i++){
             String temp=s.substring(0, i);
             if(isPalindrome(temp)){
                 if(i==len){
                     ArrayList<String> templist=new ArrayList<String>();
                     templist.add(temp);
                     list.add( templist);
                 }else {
                     List<?> list1=getResult(s.substring(i));
                     for(int j=0;j<list1.size();j++){
                         ArrayList<String> templist=new ArrayList<String>();
                         templist.add(temp);
                         templist.addAll((Collection<String>) list1.get(j));
                         list.add( templist);
                     }
                 }                                         
             }
         }
     }
     return list;
	


}
public static boolean isPalindrome(String s){
    boolean flag = true;
    for(int i=0,j=s.length()-1;i<j;i++,j--){
        if(s.charAt(i) != s.charAt(j)){
            flag = false;
            break;
        }
    }
    return flag;
}
}
