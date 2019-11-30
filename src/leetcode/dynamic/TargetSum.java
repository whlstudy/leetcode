package leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author whl
 * @date 2019/10/15 6:56 下午
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and -
 * as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 */
public class TargetSum {

    public static void main(String[] args) {
        System.out.println(findTargetSumWays1(new int[]{1, 1, 1, 1, 1},3));
    }

    public static int findTargetSumWays(int[] nums, int S) {
        List<List<Character>> list = new ArrayList<>();
        dfs(nums,list,new ArrayList<>(),0,S,0);
        return list.size();
    }

    private static void dfs(int[] nums, List<List<Character>> list, ArrayList<Character> arr, int index, int target,int t) {
        if(arr.size() == nums.length && t == target){
            list.add(new ArrayList<>(arr));
        }
        for(int i = index;i < nums.length;i++){
            arr.add('-');
            dfs(nums,list,arr,i+1,target,t-nums[i]);
            arr.remove(arr.size()-1);

            arr.add('+');
            dfs(nums,list,arr,i+1,target,t+nums[i]);
            arr.remove(arr.size()-1);
        }
    }

    // dfs优化版， 放弃记录具体算法过程
    public static int findTargetSumWays1(int[] nums, int S) {
        return calc(nums,0,S);
    }

    private static int calc(int[] nums, int i, int target) {
        if(i == nums.length) return target == 0 ? 1:0;
        return calc(nums,i+1,target-nums[i]) + calc(nums,i+1,target+nums[i]);
    }
}
