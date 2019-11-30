package leetcode.arrays;

import java.util.Arrays;

/**
 * @author whl
 * @date 2019/10/14 3:04 下午
 *
 * 查找数组中第k个大小的数字
 *
 * 第一种方法排序后直接返回
 *
 * 第二种方法用到了快速排序每次能固定一个位置的思想
 */
public class KthLargestElementInArray {

    public static void main(String[] args) {
        System.out.println(findKthLargest1(new int[]{3,2,3,1,2,4,5,5,6},5));
        System.out.println(findKthLargest0(new int[]{3,2,3,1,2,4,5,5,6},5));
    }

    // 时间复杂度O(nlogn)
    public static int findKthLargest0(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }


    // 时间复杂度O(n)
    public static int findKthLargest1(int[] nums, int k){
        return quickSelect(nums,nums.length-k,0,nums.length-1);
    }

    public static int quickSelect(int[] nums,int k,int left,int right){
        if(left == right) return nums[left];
        int index = partition(nums,left,right);
        if(index == k) return nums[index];
        if(index < k){
            return quickSelect(nums,k,index + 1,right);
        }else {
            return quickSelect(nums,k,left,index-1);
        }
    }

    private static int partition(int[] nums,int left, int right) {
        int n = nums[left];
        while(left < right){
            while(left < right && nums[right] >= n) right--;
            nums[left] = nums[right];
            while(left < right && nums[left] <= n) left++;
            nums[right] = nums[left];
        }
        nums[left] = n;
        return left;
    }
}
