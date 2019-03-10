package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

import java.util.ArrayList;

/**
 * 输入一棵二叉树的根结点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class PathSum2 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        if (root == null) return outer;
        findPathHelper(outer, new ArrayList<>(), root, target);
        return outer;
    }

    private void findPathHelper(ArrayList<ArrayList<Integer>> outer, ArrayList<Integer> inner, TreeNode root, int difference) {
        if (root == null) return;
        difference -= root.val;
        inner.add(root.val);

        if (difference == 0 && (root.left == null && root.right == null)) {
            outer.add(new ArrayList<>(inner));
        }
        // 向下递归
        findPathHelper(outer, inner, root.left, difference);
        findPathHelper(outer, inner, root.right, difference);
        // 深度遍历完一层需要回退
        inner.remove(inner.size() - 1);

    }

    public static void main(String[] args) {
        PathSum2 s = new PathSum2();
        /*
         * B-tree
         *                  5
         *                 / \
         *                4   7
         *               / \   \
         *              0   6   2
         *             /       / \
         *            2       1   6
         *           /       / \
         *          1       3   4
         *
         * Target: 15
         */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(2);
        root.left.left.left = new TreeNode(2);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(6);
        root.left.left.left.left = new TreeNode(1);
        root.right.right.left.left = new TreeNode(3);
        root.right.right.left.right = new TreeNode(4);

        TreeUtils.printDoubleLayersArrayList(s.FindPath(root, 15 ));
    }
}
