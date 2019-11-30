package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author whl
 * @date 2019/11/5 7:38 下午
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p
 * will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    // 时间复杂度O(m*n)
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return ret;
        int lenS = s.length();
        int lenP = p.length();
        int[] arr = new int[256];
        for(int i = 0;i < lenP;i++) {
            arr[p.charAt(i)]++;
        }
        for (int i = 0; i <= lenS - lenP; i++) {
            if(isTrue(s.substring(i,i+lenP),arr)) ret.add(i);
        }
        return ret;
    }

    private static boolean isTrue(String str, int[] arr) {
        int[] tmp = Arrays.copyOf(arr,arr.length);
        for(int i  = 0;i < str.length();i++){
            tmp[str.charAt(i)]--;
            if(tmp[str.charAt(i)] < 0) return false;
        }
        return true;
    }

    // sliding window 时间复杂度O(n)
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ret = new LinkedList<>();
        return ret;
    }
}
