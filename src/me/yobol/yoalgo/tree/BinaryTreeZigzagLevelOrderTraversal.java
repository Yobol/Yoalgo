package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Description：
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *       3
 *      / \
 *     9  20
 *       /  \
 *      15   7
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     * Iterative
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> outer = new LinkedList<>();
        if (root == null) return outer;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            List<Integer> inner = new LinkedList<>();

            int size = stack.size();
            for (int i = 0;i < size;i++) {
                TreeNode current = stack.pop();
                inner.add(current.val);
                if (current.left != null) {
                    temp.push(current.left);
                }
                if (current.right != null) {
                    temp.push(current.right);
                }
            }
            stack.addAll(temp);
            temp.clear();
            outer.add(inner);
        }

        return outer;
    }


    /**
     * Recursive
     *
     * @param
     */
    public List<List<Integer>> zigzagLeverOrderRecursive(TreeNode root) {
        List<List<Integer>> outer = new LinkedList<>();
        traverse(outer, root, 0);
        return outer;
    }

    private void traverse(List<List<Integer>> outer, TreeNode root, int level) {
        if (root == null) return;
        if (outer.size() <= level) outer.add(new LinkedList<>()); // 根据树的遍历深度创建相应层次的列表来存储元素

        if (level % 2 == 0) {
            outer.get(level).add(root.val); // 若当前层次编号为偶数（实际层次为奇数），则获取相应层次的列表以逆序存储元素
        } else {
            outer.get(level).add(0, root.val); // 若当前层次为奇数（实际层次为偶数），则获取相应层次的列表以顺序序存储元素
        }

        traverse(outer, root.left, level + 1);
        traverse(outer, root.right, level + 1);
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal btzlot = new BinaryTreeZigzagLevelOrderTraversal();

        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.left.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

        TreeUtils.print(btzlot.zigzagLevelOrder(t1));
        TreeUtils.print(btzlot.zigzagLeverOrderRecursive(t1));
    }
}
