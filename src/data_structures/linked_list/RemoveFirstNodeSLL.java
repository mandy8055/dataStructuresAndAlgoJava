package data_structures.linked_list;

/* Add below lines to RunnerClass.java run this class' methods
*       System.out.print("Linked list after removing the first Node: ");
*        printLL(RemoveFirstNodeSLL.removeFirstNode(head));
* */

public class RemoveFirstNodeSLL {
    public static Node removeFirstNode(Node head){
        if(head == null || head.next == null)return head;
        head = head.next;
        return head;
    }
}
