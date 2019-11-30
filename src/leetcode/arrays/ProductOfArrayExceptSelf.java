package leetcode.arrays;

/**
 * @author whl
 * @date 2019/10/16 2:50 下午
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 *
 * Note: Please solve it without division and in O(n).
 * 解法：用二个数组记录左右值  time：O(n) space:O(n)
 */
public class ProductOfArrayExceptSelf {

    // 100% 100%
    public int[] productExceptSelf(int[] nums) {
        if(nums == null && nums.length == 0) return null;
        int[] output = new int[nums.length];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int curr = nums[0];
        left[0] = curr;
        for(int i = 1;i < nums.length;i++){
            curr *= nums[i];
            left[i] = curr;
        }

        curr = nums[nums.length-1];
        right[nums.length-1] = curr;
        for(int i = nums.length-2;i>=0;i--){
            curr *= nums[i];
            right[i] = curr;
        }

        for(int i = 0;i < nums.length;i++){
            if(i == 0 && i+1 < nums.length) output[i] = right[i+1];
            if(i == nums.length-1 && i-1 >=0) output[i] = left[i-1];
            if(i-1 >= 0 && i+1 < nums.length) output[i] = left[i-1] * right[i+1];
        }
        return output;
    }


    public int[] productExceptSelf1(int[] nums) {
        int[] output = new int[nums.length];
        int left = 1;
        int index = 0;
        while(index < nums.length){
            output[index] = left;
            left *= nums[index];
            index++;
        }

        int right = 1;
        index = nums.length-1;
        while(index >= 0){
            output[index] *= right;
            right *= nums[index];
            index--;
        }
        return output;
    }
}
