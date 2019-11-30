package leetcode.dynamic;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        List<List<Integer>> ret = subsets(new int[]{1,2,3});
        for(List temp:ret){
            System.out.println(temp);
        }
    }

    public  static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret,new LinkedList<>(),0,nums);
        return ret;
    }

    private static void dfs(List<List<Integer>> ret, LinkedList<Integer> arr, int index,int[] nums) {
        ret.add(new LinkedList<>(arr));
        for(int i = index;i < nums.length;i++){
            arr.addLast(nums[i]);
            dfs(ret,arr,i+1,nums);
            arr.removeLast();
        }
    }
}
