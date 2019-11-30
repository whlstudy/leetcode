package leetcode.tree;

import java.util.Stack;

/**
 * @author whl
 * @date 2019/10/14 3:58 下午
 *
 * Invert a binary tree.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        TreeNode temp0,temp1;
        while(!st.isEmpty()){
            temp0 = st.pop();
            temp1 = temp0.left;
            temp0.left = temp0.right;
            temp0.right = temp1;
            if(temp0.left != null) st.add(temp0.left);
            if(temp0.right != null) st.add(temp0.right);
        }
        return root;
    }
}
