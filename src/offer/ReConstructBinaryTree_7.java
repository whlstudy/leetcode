package offer;


import java.util.HashMap;

public class ReConstructBinaryTree_7 {

    private HashMap<Integer,Integer> indexForInorder = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for(int i =0;i < in.length;i++){
            indexForInorder.put(in[i],i);
        }
        return reConstructBinaryTree(pre,0,pre.length-1,0);
    }

    public TreeNode reConstructBinaryTree(int [] pre,int preL,int preR,int inL) {
        if(preL > preR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInorder.get(pre[preL]);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre,preL+1,preL+leftTreeSize,inL);
        root.right = reConstructBinaryTree(pre,preL+leftTreeSize+1,preR,inL+leftTreeSize+1);
        return root;
    }
}
