package leetcode.dynamic;


/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a leetcode.string is a new leetcode.string generated from the original leetcode.string with some characters(can be none)
 * deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde"
 * while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 * If there is no common subsequence, return 0.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc","ac"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = 0;i <= text1.length();i++){
            for(int j = 0;j <= text2.length();j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
                else if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
