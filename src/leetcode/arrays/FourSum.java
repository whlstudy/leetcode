package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author whl
 * @date 2019/11/26 6:35 下午
 * <p>
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that
 * a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 */
public class FourSum {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{0,0,0,0,0,0},0));
    }

    // 时间复杂度O(n^3)
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        //if after sort first 4 elements are greater than target, there is not answer;
        if(nums[0] + nums[1] + nums[2] + nums[3] > target) return res;
        for (int i = 0; i < nums.length - 3; i++) {
            //remove duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                //remove duplicates
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = (nums[i] + nums[j] + nums[left] + nums[right]);
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        //remove duplicates
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if(sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
