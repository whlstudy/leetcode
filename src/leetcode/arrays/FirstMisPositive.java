package leetcode.arrays;

/**
 * @author whl
 * @date 2019/10/22 7:37 下午
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 * 找到丢失的最小正整数，此题可以借助数组来做，在下标为n的位置插入大小为n-1的数，简单就能找到最小的断点，
 * 也就是最小丢失的数。如果数组中有重复的数字则简单修改第二份重复数字为负值即可。
 */
public class FirstMisPositive {
    public static void main(String[] args) {
       System.out.println(firstMissingPositive(new int[]{1,1}));
    }
    public static int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        for(int i = 0;i < nums.length;){
            if(nums[i] <= 0 || nums[i] >= nums.length+1 || i+1 == nums[i]){
                i++;
            }else {
                if(nums[nums[i]-1] == nums[i]) i++;
                else {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        int i = 0;
        for(;i < nums.length;i++){
            if(nums[i] != i+1) return i+1;
        }
        return i+1;
    }
}
