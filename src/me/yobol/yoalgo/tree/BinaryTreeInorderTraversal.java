package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultant = new ArrayList<>();
        inorderTraversalHelper(root, resultant);
        return resultant;
    }

    private void inorderTraversalHelper(TreeNode root, List<Integer> resultant) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversalHelper(root.left, resultant);
            }
            resultant.add(root.val);
            if (root.right != null) {
                inorderTraversalHelper(root.right, resultant);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> resultant = btit.inorderTraversal(root);
        for (Integer i : resultant) {
            System.out.print(i + " ");
        }
    }
}
