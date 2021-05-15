package data_structures.linked_list;
import static data_structures.linked_list.LinkedListImplementation.*;
public class RunnerClass {

    public static void main(String[] args){
        Node head = returnLL();
        AddNodeAtLastSLL.addNodeAtLast(head, 15);
        AddNodeAtLastSLL.addNodeAtLast(head, 15);
        AddNodeAtLastSLL.addNodeAtLast(head, 20);
        AddNodeAtLastSLL.addNodeAtLast(head, 26);
        System.out.print("Linked list initially: ");
        printLL(head);
        System.out.print("Linked list after removing duplicates: ");
        printLL(RemoveDuplicatesInUnsortedSLL.removeDuplicates(head));
    }
}
