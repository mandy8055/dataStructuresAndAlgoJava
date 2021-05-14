package data_structures.linked_list;

/* Add below lines to RunnerClass.java run this class' methods
*
*  System.out.println("Middle node of the given linked list has " + FindMiddleSLL.findMiddle(head).data + " as data.");
*
*/


public class FindMiddleSLL {
    public static Node findMiddle(Node head){
        // Using floyd's algorithm
        // If we initialize hare with head, then second node will be returned in case two middle nodes(total nodes are even) are present. If we initialize hare with head.next, then first node will be returned in case two middle nodes(total nodes are even) are present. This is helpful if I want to run my merge Sort logic on SLL.
        Node hare = head.next;
        Node tortoise = head;
        while(hare != null && hare.next != null){
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return tortoise;
    }
}
