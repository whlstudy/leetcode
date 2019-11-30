package leetcode.arrays;

import java.util.Stack;

/**
 * @author whl
 * @date 2019/11/28 3:23 下午
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
       Stack<Integer> st = new Stack<>();
       int i = 0, n = height.length, res = 0;
       while(i < n){
           if(st.isEmpty() || height[i] <= height[st.peek()]){
               st.push(i++);
           }else{
               int t = st.pop();
               if(st.isEmpty()) continue;
               res += (Math.min(height[i],height[st.peek()]) - height[t]) * (i - st.peek() - 1);
           }
       }
       return res;
    }
}
