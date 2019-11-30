package leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author whl
 * @date 2019/11/15 6:27 下午
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        return setResolve(nums);
    }

    public int setResolve(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) set.add(i);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = nums[i], high = nums[i];
            while (set.contains(--low)) set.remove(low);
            while(set.contains(++high)) set.remove(high);
            max = Math.max(max,high - low - 1);
        }
        return max;
    }

    public int sortResolve(int[] nums){
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1;
        int start = 0;
        int end = 1;
        for(int i = 1;i < nums.length;i++){
            if(nums[i-1] + 1 == nums[i]) end++;
            else {
                start = i;
                end = i + 1;
            }
            max = Math.max(max,end - start);
        }
        return max;
    }
}
