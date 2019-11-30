package leetcode.arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3,1,1,1},3));
    }

    // 数组元素可以重复
    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        int leftEnd = nums[0];
        int rightEnd = nums[nums.length - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] >= leftEnd) {
                if (target <= nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= rightEnd && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
