package algorithm;

public class ReverseList {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newList = null;
        while (head.next != null) {
            ListNode tmp = new ListNode(head.next.val);
            tmp.next = newList;
            newList = tmp;
            head = head.next;
        }
        return newList;
    }
}
