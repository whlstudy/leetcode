package leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author whl
 * @date 2019/11/27 2:43 下午
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can
 * be serialized to a string and this string can be deserialized to the original tree structure.
 */
public class SerializeAndDeserializeBinaryTree {
    /*
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return "[null]";
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int n = 0;
        while (!queue.isEmpty()) {
            int count = 0;
            int cs = queue.size();
            n++;
            while(cs-- > 0) {
                TreeNode temp = queue.poll();
                if (temp.val != Integer.MAX_VALUE)
                    sb.append(temp.val);
                else {
                    sb.append("null");
                }
                sb.append(',');
                if (temp.left != null) queue.add(temp.left);
                else {
                    queue.add(new TreeNode(Integer.MAX_VALUE));
                    count++;
                }
                if (temp.right != null) queue.add(temp.right);
                else {
                    queue.add(new TreeNode(Integer.MAX_VALUE));
                    count++;
                }
            }
            if (count == Math.pow(2, n))
                break;
        }
        sb.setLength(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String str = "-1"+","+data.substring(1, data.length() - 1);
        String[] arr = str.split(",");
        if (arr.length == 1 || arr[1].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(arr[1]));
        TreeNode[] ret = new TreeNode[arr.length+1];
        ret[1] = root;
        for (int i = 1; i < arr.length; i++) {
            if (2 * i < arr.length && !arr[2 * i].equals("null") && ret[i] != null) {
                TreeNode temp = new TreeNode(Integer.valueOf(arr[2 * i]));
                ret[i].left = temp;
                ret[2 * i] = temp;
            }
            if (2 * i + 1 < arr.length && !arr[2 * i + 1].equals("null") && ret[i] != null) {
                TreeNode temp = new TreeNode(Integer.valueOf(arr[2 * i + 1]));
                ret[i].right = temp;
                ret[2 * i + 1] = temp;
            }
        }
        return root;
    } */

    private static final String divider = ",";
    private static final String NN = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();
    }
    private void buildString(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append(NN).append(divider);
        } else {
            sb.append(root.val).append(divider);
            buildString(sb, root.left);
            buildString(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(divider)));
        return buildTree(nodes);
    }
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
        TreeNode root = s.deserialize("[1,2,3,null,null,4,5]");
        System.out.println(s.serialize(root));
    }
}
