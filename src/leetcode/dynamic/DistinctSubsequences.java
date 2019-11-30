package leetcode.dynamic;

/**
 * @author whl
 * @date 2019/10/22 6:37 下午
 *
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 *
 * 找s含有多少子序列是等于t的
 */
public class DistinctSubsequences {

    public static void main(String[] args) {
        System.out.println(numDistinct1("babgbag","bag"));
    }

    /**
     * 首先想到暴力解法，使用深搜找出所有可能。
     *
     * 可以解题，但是超时，时间复杂度太高了。
     */
    public static int numDistinct(String s, String t) {
        int[] res = new int[1];
        dfs(s,t,0,0,res);
        return res[0];
    }

    private static void dfs(String s, String t, int indexS, int indexT, int[] res) {
        if(indexT == t.length()) {
            res[0]++;
            return;
        }
        if(s.length() - indexS < t.length() - indexT) return;

        for(int i = indexS;i < s.length();i++){
            if(s.charAt(i) == t.charAt(indexT))
                dfs(s,t,i+1,indexT+1,res);
        }
    }

    public static int numDistinct1(String s,String t){
        int m = s.length();
        int n = t.length();
        int[] f = new int[n+1];
        f[0] = 1;
        for(int i = 1;i <= m;i++){
            for(int j = n;j >= 1;j--){
                if(s.charAt(i-1) == t.charAt(j-1))
                    f[j] += f[j-1];
            }
        }
        return f[n];
    }
}
