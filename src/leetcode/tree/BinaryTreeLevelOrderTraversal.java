package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) {
            return ret;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            while(!q1.isEmpty()) {
                if (q1.peek() != null) {
                    TreeNode temp = q1.poll();
                    arr.add(temp.val);
                    if (temp.left != null) q2.add(temp.left);
                    if (temp.right != null) q2.add(temp.right);
                }
            }
            ret.add(arr);
            q1.addAll(q2);
            q2.clear();
        }
        return ret;
     }

    // 简化一个队列，使用一个计数记录当前层的节点数量
    // 该做法减少了程序执行时间
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) {
            return ret;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> arr = new LinkedList<>();
            for(int i = 1;i <= size;i++){
                TreeNode temp = q.poll();
                arr.add(temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            ret.add(arr);
        }
        return ret;
    }
}
