package leetcode.tree;


/**
 * Given a binary leetcode.tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        midView(root,sb);
        return sb.toString().equals(sb.reverse().toString());
    }

    public void midView(TreeNode node, StringBuilder sb){
        if(node.left != null) midView(node.left,sb);
        sb.append(node.val);
        if(node.right != null) midView(node.right,sb);
    }
}
