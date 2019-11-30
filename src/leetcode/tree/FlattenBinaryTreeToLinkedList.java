package leetcode.tree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class FlattenBinaryTreeToLinkedList {
    // 前序遍历顺序
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> preOrder = new LinkedList<>();
        preOrder = preOrder(root);
        TreeNode temp = root;
        for (int i = 1; i < preOrder.size(); i++) {
            temp.left = null;
            temp.right = preOrder.get(i);
            temp = temp.right;
        }
    }

    public List<TreeNode> preOrder(TreeNode node) {
        List<TreeNode> ret = new LinkedList<>();
        if (node == null) return ret;
        if (node.left == null && node.right == null) {
            ret.add(node);
            return ret;
        }
        ret.add(node);
        if (node.left != null) ret.addAll(preOrder(node.left));
        if (node.right != null) ret.addAll(preOrder(node.right));
        return ret;
    }

    /**
     * 这题的重点是追踪
     */
    private TreeNode last;

    public void flatten1(TreeNode root) {
        TreeNode tempL, tempR;
        if (root == null) return;
        else {
            if (last == null) last = root;
            else {
                last.right = root;
                last.left = null;
                last = last.right;
            }
            tempL = root.left;
            tempR = root.right;
            flatten1(tempL);
            flatten1(tempR);
        }
    }
}
