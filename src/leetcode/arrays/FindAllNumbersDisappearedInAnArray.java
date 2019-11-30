package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author whl
 * @date 2019/10/23 5:50 下午
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
       System.out.println( findDisappearedNumbers(new int[]{2,1}));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < nums.length;){
            if(nums[i]-1 == i) i++;
            else{
                if(nums[nums[i]-1] == nums[i]) i++;
                else{
                    int temp = nums[nums[i] -1];
                    nums[nums[i] -1] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        for(int i = 0;i < nums.length;i++){
            if(nums[i] != i+1) res.add(i+1);
        }
        return res;
    }
}
