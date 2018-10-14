package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

import java.util.*;

/**
 * Description:
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * Examples:
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *       1
 *     /  \
 *    2    2
 *   / \  / \
 *  3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *       1
 *     /  \
 *    2    2
 *     \    \
 *     3    3
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {

    private boolean isMirror(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        return (A.val == B.val)
                && isMirror(A.left, B.right)
                && isMirror(A.right, B.left);
    }

    public boolean isSymmetricByRecursion(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isSymmetricByIteration(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        // Initially,the queue contains root and root.
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode A = queue.poll();
            TreeNode B = queue.poll();
            if (A == null && B == null) continue;
            if (A == null || B == null) return false;
            if (A.val != B.val) return false;
            queue.add(A.left);
            queue.add(B.right);
            queue.add(A.right);
            queue.add(B.left);
        }
        return true;
    }

    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
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
        t1.right.right.right = new TreeNode(7);

        TreeNode t2 = new TreeNode(1); // not symmetric
        t2.left = new TreeNode(2);
        t2.left.right = new TreeNode(3);
        t2.right = new TreeNode(2);
        t2.right.right = new TreeNode(3);

        System.out.println(st.isSymmetricByRecursion(t1)); //true
        System.out.println(st.isSymmetricByRecursion(t2)); //false
        System.out.println(st.isSymmetricByIteration(t1)); //true
        System.out.println(st.isSymmetricByIteration(t2)); //false
    }
}
