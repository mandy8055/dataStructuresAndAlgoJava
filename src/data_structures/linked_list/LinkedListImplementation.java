package data_structures.linked_list;

public class LinkedListImplementation {
    public static Node returnLL() {
        // Default LinkedList
        Node first = new Node(80);
        Node second = new Node(20);
        Node third = new Node(50);
        Node fourth = new Node(5);
        Node fifth = new Node(90);
        Node sixth = new Node(23);
        // Node Linking
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        // Uncomment below line for creating a loop. WARNING: Do not print the SLL after crating a loop. The method may fall into infinite loop.
//        sixth.next = third;
        // Returning the head of LinkedList
        return first;
    }
    public static void printLL(Node head){
        Node curr = head;
        // Base case
        if(head == null)return;
        while(curr != null){
            System.out.print(curr.data + "-->");
            curr = curr.next;
        }
        System.out.print(curr);
        System.out.println();
    }
}
