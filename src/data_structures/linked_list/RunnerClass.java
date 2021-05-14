package data_structures.linked_list;
import static data_structures.linked_list.LinkedListImplementation.*;
public class RunnerClass {

    public static void main(String[] args){
        Node head = returnLL();
        System.out.print("Linked list initially: ");
        printLL(head);

//        // Linked list after applying merge sort.
        System.out.print("Linked list after applying merge sort: ");
        Node sortedSLL = MergeSortSLL.mergeSortLL(head);
        printLL(sortedSLL);
    }
}
