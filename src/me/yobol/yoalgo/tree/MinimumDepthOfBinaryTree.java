package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *       3
 *      / \
 *     9  20
 *      /   \
 *     15   7
 * return its minimum depth = 2.
 */
public class MinimumDepthOfBinaryTree {

    private int minDepthHelper(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepthHelper(root.right);
        if (root.right == null) return 1 + minDepthHelper(root.left);
        return Math.min(minDepthHelper(root.left), minDepthHelper(root.right)) + 1;
    }

    public int minDepth(TreeNode root) {
        return minDepthHelper(root);
    }

    /**
     * do level order reversal,
     * maintain  the height of each node,
     * and return the height when we get the first leaf node
     */
    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) return level;
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            level++;
        }

        return level;
    }


    public static void main(String[] args) {
        MinimumDepthOfBinaryTree mdobt = new MinimumDepthOfBinaryTree();

        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

        System.out.println(mdobt.minDepthBFS(t1));
    }
}
