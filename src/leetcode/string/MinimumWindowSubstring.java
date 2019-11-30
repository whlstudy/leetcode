package leetcode.string;

import java.util.HashMap;

/**
 * @author whl
 * @date 2019/10/31 2:25 下午
 *
 *  hard
 * Given a string S and a string T, find the minimum window in S which will contain
 * all the characters in T in complexity O(n).
 *
 *
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow1("ADOBECODEBANC","ABC"));
    }

    // sliding window, 先扩张在收缩
    public static String minWindow(String s, String t) {
        String res = "";
        HashMap<Character,Integer> map = new HashMap<>(t.length());
        for(int i = 0;i < t.length();i++){
            if(map.get(t.charAt(i)) != null){
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }else{
                map.put(t.charAt(i),1);
            }
        }
        int left = 0,cnt = 0,minLen = Integer.MAX_VALUE;

        for(int i = 0;i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) - 1);
                if(map.get(s.charAt(i)) >= 0)
                    cnt++;
            }
            while(cnt == t.length()){
                if(minLen > i - left +1){
                    minLen = i - left + 1;
                    res = s.substring(left,left + minLen);
                }
                if(map.containsKey(s.charAt(left)) ){
                    map.put(s.charAt(left),map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left)) > 0)
                        cnt--;
                }
                left++;
            }
        }
        return res;
    }

    // 优化版，通过一个数组优化HashMap，降低时间消耗的成本
    public static String minWindow1(String s, String t) {
        int[] arr = new int[128];
        for(int i = 0;i < t.length();i++){
            arr[t.charAt(i)]++;
        }
        int left = 0,cnt = 0,minLeft = -1,minLen = Integer.MAX_VALUE;
        for(int i = 0;i < s.length();i++){
            if(--arr[s.charAt(i)] >= 0) cnt++;
            while(cnt == t.length()){
               if(minLen > i - left +1) {
                   minLen = i - left + 1;
                   minLeft = left;
               }
               if(++arr[s.charAt(left)] > 0) cnt--;
               left++;
            }
        }
        return minLeft == -1 ? "":s.substring(minLeft,minLeft + minLen);
    }
}
