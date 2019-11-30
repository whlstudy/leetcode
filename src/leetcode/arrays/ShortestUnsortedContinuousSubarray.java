package leetcode.arrays;

import java.util.Arrays;

/**
 * @author whl
 * @date 2019/10/24 3:47 下午
 * <p>
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending
 * order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * 找到一个连续未排序的子数组，经过排序后整个数组排序
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray1(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }

    // 使用了排序 时间复杂度O(nlogn)  可以继续优化
    public static int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < nums.length) {
            if (nums[i] != arr[i]) break;
            i++;
        }
        while (j >= i) {
            if (nums[j] != arr[j]) break;
            j--;
        }
        return j - i > 0 ? j - i + 1 : 0;
    }

    // 时间复杂度O(n)
    // 找到递增边界
    public static int findUnsortedSubarray1(int[] nums) {

        // max current traversal largest number
        // min current traversal least number
        int len = nums.length;
        int i = 0;
        int start = -1, end = -1;
        int max = nums[0];
        int min = nums[len - 1];
        while (i < len) {
            if (nums[i] < max) {
                end = i;
            }
            max = Math.max(max, nums[i]);
            i++;
        }
        i = len - 1;
        while(i >= 0){
            if(nums[i] > min){
                start = i;
            }
            min = Math.min(min,nums[i]);
            i--;
        }
        if(start == -1) start = 0;
        return end - start + 1;
    }
}
