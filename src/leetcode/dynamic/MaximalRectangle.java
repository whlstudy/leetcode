package leetcode.dynamic;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author whl
 * @date 2019/11/6 4:04 下午
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * 解题方法来自网络：
 * 将二维数组转化为直方图，然后利用求直方图图中最大长方形面积求解。
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] pre = new int[col];
        int[] cur = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != '0')
                    cur[j] = (matrix[i][j] - '0') + pre[j];
                else
                    cur[j] = 0;
            }
            max = Math.max(max, maximalRectangleInHistogram(cur));
            pre = Arrays.copyOf(cur, cur.length);
        }
        return max;
    }

    private static int maximalRectangleInHistogram(int[] heights) {
        int ret = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int area = heights[st.pop()] * (st.isEmpty() ? i : i - st.peek() - 1);
                ret = Math.max(area, ret);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int area = heights[st.pop()] * (st.isEmpty() ? heights.length : heights.length - st.peek() - 1);
            ret = Math.max(area, ret);
        }
        return ret;
    }
}
