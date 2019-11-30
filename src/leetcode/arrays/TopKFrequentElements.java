package leetcode.arrays;


import java.util.*;

/**
 * @author whl
 * @date 2019/10/24 6:33 下午
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0) return res;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int[][] arr = new int[map.size()][2];
        int i = 0;
        for(Map.Entry entry:map.entrySet()){
            arr[i][0] = (int)entry.getKey();
            arr[i][1] = (int)entry.getValue();
            i++;
        }

        Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);

        for(int j = 0;j < k;j++){
            res.add(arr[j][0]);
        }
        return res;
    }
}
