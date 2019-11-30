package leetcode.arrays;

import java.util.*;

/**
 * @author whl
 * @date 2019/10/23 2:29 下午
 */
public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        };

        reconstructQueue(arr);
    }

    // TODO 没有好想法
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        return people;
    }
}
