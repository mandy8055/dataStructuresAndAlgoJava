package data_structures.tree.generic_tree;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class GenericTreePrinter {

    public static void display(@NotNull Node node) {
        StringBuilder str = new StringBuilder(node.data + " -> ");
        for (Node child : node.children) {
            str.append(child.data).append(", ");
        }
        str.append(".");
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int @NotNull [] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int j : arr) {
            if (j == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = j;

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }
        return root;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        display(root);
    }

}