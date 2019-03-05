package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ConstructBinaryTreeByPreAndIn {

    /**
     * 时间复杂度：O(n ^ 2)
     * 空间复杂度：O(1)
     */
    public TreeNode construct(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) return null;
        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootValue = pre[preStart];
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (in[i] == rootValue) {
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = construct(pre, preStart + 1, preStart + i - inStart, in, inStart,  i - 1);
        root.right = construct(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
        return root;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public TreeNode constructUsingMap(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return constructUsingMap(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    private TreeNode constructUsingMap(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootValue = pre[preStart];
        int i = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left = constructUsingMap(pre, preStart + 1, preStart + i - inStart, in, inStart,  i - 1, map);
        root.right = constructUsingMap(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd, map);
        return root;
    }


    public static void main(String[] args) {
        ConstructBinaryTreeByPreAndIn constructor = new ConstructBinaryTreeByPreAndIn();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = constructor.constructUsingMap(pre, in);

        BinaryTreeLevelOrderTraversal levelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        TreeUtils.print(levelOrderTraversal.levelOrder(root));
    }
}
