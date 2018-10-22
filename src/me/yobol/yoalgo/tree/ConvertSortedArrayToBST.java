package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

/**
 * Description:
 * Given an array where elements are sorted in ascending order,converting it to a height balanced BST.
 * For this problem,a height-balanced BST is defined as a binary tree
 * in which the height of the two sub-trees of every node never differ by more than 1.
 *
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *       0
 *      / \
 *    -3  9
 *    /  /
 * -10  5
 */
public class ConvertSortedArrayToBST {

    private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, start, mid - 1);
        root.right = sortedArrayToBSTHelper( nums, mid + 1, end);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBST arrayToBST = new ConvertSortedArrayToBST();
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode root = arrayToBST.sortedArrayToBST(nums);
        TreeUtils.print(new BinaryTreeLevelOrderTraversal().levelOrder(root));
        System.out.println(new BalancedBinaryTree().dfsIsBalanced(root));


        nums = new int[]{-10, -3, 0, 2 ,5, 9};
        root = arrayToBST.sortedArrayToBST(nums);
        TreeUtils.print(new BinaryTreeLevelOrderTraversal().levelOrder(root));
        System.out.println(new BalancedBinaryTree().dfsIsBalanced(root));
    }
}
