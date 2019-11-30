package leetcode.string;

import java.util.Stack;

/**
 * @author whl
 * @date 2019/10/31 3:34 下午
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k. For example, there won't be input like 3a or 2[4].
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }

    // 用栈解决问题，速度慢
    public static String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        StringBuilder ssb = new StringBuilder();

        StringBuilder csb = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) != ']') st.push(s.charAt(i));
            else{
                while(st.peek() != '['){
                    ssb.insert(0,st.pop());
                }
                st.pop();
                while(!st.isEmpty() && st.peek() <= '9' && st.peek() >= '0'){
                    csb.insert(0,st.pop());
                }
                int count = Integer.valueOf(csb.toString());
                csb.delete(0,csb.length());
                String temp = ssb.toString();
                while(--count > 0) {
                    ssb.append(temp);
                }
                int j = 0;
                while(j < ssb.length()){
                    st.push(ssb.charAt(j++));
                }
                ssb.delete(0,ssb.length());
            }
        }
        while(!st.isEmpty()){
            ssb.append(st.pop());
        }
        return ssb.reverse().toString();
    }

    // 考虑用dfs
    public static String decodeString1(String s) {
        return "123";
    }
}
