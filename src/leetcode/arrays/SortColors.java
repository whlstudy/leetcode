package leetcode.arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
    public static void main(String[] args) {
        sortColors(new int[]{0});
    }
    public static void sortColors(int[] nums) {
        int start = 0,end = nums.length-1;
        for(int i = 0;i <= end;){
            while(start < nums.length && nums[start] == 0) start++;
            while(end >= 0 && nums[end] == 2) end--;
            if(i < start) {
                i = start;
            }else if(nums[i] == 0){
                int tmp = nums[start];
                nums[start++] = nums[i];
                nums[i] = tmp;
            }else if(end >= 0 &&  nums[i] == 2){
                int tmp = nums[end];
                nums[end--] = nums[i];
                nums[i] = tmp;
            }else{
                i++;
            }
        }
    }
}
