package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return null;
        List<Integer> ret = new ArrayList<>();
        if(root.left != null) ret.addAll(inorderTraversal(root.left));
        ret.add(root.val);
        if(root.right != null) ret.addAll(inorderTraversal(root.right));
        return ret;
    }
}
