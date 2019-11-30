package leetcode.dynamic;

/**
 * @author whl
 * @date 2019/10/12 4:33 下午
 * <p>
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 *
 * 当需要计算出最长回文子序列和返回最长回文子序列时，可以通过构造二维动态规划数组来记录路径，之后从最后一个字符往回找
 * 通过路径来得出最长回文子序列。
 *
 *
 * 当只需要求最长子序列长度时可以优化二维数组到一维数组
 */
public class LongestPalindromicSubsequence {

    private static int[][] dp;

    public static void main(String[] args) {
        String s = "abcasadajdskandjakdasdjandkjandkjasndkja";
        int len = longestPalindromeSubseq(s);
        String str = longestString(s, len);

        System.out.println("String len: " + len + "  str: " + str);
    }


    // 35% 5.5%  时间和空间消耗都比较大
    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        dp = new int[s.length()][s.length()];
        // 初始化
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        // 斜着遍历
        for (int num = 1; num < s.length(); num++) {
            for (int i = 0; i < s.length() - num; i++) {
                int j = num + i;
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j - 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    // 找出删除字符后的回文串 利用dp数组逆序找出
    private static String longestString(String str, int len) {
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        int j = str.length() - 1;
        while (i < j && len != 0 && i >= 0 && i < str.length() && j < str.length()) {
            if (i + 1 < str.length() && dp[i][j] == dp[i + 1][j - 1]) {
                sb.setCharAt(i, ' ');
                sb.setCharAt(j, ' ');
                i++;
                j--;
            } else if (dp[i][j] == dp[i + 1][j]) {
                sb.setCharAt(i, ' ');
                i++;
            } else if (dp[i][j] == dp[i][j - 1]) {
                sb.setCharAt(j, ' ');
                j--;
            } else {
                i++;
                j--;
            }
        }
        int index = 0;
        while(index < sb.length()){
            if(sb.charAt(index) == ' '){
                sb.deleteCharAt(index);
            }else{
                index++;
            }
        }
        return sb.toString();
    }
}
