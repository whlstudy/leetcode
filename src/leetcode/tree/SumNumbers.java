package leetcode.tree;

/**
 * 129. Sum Root to Leaf Numbers
 * Given a binary leetcode.tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 */
public class SumNumbers {

    public static int sumNumbers(TreeNode root) {
       if(root == null) return 0;
       Ret ret = new Ret(0);
       preSum(root,new StringBuilder(),ret);
       return ret.value;
    }

    public static void preSum(TreeNode node,StringBuilder sb,Ret ret){
        if(node.left == null && node.right == null){
            sb.append(node.val);
            ret.value += (Integer.valueOf(sb.toString()));
            sb.delete(sb.length()-1,sb.length());
            return;
        }
        sb.append(node.val);
        if(node.left != null) preSum(node.left,sb,ret);
        if(node.right != null) preSum(node.right,sb,ret);
        sb.delete(sb.length()-1,sb.length());
    }
    public static class Ret{
        int value;
        Ret(Integer value){
            this.value = value;
        }
    }
}
