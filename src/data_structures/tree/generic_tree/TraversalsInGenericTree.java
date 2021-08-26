package data_structures.tree.generic_tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TraversalsInGenericTree {
    private static Queue<Node> q;

    public TraversalsInGenericTree() {
        q = new ArrayDeque<>();
    }

    public static void traversals(Node node) {
        // Base Case
        if (node == null) {
            return;
        }
        // Main Case
        System.out.println("Node Pre " + node.data);
        for (Node nd : node.children) {
            System.out.println("Edge Pre " + node.data + "--" + nd.data);
            traversals(nd);
            System.out.println("Edge Post " + node.data + "--" + nd.data);

        }
        System.out.println("Node Post " + node.data);
    }

    public static void levelOrder1(Node node) {
        q.add(node);
        // Acts as Marker
        Node marker = new Node();
        marker.data = Integer.MIN_VALUE;
        marker.children = null;
        q.add(marker);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == marker) { // Marker
                if (q.isEmpty()) {
                    System.out.println(".");
                    return;
                } else {
                    q.add(temp);
                }
            } else { // Data Nodes
                System.out.print(temp.data + " ");
                q.addAll(temp.children);
            }
        }
    }

    public static void levelOrder2(Node node) {
        if (q.size() == 0) {
            q.add(node);
        }
        Node visitedNode = q.remove();
        System.out.print(visitedNode.data + " ");
        q.addAll(visitedNode.children);
        if (q.size() == 0) {
            System.out.print(".");
        } else {
            levelOrder2(q.peek());
        }
    }

    public static void levelOrderLineWise1(Node node) {
        Queue<Node> q1 = new ArrayDeque<>();
        Queue<Node> q2 = new ArrayDeque<>();
        q1.add(node);
        while (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                Node temp = q1.remove();
                System.out.print(temp.data + " ");
                q2.addAll(temp.children);
            }
            System.out.println();
            q1 = q2;
            q2 = new ArrayDeque<>();
        }
    }

    public static void levelOrderZigZag(Node node) {
        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();
        int level = 1;
        ms.push(node);
        while (!ms.isEmpty()) {
            Node temp = ms.pop();
            System.out.print(temp.data + " ");
            if (level % 2 == 1) {
                for (Node nd : temp.children) {
                    cs.push(nd);
                }
            } else {
                for (int i = temp.children.size() - 1; i >= 0; i--) {
                    cs.push(temp.children.get(i));
                }
            }
            if (ms.isEmpty()) {
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }
}
