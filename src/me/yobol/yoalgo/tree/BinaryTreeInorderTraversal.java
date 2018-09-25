package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * Input: [1,null,2,3]
 *      1
 *      \
 *      2
 *     /
 *    3
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversalByRecursion(TreeNode root) {
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

    public List<Integer> inorderTraversalByStack(TreeNode root) {
        List<Integer> resultant = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            resultant.add(current.val);
            current = current.right;
        }
        return resultant;
    }

    /**
     * Step 1: Initialize current as root
     * Step 2: While current is not NULL,
     * If current does not have left child
     *  a. Add current’s value
     *  b. Go to the right, i.e., current = current.right
     * Else
     *  a. In current's left subtree, make current the right child of the rightmost node
     *  b. Go to this left child, i.e., current = current.left
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalByMorris(TreeNode root) {
        List<Integer> resultant = new ArrayList<>();
        TreeNode current = root;
        TreeNode pre = null;
        while (current != null) {
            if (current.left == null) { // have no left child sub-tree
                resultant.add(current.val);
                current = current.right; // move to next right node
            } else { // have left child sub-tree
                pre = current.left;
                while (pre.right != null) { // find the most rightest node of current.left(the left of current)
                    pre = pre.right;
                }
                pre.right = current; // make current to be the child of its rightest node of current.left(the child of current)
                TreeNode temp = current;
                current = current.left;
                temp.left = null;
            }

        }
        return resultant;
    }


    public static void main(String[] args) {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> resultant = btit.inorderTraversalByStack(root);
        for (Integer i : resultant) {
            System.out.print(i + " ");
        }
    }
}
