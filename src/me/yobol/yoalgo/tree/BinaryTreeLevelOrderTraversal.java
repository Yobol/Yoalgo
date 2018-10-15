package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level)
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *       3
 *     /  \
 *    9   20
 *       /  \
 *      15   7
 * level i contains 2 ^ (i - 1) nodes
 * return its level order traversal as:
 *
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outer = new LinkedList<>();
        if (root == null) return outer;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> inner = new LinkedList<>();
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
            outer.add(inner);
        }
        return outer;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal btlot = new BinaryTreeLevelOrderTraversal();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.left.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

        List<List<Integer>> outer = btlot.levelOrder(t1);
        System.out.println("[");
        for (List<Integer> inner : outer) {
            System.out.print("[");
            for (Integer i : inner) {
                System.out.print(i + ",");
            }
            System.out.println("],");
        }
        System.out.println("]");
    }


}
