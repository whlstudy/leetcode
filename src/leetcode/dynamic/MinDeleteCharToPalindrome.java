package leetcode.dynamic;

// 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？输出需要删除的字符个数。
public class MinDeleteCharToPalindrome {
    public static void main(String[] args) {
        System.out.println(minDeleted("acudacccca"));
    }

    public static int minDeleted(String str){
        if(str.length() == 1) return 0;
        int[][] dp = new int[str.length()][str.length()];
        // 初始化单个字符情况
        for(int i = 0;i < str.length();i++){
            dp[i][i] = 0;
        }
        // 斜着遍历
        for(int m = 2;m <= str.length();m++){
            for(int i = 0;i < str.length()-m+1;i++){
                int j = m + i -1;
                if(str.charAt(i) == str.charAt(j)) {
                    if (i == j - 1)
                        dp[i][j] = 0;
                    else dp[i][j] = dp[i + 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i][j-1],dp[i+1][j])+1;
                }
            }
        }
        return dp[0][str.length()-1];
    }
}
