package leetcode.arrays;

public class SearchRange {
    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{1}, 1));
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (index != -1) {
            if (nums.length == 1) {
                start = index;
                end = index;
            } else {
                start = index;
                end = index;
                while (start >= 0 && nums[start] == target) start--;
                while (end < nums.length && nums[end] == target) end++;
                start++;
                end--;
            }
        }
        return new int[]{start, end};
    }
}
