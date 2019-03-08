package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class ReverseTree {

    public void reverse(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        reverse(root.left);
        reverse(root.right);
    }

    public static void main(String[] args) {
        ReverseTree s = new ReverseTree();
        TreeNode t1 = new TreeNode(1); // symmetric
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(3);
        t1.left.left.left = new TreeNode(7);
        t1.left.right = new TreeNode(4);
        t1.left.right.left = new TreeNode(6);
        t1.right = new TreeNode(2);
        t1.right.left = new TreeNode(4);
        t1.right.left.right = new TreeNode(6);
        t1.right.right = new TreeNode(3);
//        t1.right.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();
        TreeUtils.print(traversal.levelOrder(t1));
        s.reverse(t1);
        TreeUtils.print(traversal.levelOrder(t1));

    }
}
