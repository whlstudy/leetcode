package leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> ret = combine(4,2);
        for(List<Integer> temp : ret) {
            System.out.print(temp + " ");
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(n,k,ret,1,0,new ArrayList<>());
        return ret;
    }

    private static void dfs(int n, int k, List<List<Integer>> ret, int i,int count,List<Integer> arr) {
        if(count == k){
            ret.add(new ArrayList<>(arr));
            return;
        }
        for(int j = i;j <= n;j++){
            arr.add(j);
            dfs(n,k,ret,j+1,count+1,arr);
            arr.remove(arr.size()-1);
        }
    }
}
