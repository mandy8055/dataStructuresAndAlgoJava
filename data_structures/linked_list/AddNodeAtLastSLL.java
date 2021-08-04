package data_structures.linked_list;

/*Add below lines to RunnerClass.java run this class' methods
*           System.out.print("Linked list after adding node at the last: ");
*           AddNodeAtLastSLL.addNodeAtLast(head, 15);
*           printLL(head);
*/
public class AddNodeAtLastSLL {
    public static void addNodeAtLast(Node head, int data){
        Node newNode = new Node(data);
        if(head == null)head = newNode;
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
}
