package leetcode.string;

import java.util.*;

/**
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 *
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 *
 * Return a list of the words in words that match the given pattern.
 *
 * You may return the answer in any order.
 */
public class FindAndReplacePattern {

    public static void main(String[] args) {
        String[] arr = new String[]{
                "abc","deq","mee","aqq","dkd","ccc"        };
        findAndReplacePattern(arr, "abb");
    }

    /**
     * 首先长度要一致
     * 其次重复的字符书相同
     */
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<>();
        for (String str : words) {
            if (str.length() == pattern.length() && isPattern(str,pattern)) {
                ret.add(str);
            }
        }
        return ret;
    }

    private static boolean isPattern(String str, String pattern) {
        Map<Character,Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length();i++){
            char temp1 = str.charAt(i);
            char temp2 = pattern.charAt(i);
            if(map.get(temp2) == null && !map.containsValue(temp1)){
                map.put(temp2,temp1);
                sb.append(temp1);
            }else {
                sb.append(map.get(temp2) != null ? map.get(temp2):"");
            }

        }
        return sb.toString().equals(str);
    }
}
