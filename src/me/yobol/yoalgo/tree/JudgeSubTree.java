package me.yobol.yoalgo.tree;

import me.yobol.yoalgo.basic.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class JudgeSubTree {

    // 判断根节点为root1的二叉树是否有以root2为根节点的子树
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;

        return isSubTree(root1, root2) || hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;

        if (root1.val == root2.val) {
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        JudgeSubTree s = new JudgeSubTree();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        System.out.println(s.hasSubTree(root1, root2));
    }
}
