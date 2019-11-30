package leetcode.tree;

/**
 * @author whl
 * @date 2019/10/15 4:13 下午
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 * between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 */
public class LowestCommonAncestorOfBinaryTree {

    // 5% 5% 性能极其差
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        boolean flagL = isSingle(root.left,p,q);
        boolean flagR = isSingle(root.right,p,q);
        if( flagL&& flagR) return root;
        if(flagL){
            return lowestCommonAncestor(root.left,p,q);
        }else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }

    public boolean isSingle(TreeNode root,TreeNode p,TreeNode q){
        if(root == null) return false;
        if(root == p || root == q) return true;
        return isSingle(root.left,p,q) || isSingle(root.right,p,q);
    }

    // 71% 5%
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor1(root.left,p,q);
        TreeNode right = lowestCommonAncestor1(root.right,p,q);
        if(left != null && right != null) return root;
        return left == null ? right:left;
    }

}
