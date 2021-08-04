package data_structures.linked_list;

/* Add below lines to RunnerClass.java run this class' methods
        // Adding dummy data for testing duplicate removal algorithm
        AddNodeAtLastSLL.addNodeAtLast(head, 15);
        AddNodeAtLastSLL.addNodeAtLast(head, 15);
        AddNodeAtLastSLL.addNodeAtLast(head, 15);
        AddNodeAtLastSLL.addNodeAtLast(head, 26);
        AddNodeAtLastSLL.addNodeAtLast(head, 37);
        AddNodeAtLastSLL.addNodeAtLast(head, 37);
        printLL(head);
        // Sorting a linked list
        Node sortedSLL = MergeSortSLL.mergeSortLL(head);
        // Applying the algorithm
        System.out.print("Linked list after removing duplicates: ");
        printLL(RemoveDuplicatesInSortedSLL.removeDuplicates(sortedSLL));

*/
public class RemoveDuplicatesInSortedSLL {
    public static Node removeDuplicates(Node head) {
        if(head == null)return null;
        Node temp = head;
        while(temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
}
