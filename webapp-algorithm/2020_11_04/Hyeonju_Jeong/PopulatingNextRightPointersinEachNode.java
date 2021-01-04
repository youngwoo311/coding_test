package exam.uploaded;


//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

import exam.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {
        Node node7 = new Node(7);
        Node node6 = new Node(6);

        Node node5 = new Node(5);
        Node node4 = new Node(4);

        Node node3 = new Node(3,node6,node7,null);
        Node node2 = new Node(2,node4,node5,null);

        Node node1 = new Node(1,node2, node3,null);

        connect(node1);

        System.out.println(node1.val);


    }



    public static Node connect(Node root) {

//        The root node doesn't have a next node
//        looping with root's children
        Queue<ForFindNodeSet> queue = new ArrayDeque<>();

//        Exception Handling
        if (root == null || root.left == null) return root;

        //        0 = left , 1 = right child
        queue.add(new ForFindNodeSet(root.left, root,0));
        queue.add(new ForFindNodeSet(root.right, root,1));

        while (queue.size() > 0) {
            ForFindNodeSet nowSet = queue.poll();

//            statusVal == 0
            if (nowSet.statusVal == 0) nowSet.nowNode.next = nowSet.parentNode.right;

//            statusVal == 1
            else if (nowSet.parentNode.next != null) nowSet.nowNode.next= nowSet.parentNode.next.left;

//            children check
            if (nowSet.nowNode.left != null) {
                queue.add(new ForFindNodeSet(nowSet.nowNode.left, nowSet.nowNode, 0));
                queue.add(new ForFindNodeSet(nowSet.nowNode.right, nowSet.nowNode, 1));
            }


        }



        return root;
    }

    private static class ForFindNodeSet {
        private Node parentNode;
        private Node nowNode;
        private int statusVal;

        public ForFindNodeSet(Node nowNode, Node parentNode,int statusVal) {
            this.nowNode = nowNode;
            this.parentNode=parentNode;
            this.statusVal = statusVal;
        }

        public Node getNowNode() {
            return nowNode;
        }

        public void setNowNode(Node nowNode) {
            this.nowNode = nowNode;
        }

        public int getStatusVal() {
            return statusVal;
        }

        public void setStatusVal(int statusVal) {
            this.statusVal = statusVal;
        }

        public Node getParentNode() {
            return parentNode;
        }

        public void setParentNode(Node parentNode) {
            this.parentNode = parentNode;
        }
    }
}
