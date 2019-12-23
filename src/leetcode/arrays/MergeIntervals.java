package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {3, 5}, {0, 0}, {4, 4}, {0, 2}, {5, 6}, {4, 5}, {3, 5}, {1, 3}, {4, 6}, {4, 6}, {3, 4}
        };
        int[][] ret = merge(intervals);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i][0] + " " + ret[i][1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return intervals;
        Arrays.sort(intervals,(int[] i1,int[] i2) -> {
            if(i1[0] == i2[0]) return i1[1] - i2[1];
            return i1[0] - i2[0];
        });

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i = 1;i < intervals.length;i++){
            int[] prev = list.get(list.size()-1);
            if(prev[1] < intervals[i][0]){
                list.add(intervals[i]);
            }else{
                prev[0] = Math.min(prev[0],intervals[i][0]);
                prev[1] = Math.max(prev[1],intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}