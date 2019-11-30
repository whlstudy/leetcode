package leetcode.dynamic;

import java.util.Stack;

/**
 * @author whl
 * @date 2019/10/24 7:12 下午
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest
 * valid (well-formed) parentheses substring.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "()(()()()()()))";
        System.out.println(longestValidParentheses(s));
        System.out.println(longestValidParentheses1(s));
    }

    /**
     * 解题思路来源于博客，使用一个栈记录'('下标，每次进入一个')'时，栈弹出，ans更新为当前扫描的下标与栈顶元素的距离
     * 因为中间有些括号可能已经被消除掉，因此栈可能为空，所以需要使用last来记录起始下标。
     */
    public static int longestValidParentheses(String s) {
        int ans = 0;
        int last = -1;
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '(') st.push(i);
            else {
                if(st.isEmpty()) last = i; // 如果栈为空，且当前下标为'('，表示起始下标从现在开始，当前点为永不匹配点(孤点)
                else{
                    st.pop();
                    if(!st.isEmpty()) ans = Math.max(ans,i-st.peek());
                    else ans = Math.max(ans,i-last);
                }
            }
        }
        return ans;
    }

    /**
     * 动态规划
     *
     *  dp[i]表示连续的匹配个数
     */
    public static int longestValidParentheses1(String s) {
        int len = s.length();
        if(len < 2) return 0;
        int max = 0;
        int[] dp = new int[len];
        for(int i = len -2 ;i >= 0;i--){
            if(s.charAt(i) == '('){
                int j = i + 1 + dp[i+1]; // 要么最开始，要么最后面，因为要连续,')'下标
                if(j < len && s.charAt(j) == ')'){
                    dp[i]= dp[i+1]+2;
                    if(j+1 < len)
                        dp[i] += dp[j+1]; // 可能出现断续之后又连续上了的情况
                }

                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
