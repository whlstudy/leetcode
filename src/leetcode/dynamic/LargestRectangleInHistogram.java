package leetcode.dynamic;

import java.util.Stack;

/**
 * @author whl
 * @date 2019/11/5 2:59 下午
 * <p>
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea1(new int[]{2, 1, 5, 6, 2, 3}));
    }

    // 用栈
    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int area = heights[st.pop()] * (st.isEmpty() ? i : i - st.peek() - 1);
                max = Math.max(max, area);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int area = heights[st.pop()] * (st.isEmpty() ? heights.length : heights.length - st.peek() - 1);
            max = Math.max(max, area);
        }
        return max;
    }

    // 是用栈时间效率的1/5 思考时间复杂度上来说是一样的，为什么执行效率相差如此大
    public static int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int[] lessFromLeft = new int[heights.length];
        int[] lessFromRight = new int[heights.length];
        int max = 0;
        lessFromLeft[0] = -1;
        lessFromRight[heights.length - 1] = heights.length;
        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return max;
    }
}
