package leetcode.arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * @author whl
 * @date 2019/12/25 3:29 下午
 * <p>
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * 生成杨辉三角
 */
public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new LinkedList<>();
        if (numRows <= 0) return ret;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> cur = new LinkedList<>();
            if (i == 1) {
                cur.add(1);
            } else {
                List<Integer> temp = ret.get(ret.size() - 1);
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) {
                        cur.add(1);
                    } else {
                        cur.add(temp.get(j - 1) + temp.get(j));
                    }
                }
            }
            ret.add(cur);
        }
        return ret;
    }
}
