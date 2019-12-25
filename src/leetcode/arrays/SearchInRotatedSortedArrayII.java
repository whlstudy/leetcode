package leetcode.arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 1}, 1));
    }

    // 数组元素可以重复
    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) return true;

            // 去除左右中都相等的情况
            while (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
                if (left > right || left >= nums.length || right < 0) return false;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }
        }
        return false;
    }
}
