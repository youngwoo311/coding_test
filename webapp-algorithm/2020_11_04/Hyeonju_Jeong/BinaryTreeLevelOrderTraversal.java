package exam.complete;


//https://leetcode.com/problems/binary-tree-level-order-traversal/

import exam.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        answer.add(list);

        levelOrder(root, 1, answer);
        return answer;
    }

    public void levelOrder(TreeNode root, int depth, List<List<Integer>> answer) {
        if(answer.size() < depth + 1) {
            ArrayList<Integer> list = new ArrayList<>();
            if(root.left != null) list.add(root.left.val);
            if(root.right != null) list.add(root.right.val);
            if(list.size() != 0 ) answer.add(list);
        }else {
            List<Integer> list = answer.get(depth + 1);
            if(root.left != null) list.add(root.left.val);
            if(root.right != null) list.add(root.right.val);
        }
        if(root.left != null) levelOrder(root.left, depth + 1, answer);
        if(root.right != null) levelOrder(root.right, depth + 1, answer);
    }
}
