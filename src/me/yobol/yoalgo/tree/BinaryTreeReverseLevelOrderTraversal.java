package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Description:
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *       3
 *     /  \
 *    9   20
 *       /  \
 *      15   7
 * return its bottom-up level order traversal as:
 *
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
 */
public class BinaryTreeReverseLevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> outer = new LinkedList<>();
        if (root == null) return outer;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> inner = new LinkedList<>();
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                TreeNode temp = queue.poll();
                inner.add(temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            outer.add(0, inner);
        }

        return outer;
    }

    public static void main(String[] args) {
        BinaryTreeReverseLevelOrderTraversal btrlot = new BinaryTreeReverseLevelOrderTraversal();

        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.left.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

        TreeUtils.print(btrlot.levelOrderBottom(t1));
    }


}
