package leetcode.arrays;


/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] ret = dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
    }

    /**
     * 测试用例耗时较久
     */
    public static int[] dailyTemperatures1(int[] T) {
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int j = 1;
            while (i + j < T.length && T[i] >= T[i + j]) {
                j++;
            }
            if (i + j != T.length)
                ans[i] = j;
        }
        return ans;
    }

    /**
     * 用栈 TODO
     */
    public static int[] dailyTemperatures2(int[] T) {
        if (T.length == 0) return new int[]{0};
        int[] stack = new int[T.length];
        int[] order = new int[T.length];
        int top = 0;
        stack[top] = 0;
        for (int i = 1; i < T.length; i++) {
            if (T[i] >= T[stack[top]]) {
                while (T[i] > T[stack[top]]) {
                    order[stack[top]] = i - stack[top];
                    top--;
                    if (top == -1)
                        break;
                }
                stack[++top] = i;
            }else {
                stack[++top] = i;
            }
        }
        return order;
    }
}
