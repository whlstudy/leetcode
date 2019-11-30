package leetcode.tree;

public class RangSumBST {

    public static void main(String[] args) {

    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        return sum(root,L,R);
    }
    private static int sum(TreeNode root,int L,int R) {
        if (root.left == null && root.right == null) {
            if(root.val <= R && root.val >= L)
                return root.val;
            else return 0;
        }
        int count = 0;
        if(root.left != null)
            count += sum(root.left,L,R);
        if(root.val <= R && root.val >= L)
            count += root.val;
        if(root.right != null)
            count += sum(root.right,L,R);
        return count;
    }
}
