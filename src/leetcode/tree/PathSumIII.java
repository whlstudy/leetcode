package leetcode.tree;


import java.util.HashMap;

/**
 * @author whl
 * @date 2019/11/30 11:10 上午
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent
 * nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */
public class PathSumIII {

    private int count = 0;

    // 从每一个节点都往下寻找一次，比较麻烦，重复计算太多次了
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return count;
        dfs(root, 0, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    private void dfs(TreeNode root, int current, int sum) {
        if (root == null) return;
        if (current + root.val == sum) count++;
        dfs(root.left, current + root.val, sum);
        dfs(root.right, current + root.val, sum);
    }

    // 使用HashMap简化操作，只需要遍历每个节点就行，但是增加HashMap操作时间复杂度。
    /**
     * 理解这种写法，需要先了解一题：求数组中子数组和为sum的个数。
     *    解法：使用Map将数组中遍历过的值保存起来，如0～i-1，0～i，那么当遍历的当前值为curSum时，如果Map中存在curSum - sum的话，也就意味着
     *    从数组中某个点出发到当前的和为sum，既k～i的和为sum。
     * 由此引出下面解法，将树中每个路径都看作为一个数组，也就等于求多个数组中子数组和为sum的题。
     * 需要重点关注的是需要配合回溯法控制当前Map中存在记录只是当前路径生成的。
     */
    public int pathSum1(TreeNode root,int sum){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return dfsTraverse(root,sum,map,0);
    }

    private int dfsTraverse(TreeNode root, int sum, HashMap<Integer, Integer> map, int preSum) {
        if(root == null){
            return 0;
        }
        int curSum = preSum + root.val;
        int res = 0;
        res += map.getOrDefault(curSum - sum,0);
        // 将当前和存放
        map.put(curSum,map.getOrDefault(curSum,0) + 1);
        res += dfsTraverse(root.left,sum,map,curSum) + dfsTraverse(root.right,sum,map,curSum);
        // 将当前和删除，保证路径唯一
        map.put(curSum,map.get(curSum) - 1);
        return res;
    }
}
