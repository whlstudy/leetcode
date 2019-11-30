package leetcode.arrays;

/**
 * @author whl
 * @date 2019/10/16 3:46 下午
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                int index = find(i+1,nums);
                if(index == -1) break;
                nums[i] = nums[index];
                nums[index] = 0;
            }
        }
    }

    public int find(int index,int[] nums){
        while(index < nums.length){
            if(nums[index] == 0) index++;
            else{
                return index;
            }
        }
        return -1;
    }

    // 优化版 O(n)
    public void moveZeroes1(int[] nums) {
        int indexZero = 0;
        for(int i = 0;i < nums.length;){
            // 快速滑动
            while(indexZero < nums.length && nums[indexZero] != 0) indexZero++;
            if(i <= indexZero) i = indexZero+1;
            else{
                nums[indexZero] = nums[i];
                nums[i] = 0;
                i++;
            }
        }
    }
}
