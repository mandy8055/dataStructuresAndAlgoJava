package data_structures.tree;

import data_structures.tree.binary_tree.*;

public class RunnerClass {
    public static void main(String[] args){

        System.out.println("Tree structure: ");
        BTreePrinter.printNode(test2());
//        System.out.println("Level order traversal of the tree is: ");
//        LevelOrderTraversalTree.getLevelOrder(test2());
//        ReverseOfLevelOrderTraversalTree.printReverseOfLevelOrder(test2());
//        System.out.println("The height of the given tree is: " + HeightOfBinaryTree.computeMaxHeight(test2()));
//        System.out.println("The diameter of the given tree is: " + DiameterOfBinaryTree.getDiameter(test2()));
        System.out.println("Preorder traversal of the given tree is: ");
        DepthOrderTreeTraversals.postorderIterative(test2());

    }

    private static TreeNode<Integer> test1() {
        TreeNode<Integer> root = new TreeNode<>(2);
        TreeNode<Integer> n11 = new TreeNode<>(7);
        TreeNode<Integer> n12 = new TreeNode<>(5);
        TreeNode<Integer> n21 = new TreeNode<>(2);
        TreeNode<Integer> n22 = new TreeNode<>(6);
        TreeNode<Integer> n23 = new TreeNode<>(3);
        TreeNode<Integer> n24 = new TreeNode<>(6);
        TreeNode<Integer> n31 = new TreeNode<>(5);
        TreeNode<Integer> n32 = new TreeNode<>(8);
        TreeNode<Integer> n33 = new TreeNode<>(4);
        TreeNode<Integer> n34 = new TreeNode<>(5);
        TreeNode<Integer> n35 = new TreeNode<>(8);
        TreeNode<Integer> n36 = new TreeNode<>(4);
        TreeNode<Integer> n37 = new TreeNode<>(5);
        TreeNode<Integer> n38 = new TreeNode<>(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

    private static TreeNode<Integer> test2() {
        TreeNode<Integer> root = new TreeNode<>(2);
        TreeNode<Integer> n11 = new TreeNode<>(7);
        TreeNode<Integer> n12 = new TreeNode<>(5);
        TreeNode<Integer> n21 = new TreeNode<>(2);
        TreeNode<Integer> n22 = new TreeNode<>(6);
        TreeNode<Integer> n23 = new TreeNode<>(9);
        TreeNode<Integer> n31 = new TreeNode<>(5);
        TreeNode<Integer> n32 = new TreeNode<>(8);
        TreeNode<Integer> n33 = new TreeNode<>(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }
}
