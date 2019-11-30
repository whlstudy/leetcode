package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author whl
 * @date 2019/11/4 4:51 下午
 * <p>
 * Given an array of integers and an integer k, you need to find
 * the total number of continuous subarrays whose sum equals to k.
 * <p>
 * 注意是子数组，需要下标连续。
 */
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum1(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0));
    }

    //dfs时间复杂度太高
    public static int subarraySum(int[] nums, int k) {
        int[] ret = new int[1];
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, k, i, ret, 0);
        }
        return ret[0];
    }

    private static void dfs(int[] nums, int k, int index, int[] ret, int flag) {
        if (flag != 0 && k == 0) {
            ret[0]++;
        }
        if (index >= nums.length) return;
        dfs(nums, k - nums[index], index + 1, ret, flag + 1);
    }

    public static int subarraySum1(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i : nums) {
            sum += i;
            result += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum - k, 0) + 1);
        }
        return result;
    }
}
