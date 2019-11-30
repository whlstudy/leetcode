package leetcode.arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {3,5},{0,0},{4,4},{0,2},{5,6},{4,5},{3,5},{1,3},{4,6},{4,6},{3,4}
        };
        int[][] ret = merge(intervals);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i][0] + " " + ret[i][1]);
        }
    }

    /**
     * 没有Accept，测试用例超时
     * 首先通过快速排序将二维数组排序，之后在进行合并，能做出来，但是数据量大时超时。
     */
    public static int[][] merge(int[][] intervals) {
        quickSort(intervals,0,intervals.length-1);
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] != Integer.MAX_VALUE && intervals[i][1] != Integer.MAX_VALUE) {
                for (int j = 0; j < intervals.length; j++) {
                    if (i != j && intervals[j][0] != Integer.MAX_VALUE && intervals[j][1] != Integer.MAX_VALUE) {
                        if (    (intervals[i][0] <= intervals[j][1] && intervals[i][0] >= intervals[j][0]) ||
                                (intervals[i][1] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) ||
                                (intervals[j][0] <= intervals[i][1] && intervals[j][0] >= intervals[i][0]) ||
                                (intervals[j][1] <= intervals[i][1] && intervals[j][1] >= intervals[i][0])   ) {
                            intervals[i][0] = Math.min(intervals[i][0], intervals[j][0]);
                            intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                            count++;
                            intervals[j][0] = Integer.MAX_VALUE;
                            intervals[j][1] = Integer.MAX_VALUE;
                        }
                    }
                }
            }
        }

        int[][] ret = new int[intervals.length - count][2];
        int j = 0;
        for(int i = 0;i < intervals.length;i++){
            if(intervals[i][0] != Integer.MAX_VALUE && intervals[i][1] != Integer.MAX_VALUE){
                ret[j][0] = intervals[i][0];
                ret[j][1] = intervals[i][1];
                j++;
            }
        }
        return ret;
    }

    public static void quickSort(int[][] intervals,int low,int high){
        if(low < high){
            int index = getIndex(intervals,low,high);
            quickSort(intervals,0,index-1);
            quickSort(intervals,index+1,high);
        }
    }

    private static int getIndex(int[][] intervals, int low, int high) {
        int tmp0 = intervals[low][0];
        int tmp1 = intervals[low][1];
        while(low < high){
            while(low < high && intervals[high][0] >= tmp0){
                high--;
            }
            intervals[low][0] = intervals[high][0];
            intervals[low][1] = intervals[high][1];

            while(low <high && intervals[low][0] <= tmp0){
                low++;
            }
            intervals[high][0] = intervals[low][0];
            intervals[high][1] = intervals[low][1];
        }
        intervals[low][0] = tmp0;
        intervals[low][1] = tmp1;
        return low;
    }


}