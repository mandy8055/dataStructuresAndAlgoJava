package data_structures.linked_list;

public class MergeKSortedSLL {
    // Merging two sorted linked lists
    public static Node mergeSLL(Node head1, Node head2){
        Node merged = new Node(-1);
        Node temp = merged;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }



}
