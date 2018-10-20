package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

/**
 * Description:
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 * Input:
 *      1        1
 *     / \      / \
 *    2  3     2  3
 *
 * [1,2,3], [1,2,3]
 *
 * Output: true
 *
 * Example 2:
 * Input:
 *      1        1
 *     /          \
 *    2            2
 *
 * [1,2], [1,null,2]
 *
 * Output: false
 *
 * Example 3:
 * Input:
 *      1        1
 *     / \      / \
 *    2   1    1   2
 *
 * [1,2,1], [1,1,2]
 *
 * Output: false
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree st = new SameTree();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(st.isSameTree(p, q));

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        q = new TreeNode(1);
        q.right = new TreeNode(2);
        System.out.println(st.isSameTree(p, q));

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        q = new TreeNode(1);
        q.left = new TreeNode(3);
        q.right = new TreeNode(2);
        System.out.println(st.isSameTree(p, q));

    }
}
