package data_structures.linked_list;

/* Add below lines to RunnerClass.java run this class' methods

*                if(DetectCycleSLL.detectLoopOrCycle(head))
*                    System.out.println("Given Singly linked list contains loop or cycle...");
*                else
*                    System.out.println("Given Singly linked list does not contain loop or cycle...");
* */


public class DetectCycleSLL {
    public static boolean detectLoopOrCycle(Node head){
        Node hare = head;
        Node tortoise = head;
        while(tortoise != null && hare != null && hare.next != null){
            hare = hare.next.next;
            tortoise = tortoise.next;
            if(hare == tortoise)
                return true;
        }
        return false;
    }
}
