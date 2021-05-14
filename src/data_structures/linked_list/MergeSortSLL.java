package data_structures.linked_list;

public class MergeSortSLL {
    public static Node mergeSortLL(Node head){
        if(head.next == null){
            return head;
        }
        // Find middle node of the linked list
        Node middle = FindMiddleSLL.findMiddle(head);
        Node head2 = middle.next;
        middle.next = null;
        // Perform left side merge Sort
        Node newHead1 = mergeSortLL(head);
        // Perform right side merge Sort
        Node newHead2 = mergeSortLL(head2);
        // Merge the list
        Node finalHead = MergeKSortedSLL.mergeSLL(newHead1, newHead2);
        return finalHead;
    }
}
