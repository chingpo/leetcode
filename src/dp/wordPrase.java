package dp;
import java.util.*;

//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
//
//Return all such possible sentences.
//
//For example, given
//s ="catsanddog",
//dict =["cat", "cats", "and", "sand", "dog"].
//
//A solution is["cats and dog", "cat sand dog"]. 
//很好，第一道题就不会，先做做再分析。
//好好看题哪，喂！   动态规划  
public class wordPrase {
	public static  ArrayList<String> wordBreak(String s, Set<String> dict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(s, dict, map);
             
    }
     
    public static  ArrayList<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> map) {
        if (map.containsKey(s))
            return (ArrayList<String>) map.get(s);
         
        ArrayList<String> lists = new ArrayList<String>();
        if (s.equals(""))
            lists.add("");
        else {
            int len = s.length();
            for (int i = 1; i <= len; i++) {
                String sub = s.substring(0, i);
                if (dict.contains(sub)) {
                    ArrayList t = dfs(s.substring(i, len), dict, map);
                    if (t.size() == 0) {
                        continue;
                    } else {
                        for (int j = 0; j < t.size(); j++) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(sub).append(" ").append(t.get(j));
                            lists.add(sb.toString().trim());
 
                        }
                    }
                }
            }
        }
        map.put(s, lists);
        return lists;
    }
	
public static void main(String[] args) {
	String s = "catsanddog";
	Set<String> dict = new HashSet<String>();
	dict.add("cat");
	dict.add("cats");
	dict.add("and");
	dict.add("sand");
	dict.add("dog");
	List list=wordBreak(s,dict);
	for(int i = 0;i<list.size();i++){
		   System.out.print(list.get(i));
		  }

}
}
