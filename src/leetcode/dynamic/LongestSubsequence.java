package leetcode.dynamic;

/**
 * 公共子序列可以不连续
 *
 * 使用动态规划求解最长公共子序列长度以及输出最长公共子序列(随机一个)
 *
 * 动态规划求解最长公共子序列长度时间复杂度为O(m*n)
 * 根据生成的动态规划数组逆解随机一个最长公共子序列时间复杂度O(m+n)
 */
public class LongestSubsequence {
    static int[][] dp;

    public static void main(String[] args) {
        System.out.println(longestSubsequenceLen("helloworld", "loop"));
        System.out.println(longestSubsequenceStr("helloworld", "loop"));
    }

    /**
     * dp求最长公共子序列
     */
    public static int longestSubsequenceLen(String strA, String strB) {
        dp = new int[strA.length() + 1][strB.length() + 1];
        for (int i = 0; i <= strA.length(); i++) {
            for (int j = 0; j <= strB.length(); j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (strA.charAt(i - 1) == strB.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        printArr(dp);
        return dp[strA.length()][strB.length()];
    }

    /**
     * 通过dp数组逆推其中随机的一个最长公共子序列
     * 比较随机
     */
    public static String longestSubsequenceStr(String strA, String strB) {
        StringBuilder sb = new StringBuilder();
        int i = dp.length-1;
        int j = dp[0].length-1;
        while (i > 0 && j > 0) {
            if (strA.charAt(i - 1) == strB.charAt(j - 1)) {
                sb.append(strA.charAt(i - 1));
                i--;
                j--;
            } else {
                if(dp[i-1][j] >= dp[i][j-1]){
                    i--;
                }else {
                   j--;
                }
            }
        }
        return sb.reverse().toString();
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
