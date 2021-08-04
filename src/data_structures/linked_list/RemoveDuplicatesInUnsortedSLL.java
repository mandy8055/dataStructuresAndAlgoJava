package data_structures.linked_list;

import java.util.HashSet;

public class RemoveDuplicatesInUnsortedSLL {
    public static Node removeDuplicates(Node head){
        if(head == null || head.next == null)return head;
        HashSet<Integer> hashSet = new HashSet<>();
        Node previous = null;
        Node current = head;
        while(current != null){
            if(hashSet.contains(current.data)){
                previous.next = current.next;
            }
            else{
                hashSet.add(current.data);
                previous = current;
            }
            current = current.next;
        }
        return head;
    }
}
