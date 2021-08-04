package data_structures.linked_list;

/*  Add below lines to RunnerClass.java run this class' methods

*  assert FindStartingPoint.findStartOfLoop(head) != null;
*        System.out.println("Data containing starting point of the loop is: " + FindStartingPoint.findStartOfLoop(head).data);*/


public class FindStartingPoint {
    public static Node findStartOfLoop(Node head){
        Node fast = head;
        Node slow = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return returnStartingPoint(slow, head);
            }
        }
        return null;
    }
    private static Node returnStartingPoint(Node node, Node head){
        Node temp = head;
        while(node != temp){
            temp = temp.next;
            node = node.next;
        }
        return node;
    }
}
