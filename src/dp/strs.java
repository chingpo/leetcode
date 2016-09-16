package dp;

public class strs {
	public static int numDistinct(String S, String T) {  
        if (S == null || T == null) return 0;  
        if (S.equals("") || T.equals("")) return 0;  
          
        //table[i][j]表示S[0~i]中有多少个T[0~j]的个数  
        int[][] table = new int[S.length()][T.length()];  
          
        //给table第一行赋值，意思是S[0]中有多少个T[0~j]  
        //显然，S[0]最多包含一个T[0]，故table[0][1~n]都为0  
        if (S.charAt(0) == T.charAt(0)) {  
            table[0][0] = 1;  
        }  
          
        for (int i = 1; i < S.length(); i++) {  
            char s = S.charAt(i);  
              
            //给table[i][0]赋值，意思是S[0~i]中有多少个T[0]  
            if (s == T.charAt(0)) {  
                table[i][0] = table[i - 1][0] + 1;  
            } else {  
                table[i][0] = table[i - 1][0];  
            }  
              
            for (int j = 1; j < T.length(); j++) {  
                char t = T.charAt(j);  
                if (s == t) {  
                    //如果用S[i]匹配T[j]，那么S[0~i-1]中共有table[i-1][j-1]个T[0~j-1]  
                    //如果不用S[i]匹配T[i]，那么S[0~i]中共有table[i-1][j]个T[0~j]  
                    table[i][j] = table[i - 1][j - 1] + table[i - 1][j];  
                } else {  
                    //S[i]!=T[j]时，S[0~i]中共有table[i-1][j]个T[0~j]  
                    table[i][j] = table[i - 1][j];  
                }  
            }  
              
        }  
          
        return table[S.length() - 1][T.length() - 1];  
    }  
	public static void main(String[] args) {
		String s="rabbbit";
		String t="rabit";
		System.out.println(numDistinct(s, t));
	}

}
