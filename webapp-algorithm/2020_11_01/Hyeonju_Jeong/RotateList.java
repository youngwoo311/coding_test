package exam;
//https://leetcode.com/problems/rotate-list/
//Complete
public class RotateList {
    public static void main(String[] args) {
//        Input: 1->2->3->4->5->NULL, k = 2
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode head = rotateRight(node1, 0);

        while(true) {
            System.out.println(head.val);
            if(head.next != null) {
                head = head.next;
            } else break;
        }

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode answer ;
        ListNode next = head;
        int length = 0;
        while(true) {
            length++;
            if(next.next != null) {
                next = next.next;
            } else break;
        }

//       if k = 2 , The head goes back 2 steps
        k = k % length ;

//        No change
        if(k ==  0) return head;
//         etc
        next.next= head;
        next = head;
        for(int i = 0 ; i < length - k - 1; i++) {
            next = next.next;
        }
        answer = next.next;
        next.next = null;

        return answer;
    }
}

