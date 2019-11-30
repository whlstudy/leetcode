package leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * 排列组合中找到第k个序列
 * 第一种解体思路：通过dfs找到第k个序列
 */
public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation2(3, 3));
    }

    /**
     * 第一种穷举思路 能够解决问题，但是测试数据大时发生超时
     */
    public static String getPermutation1(int n, int k) {
        List<StringBuilder> ret = new ArrayList<>();
        int[] nums = new int[n + 1];
        dfs(n, 0, new StringBuilder(), ret, nums);
        return ret.get(k - 1).toString();
    }

    private static void dfs(int n, int count, StringBuilder sb, List<StringBuilder> ret, int[] nums) {
        if (count == n) {
            ret.add(new StringBuilder(sb));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                sb.append(i);
                dfs(n, count + 1, sb, ret, nums);
                sb.delete(sb.length() - 1, sb.length());
                nums[i] = 0;
            }
        }
    }

    /**
     * 第二种找规律 第k个排列的的第一个元素在0-n重的位置是（k-1）/（n-1）！
     */
    public static String getPermutation2(int n, int k) {
        StringBuilder ans = new StringBuilder();
        int num = --k;
        StringBuilder s = new StringBuilder();
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            s.append(i);
        }

        for (int i = n; i >= 1; i--) {
            factorial /= i;
            int index = num / factorial;
            ans.append(s.charAt(index));
            num %= factorial;
            s.deleteCharAt(index);
        }
        return ans.toString();
    }
}
