package leet_code_problems.medium;


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode t1 = ans;
        ListNode t2 = ans;
        for (int i = 1; i <= n; i++) {
            t1 = t1.next;
        }
        while (t1.next != null) {
            t1 = t1.next;
            t2 = t2.next;
        }
        t2.next = t2.next.next;
        return ans.next;
    }
}
