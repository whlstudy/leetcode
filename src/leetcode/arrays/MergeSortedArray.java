package leetcode.arrays;

/**
 * @author whl
 * @date 2019/12/25 3:15 下午
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < m + n) return;
        int index = m + n - 1;
        int i = m - 1, j = n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[index--] = nums1[i--];
            }else{
                nums1[index--] = nums2[j--];
            }
        }
        if(i >= 0) while(i >= 0) nums1[index--] = nums1[i--];
        if(j >= 0) while(j >= 0) nums1[index--] = nums2[j--];
    }
}
