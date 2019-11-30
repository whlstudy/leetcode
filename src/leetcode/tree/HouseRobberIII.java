package leetcode.tree;

/**
 * @author whl
 * @date 2019/10/22 3:48 下午
 *
 * 337. House Robber III
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the
 * "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that
 * "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses
 * were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 *
 * 主要考虑如何实现间隔一层计算最大值
 */
public class HouseRobberIII {

    // 执行效率不高
    public int rob(TreeNode root) {
        if(root == null) return 0;
        else if(root.left == null && root.right == null) return root.val;
        else{
            int y = root.val;;
            int x = 0;
            if(root.left != null){
                x += rob(root.left);
                if(root.left.left != null){
                    y += rob(root.left.left);
                }

                if(root.left.right != null){
                    y += rob(root.left.right);
                }
            }

            if(root.right != null){
                x += rob(root.right);
                if(root.right.left != null){
                    y += rob(root.right.left);
                }

                if(root.right.right != null){
                    y += rob(root.right.right);
                }
            }
            return Math.max(x,y);
        }
    }

    public int rob1(TreeNode root){
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    private int[] dfs(TreeNode root) {
        // res[0] 当前层的最大值
        // res[1] 孩子层的最大值
        if(root == null) return new int[2];
        if(root.left == null & root.right == null) return new int[]{root.val,0};
        int[] leftRes = dfs(root.left);
        int[] rightRes = dfs(root.right);
        int[] res = new int[2];
        res[0] = leftRes[1] + rightRes[1] + root.val;
        res[1] = Math.max(leftRes[1],leftRes[0]) + Math.max(rightRes[1],rightRes[0]);
        return res;
    }

}
