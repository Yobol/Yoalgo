package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

/**
 * Description:
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
 *       3
 *      / \
 *     9  20
 *       /  \
 *      15   7
 * Return true.
 *
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *         1
 *       / \
 *      2  2
 *    / \
 *   3  3
 *  / \
 * 4   4
 * Return false.
 */
public class BalancedBinaryTree {

    public final static int NOT_BALANCED = -1;

    private int depth(TreeNode root){
        if (root == null) return 0;

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    /**
     * 时间复杂度：
     *  O(n^2)
     * 思路：
     *  自顶向下，从根节点开始，计算每一个结点的平衡因子（先计算出左右子结点的高度）
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(depth(root.left) - depth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    /**
     * If the sub tree of the current node is not balanced,this recursive function will return a negative value.
     * Otherwise,it will return a non-negative value as the height of the current node.
     *
     * @param root
     * @return
     */
    private int dfsHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == NOT_BALANCED) return NOT_BALANCED;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == NOT_BALANCED) return NOT_BALANCED;

        if (Math.abs(leftHeight - rightHeight) > 1) return NOT_BALANCED;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * If dfsHeight(root) returns a non-negative value,it represents the height of the root.
     * Otherwise,it represents that the given node root is not balanced.
     *
     * @param root
     * @return
     */
    public boolean dfsIsBalanced(TreeNode root) {
        return dfsHeight(root) != NOT_BALANCED;
    }



    public static void main(String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(bbt.isBalanced(root));
        System.out.println(bbt.dfsIsBalanced(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        System.out.println(bbt.isBalanced(root));
        System.out.println(bbt.dfsIsBalanced(root));
    }
}
