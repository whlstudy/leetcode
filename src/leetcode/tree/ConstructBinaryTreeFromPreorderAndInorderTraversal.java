package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,inorder,0,preorder.length-1,0);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preL, int preR, int inL) {
        if(preL > preR) return null;
        TreeNode node  = new TreeNode(preorder[preL]);
        int sizeL = map.get(preorder[preL]) - inL;
        node.left = buildTree(preorder,inorder,preL+1,preL+sizeL,inL);
        node.right = buildTree(preorder,inorder,preL+sizeL+1,preR,inL+sizeL+1);
        return node;
    }
}
