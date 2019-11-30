package leetcode.dynamic;


import java.util.ArrayList;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        List<List<Integer>> ret = subsetsWithDup(new int[]{1,2,2});
        for(List temp : ret){
            System.out.println(temp);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret,nums,0,new ArrayList<>());
        return ret;
    }

    private static void dfs(List<List<Integer>> ret, int[] nums, int index, List<Integer> arr) {
        ret.add(new ArrayList<>(arr));

        for(int i = index;i < nums.length;i++){
            if(i > index && nums[i] == nums[i-1])// 跳过连续重复的 优化去重代码 大幅度提升消耗的时间
                continue;
            arr.add(nums[i]);
            dfs(ret,nums,i+1,arr);
            arr.remove(arr.size()-1);
        }

    }
    // 可以被优化的
    /*private static boolean isContain(List<List<Integer>> ret, List<Integer> arr) {
        for(List<Integer> temp:ret){
            if(temp.size() == arr.size()){
                int i = 0,j = 0;
                while(i < temp.size() && j < arr.size()){
                    if(temp.get(i) == arr.get(j)){
                        i++;
                        j++;
                    }else {
                        break;
                    }
                }
                if(i == j && i == temp.size()) return true;
            }
        }
        return false;
    }*/
}
