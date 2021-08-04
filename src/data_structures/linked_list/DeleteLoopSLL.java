package data_structures.linked_list;

/*  Add below lines to RunnerClass.java run this class' methods
*               System.out.println("Linked list after deletion of the loop");
*               printLL(DeleteLoopSLL.deleteLoopIfPresent(head));
* */
public class DeleteLoopSLL {
    public static Node deleteLoopIfPresent(Node head){
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                delete(head, slow);
        }
        return head;
    }
    private static void delete(Node head, Node slow){
        if(slow == head){
            while(slow.next != head){
                slow = slow.next;
            }
            slow.next = null;
        }
        else{
            Node temp = head;
            while(temp.next != slow.next){
                temp = temp.next;
                slow = slow.next;
            }
            slow.next =  null;
        }
    }
}
