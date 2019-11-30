package leetcode.arrays;

/**
 * @author whl
 * @date 2019/11/10 6:05 下午
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the
 * very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0 || nums.length < k) return new int[0];
        int[] ret = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int resC = 1;
        int end = 0;

        while (end < nums.length) {
            if (end < k) {
                if (nums[end] > max) {
                    max = nums[end];
                    maxIndex = end;
                }
                ret[0] = max;
            } else {
                if(maxIndex < end - k + 1){
                    max = Integer.MIN_VALUE;
                    for(int j = maxIndex + 1;j <= end;j++){
                        if(nums[j] > max){
                            max = nums[j];
                            maxIndex = j;
                        }
                    }
                }else {
                    if(nums[end] > max){
                        max = nums[end];
                        maxIndex = end;
                    }
                }
                ret[resC++] = max;
            }
            end++;
        }
        return ret;
    }
}
