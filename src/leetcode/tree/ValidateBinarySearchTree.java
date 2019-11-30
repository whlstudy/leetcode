package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class ValidateBinarySearchTree {

    // if a tree is BST, than inorder must be incremental arrays.
    public static boolean isValidBST(TreeNode root) {
        List<Integer> inorder = inorderVisitor(root);
        return isIncrement(inorder);
    }
    private static boolean isIncrement(List<Integer> inorder){
        for(int i = 1;i < inorder.size();i++){
            if(inorder.get(i-1) >= inorder.get(i))
                return false;
        }
        return true;
    }

    private static List<Integer> inorderVisitor(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if(root == null) return ret;
        ret.addAll(inorderVisitor(root.left));
        ret.add(root.val);
        ret.addAll(inorderVisitor(root.right));
        return ret;
    }

    // improvement inorder visitor
    // 想法来源于既然中序遍历是有序的，那么可不可以在递归遍历的过程中直接做一次比较，节约时间。
    // 用一个值记录当前访问节点的上一个访问节点，用来与当前值做比较。
    public static boolean isValidBST1(TreeNode root) {
        return inorderVisitor(root,new long[]{ Long.MIN_VALUE});
    }

    /**
     * @param last 之所以用这个参数，是应为递归下层修改的值必须被递归上层所感知，
     *             用long类型也是一个小技巧，如过int的话边界值(Integer.MIN_VALUE)过不了测试用例。
     */
    private static boolean inorderVisitor(TreeNode root, long[] last){
        if(root == null) return true;
        boolean res = true;
        res &= inorderVisitor(root.left,last);
        if(root.val <= last[0]) return false;
        last[0] = root.val;
        res &= inorderVisitor(root.right,last);
        return res;
    }
}
