package leetcode.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author whl
 * @date 2019/11/26 4:23 下午
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * 不断更新插入值
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int[][] solution = new int[result.size()][2];
        for(int[] temp : intervals){
            if(newInterval == null || temp[1] < newInterval[0]){
                result.add(temp);
            }else if(temp[0] > newInterval[1]){
                result.add(newInterval);
                newInterval = null;
                result.add(temp);
            }else { // 更新
                newInterval[0] = Math.min(temp[0],newInterval[0]);
                newInterval[1] = Math.max(temp[1],newInterval[1]);
            }
        }
        if(newInterval == null) return result.toArray(solution);
        else {
            result.add(newInterval);
            return result.toArray(solution);
        }
    }
}
