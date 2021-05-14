package data_structures.linked_list;

/*  Add below lines to RunnerClass.java run this class' methods
*               System.out.println("Linked list after deletion of the loop");
*               printLL(DeleteLoopSLL.deleteLoopIfPresent(head));
* */
public class DeleteLoopSLL {
    public static Node deleteLoopIfPresent(Node head){
        Node hare = head;
        Node tortoise = head;
        while(hare != null && hare.next != null && tortoise != null){
            hare = hare.next.next;
            tortoise = tortoise.next;
            if(hare == tortoise){
                deleteLoop(head, tortoise);
            }
        }
        return head;
    }
    private static void deleteLoop(Node head, Node node){
        Node temp = head;
        while(temp.next != node.next){
            temp = temp.next;
            node = node.next;
        }
        node.next = null;
    }
}
