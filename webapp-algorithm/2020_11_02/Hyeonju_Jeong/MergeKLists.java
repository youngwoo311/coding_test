package exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Complete
public class MergeKLists {


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

//        ListNode[] listNodes = {node1, node2};
        ListNode[] listNodes = {null};


        ListNode head = mergeKLists(listNodes);
        System.out.println("==================================");
        while(true) {
            System.out.println(head.val);
            if(head.next != null) {
                head = head.next;
            } else break;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        List<Integer> array = new ArrayList<>();
        ListNode answer;
        ListNode nowNode;
//         flatting
        for(int i = 0 ; i < lists.length; i++) {
            nowNode = lists[i];
            if(nowNode == null) continue;
            while(true) {
                array.add(nowNode.val);
                if(nowNode.next != null) nowNode = nowNode.next;
                else break;
            }
        }

//        sorting
        array.sort(Comparator.comparingInt(o -> o));

        if(array.size() < 0) return null;
        answer = new ListNode(array.get(0));
        nowNode = answer;
        for (int i = 1 ; i < array.size(); i++) {
            nowNode.next = new ListNode(array.get(i));
            nowNode = nowNode.next;
        }
        return answer;
    }
}


