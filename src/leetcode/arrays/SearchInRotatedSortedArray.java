package leetcode.arrays;
/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */

// 不可重复
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3,1,1,1,1},3));
    }

    /**
     * 因为时间要求O(log n),所以必须用二分查找，由于不是完全排序，所以增加一步判断是左边区间还是右边区间
     */
    public  static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftEnd = nums[0];
        int rightEnd = nums[nums.length - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= leftEnd) {
                if (target >= nums[left] && target < nums[mid]) {
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
        return -1;
    }
}
