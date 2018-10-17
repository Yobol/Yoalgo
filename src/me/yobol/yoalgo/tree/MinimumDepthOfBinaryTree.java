package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

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


    public static void main(String[] args) {
        MinimumDepthOfBinaryTree mdobt = new MinimumDepthOfBinaryTree();

        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

        System.out.println(mdobt.minDepth(t1));
    }
}
