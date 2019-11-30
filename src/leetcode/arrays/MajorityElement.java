package leetcode.arrays;

import java.util.Arrays;

/**
 * @author whl
 * @date 2019/10/13 3:26 下午
 * Given an array of size n, find the majority element. The majority element is the element that
 * appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    public int majorityElement0(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement1(int[] nums){
        int count = 1;
        int num = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == num) count++;
            else {
                count--;
                if(count == 0){
                    num = nums[i];
                    count++;
                }
            }
        }
        return num;
    }

}
