package data_structures.linked_list;

/* Add below lines to RunnerClass.java run this class' methods

*               System.out.print("Linked list after reversal: ");
*               printLL(ReverseSLL.iterativeReverse(head));
*               printLL(ReverseSLL.recursiveReverse(head));
* */



public class ReverseSLL {
    public static Node iterativeReverse(Node head){
        Node current = head;
        Node previous = null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    public static Node recursiveReverse(Node head){
        if(head == null || head.next == null) return head;
        Node rest = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
}
