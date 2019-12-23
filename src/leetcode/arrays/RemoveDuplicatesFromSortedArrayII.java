package leetcode.arrays;

/**
 * @author whl
 * @date 2019/12/23 6:17 下午
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared
 * at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input
 * array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        new RemoveDuplicatesFromSortedArrayII().removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 5, 5, 6});
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int cnt = 1, cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) {
                cnt++;
            } else {
                cur = nums[i];
                cnt = 1;
            }
            if (cnt <= 2) count++;
            nums[i - (i + 1 - count)] = nums[i];
        }
        return count;
    }
}
