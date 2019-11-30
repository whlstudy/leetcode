package leetcode.arrays;

/**
 * @author whl
 * @date 2019/10/16 3:33 下午
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.
 */
public class FindTheDuplicateNumber {
    // time:O(n) space:O(1)
    public int findDuplicate(int[] nums) {
        for(int i = 0;i < nums.length;){
            if(nums[i] == i+1) i++;
            else{
                if(nums[nums[i]-1] == nums[i]) return nums[i];
                else{
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return -1;
    }
}
