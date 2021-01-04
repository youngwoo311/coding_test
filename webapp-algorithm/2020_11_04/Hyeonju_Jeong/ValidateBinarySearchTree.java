package exam.uploaded;


import exam.TreeNode;

//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(3);
        TreeNode root = new TreeNode(2,node6, node7);
        System.out.println(isValidBST(root));
    }

//    dfs
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long maxVal, long minVal) {
        if (root == null) return true;
        if(root.val >= maxVal || root.val <= minVal ) return false;
        return isValidBST(root.left, root.val, minVal) && isValidBST(root.right, maxVal, root.val);

    }
}
