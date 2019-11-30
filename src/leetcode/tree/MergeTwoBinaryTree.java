package leetcode.tree;

/**
 * @author whl
 * @date 2019/10/23 5:42 下午
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are
 * overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up
 * as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * 重合部分节点值相加
 */
public class MergeTwoBinaryTree {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        if(t1 == null || t2 == null) return t1 == null ? t2:t1;

        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left,t2.left);
        node.right = mergeTrees(t1.right,t2.right);
        return node;
    }
}
