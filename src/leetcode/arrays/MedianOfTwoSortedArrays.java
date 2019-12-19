package leetcode.arrays;

/**
 * @author whl
 * @date 2019/12/14 4:13 下午
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * 虽然leetcode定义这道题为hard题，但是这道题做起来一点也不难。
 *
 * 解法一：使用额外的O(n+m)的空间对二个数组重新排序，之后返回中位数。解法简单不做详细叙述
 * 解法二：使用一个变量记录当前排序位置的前一个位置，中位数则在这二个数中产生。空间复杂度为O(1)
 */
public class MedianOfTwoSortedArrays {

    // space O(1) time O(m+n) 解法二
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0)
            return len2 % 2 == 0 ? (double) (nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2 : nums2[len2 / 2 - 1];
        if (len2 == 0)
            return len1 % 2 == 0 ? (double) (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2 : nums1[len1 / 2 - 1];
        int mid = (len1 + len2) / 2;
        int i = 0, j = 0;
        int pre = 0, cur = 0;
        while (i + j - 1 != mid) {
            if (i == len1 ){
                pre = cur;
                cur = nums2[j];
                j++;
            } else if(j == len2){
                pre = cur;
                cur = nums1[i];
                i++;
            } else if(nums1[i] <= nums2[j]) {
                pre = cur;
                cur = nums1[i];
                i++;
            } else {
                pre = cur;
                cur = nums2[j];
                j++;
            }
        }

        return (len1 + len2) % 2 == 0 ? (double) (pre + cur) / 2 : pre;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3};
        int[] arr2 = new int[]{1};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
