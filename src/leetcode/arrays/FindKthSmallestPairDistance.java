package leetcode.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author whl
 * @date 2019/12/19 2:01 下午
 *
 * Given an integer array, return the k-th smallest distance among all the pairs. The
 * distance of a pair (A, B) is defined as the absolute difference between A and B.
 * 解法一：时间复杂度O(n^2),超时
 *      计算出没对的差值，然后排序输出k-th个值。
 * 解法二：利用二分查找法，是二分查找的一个应用，判断条件是一个函数。
 */
public class FindKthSmallestPairDistance {

    // 能做出来，但是超时，时间复杂度过大。
    public int smallestDistancePair0(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = Math.abs(nums[i] - nums[j]);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        for (Map.Entry temp : map.entrySet()) {
            k -= (Integer) temp.getValue();
            if (k <= 0) return (Integer) temp.getKey();
        }
        return 0;
    }

    // cnt记录小于等于mid的个数
    public static int smallestDistancePair1(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int n = nums.length;
        int high = nums[n - 1] - nums[0];
        while (low < high) {
            int cnt = 0;
            int mid = (high + low) / 2;
            int left = 0;
            for (int right = 0; right < n; right++) {
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                cnt += right - left;
            }
            if (cnt >= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(smallestDistancePair1(new int[]{1, 2, 3, 4, 1, 7, 10}, 3));
    }
}
