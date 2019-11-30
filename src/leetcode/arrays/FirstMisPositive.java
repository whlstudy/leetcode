package leetcode.arrays;

/**
 * @author whl
 * @date 2019/10/22 7:37 下午
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
